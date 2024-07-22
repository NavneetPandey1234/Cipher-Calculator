public class PlayfairCipher {

    private static char[][] generateKeyTable(String key) {
        key = key.replaceAll("J", "I").toUpperCase();
        StringBuilder keyBuilder = new StringBuilder(key);
        String alphabets = "ABCDEFGHIKLMNOPQRSTUVWXYZ";

        for (char c : alphabets.toCharArray()) {
            if (keyBuilder.indexOf(String.valueOf(c)) == -1) {
                keyBuilder.append(c);
            }
        }

        char[][] keyTable = new char[5][5];
        for (int i = 0, k = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                keyTable[i][j] = keyBuilder.charAt(k++);
            }
        }

        return keyTable;
    }

    private static String formatText(String text) {
        StringBuilder formattedText = new StringBuilder(
                text.toUpperCase().replaceAll("[^A-Z]", "").replaceAll("J", "I"));
        for (int i = 0; i < formattedText.length() - 1; i += 2) {
            if (formattedText.charAt(i) == formattedText.charAt(i + 1)) {
                formattedText.insert(i + 1, 'X');
            }
        }
        if (formattedText.length() % 2 != 0) {
            formattedText.append('X');
        }
        return formattedText.toString();
    }

    public static String encrypt(String text, String key) {
        char[][] keyTable = generateKeyTable(key);
        text = formatText(text);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);
            int[] posA = findPosition(keyTable, a);
            int[] posB = findPosition(keyTable, b);

            if (posA[0] == posB[0]) {
                result.append(keyTable[posA[0]][(posA[1] + 1) % 5]);
                result.append(keyTable[posB[0]][(posB[1] + 1) % 5]);
            } else if (posA[1] == posB[1]) {
                result.append(keyTable[(posA[0] + 1) % 5][posA[1]]);
                result.append(keyTable[(posB[0] + 1) % 5][posB[1]]);
            } else {
                result.append(keyTable[posA[0]][posB[1]]);
                result.append(keyTable[posB[0]][posA[1]]);
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, String key) {
        char[][] keyTable = generateKeyTable(key);
        text = formatText(text);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);
            int[] posA = findPosition(keyTable, a);
            int[] posB = findPosition(keyTable, b);

            if (posA[0] == posB[0]) {
                result.append(keyTable[posA[0]][(posA[1] + 4) % 5]);
                result.append(keyTable[posB[0]][(posB[1] + 4) % 5]);
            } else if (posA[1] == posB[1]) {
                result.append(keyTable[(posA[0] + 4) % 5][posA[1]]);
                result.append(keyTable[(posB[0] + 4) % 5][posB[1]]);
            } else {
                result.append(keyTable[posA[0]][posB[1]]);
                result.append(keyTable[posB[0]][posA[1]]);
            }
        }

        return result.toString();
    }

    private static int[] findPosition(char[][] keyTable, char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keyTable[i][j] == c) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }
}
