public class AffineCipher {

    public static String encrypt(String text, int a, int b) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((a * (c - base) + b) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int a, int b) {
        StringBuilder result = new StringBuilder();
        int aInv = modInverse(a, 26);
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((aInv * (c - base - b + 26)) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    private static int modInverse(int a, int m) {
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 0) {
                return x;
            }
        }
        return 1; // Should not reach here for valid a
    }
}
