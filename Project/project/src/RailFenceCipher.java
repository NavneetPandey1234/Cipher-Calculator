public class RailFenceCipher {

    // Encrypts a given plaintext using the Rail Fence cipher
    public static String encrypt(String plaintext, int rails) {
        char[][] matrix = new char[rails][plaintext.length()];
        int row = 0;
        boolean down = false;

        // Fill the matrix with placeholders
        for (int i = 0; i < plaintext.length(); i++) {
            if (row == 0 || row == rails - 1) {
                down = !down;
            }
            matrix[row][i] = plaintext.charAt(i);
            row += down ? 1 : -1;
        }

        // Read cipher text row by row
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < plaintext.length(); j++) {
                if (matrix[i][j] != '\u0000') {
                    ciphertext.append(matrix[i][j]);
                }
            }
        }

        return ciphertext.toString();
    }

    // Decrypts a given ciphertext using the Rail Fence cipher
    public static String decrypt(String ciphertext, int rails) {
        if (rails == 1)
            return ciphertext;

        // Create the matrix to decipher the rail fence pattern
        char[][] matrix = new char[rails][ciphertext.length()];

        // Initialize variables for the filling pattern
        int row = 0;
        boolean down = false;

        // Mark the positions to place the characters
        for (int i = 0; i < ciphertext.length(); i++) {
            matrix[row][i] = '*';
            if (row == 0 || row == rails - 1)
                down = !down;
            row += down ? 1 : -1;
        }

        // Fill the matrix with the ciphertext characters
        int index = 0;
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < ciphertext.length(); j++) {
                if (matrix[i][j] == '*' && index < ciphertext.length()) {
                    matrix[i][j] = ciphertext.charAt(index++);
                }
            }
        }

        // Read the matrix in the zigzag order to construct the plaintext
        StringBuilder plaintext = new StringBuilder();
        row = 0;
        down = false;

        for (int i = 0; i < ciphertext.length(); i++) {
            plaintext.append(matrix[row][i]);
            if (row == 0 || row == rails - 1)
                down = !down;
            row += down ? 1 : -1;
        }

        return plaintext.toString();
    }
}