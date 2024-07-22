import java.util.Arrays;

public class RowTranspositionCipher {

    public static String encrypt(String text, String key) {
        int[] keyOrder = getKeyOrder(key);
        int columns = key.length();
        int rows = (int) Math.ceil((double) text.length() / columns);
        char[][] grid = new char[rows][columns];

        for (int i = 0; i < text.length(); i++) {
            grid[i / columns][i % columns] = text.charAt(i);
        }

        StringBuilder result = new StringBuilder();
        for (int col : keyOrder) {
            for (int row = 0; row < rows; row++) {
                if (grid[row][col] != '\0') {
                    result.append(grid[row][col]);
                }
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, String key) {
        int[] keyOrder = getKeyOrder(key);
        int columns = key.length();
        int rows = (int) Math.ceil((double) text.length() / columns);
        char[][] grid = new char[rows][columns];

        int idx = 0;
        for (int col : keyOrder) {
            for (int row = 0; row < rows; row++) {
                if (idx < text.length()) {
                    grid[row][col] = text.charAt(idx++);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (grid[row][col] != '\0') {
                    result.append(grid[row][col]);
                }
            }
        }

        return result.toString();
    }

    private static int[] getKeyOrder(String key) {
        int[] order = new int[key.length()];
        Character[] chars = new Character[key.length()];
        for (int i = 0; i < key.length(); i++) {
            chars[i] = key.charAt(i);
        }
        Arrays.sort(chars);
        for (int i = 0; i < key.length(); i++) {
            order[i] = key.indexOf(chars[i]);
        }
        return order;
    }
}
