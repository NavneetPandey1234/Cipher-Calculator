import java.util.Arrays;

public class HillCipher {

    public static String encrypt(String text, String key) {
        int[][] keyMatrix = getKeyMatrix(key);
        int[] textVector = getTextVector(text);

        int[] encryptedVector = multiplyMatrixVector(keyMatrix, textVector);

        return vectorToText(encryptedVector);
    }

    public static String decrypt(String text, String key) {
        int[][] keyMatrix = getKeyMatrix(key);
        int[][] inverseMatrix = getInverseMatrix(keyMatrix);
        int[] textVector = getTextVector(text);

        int[] decryptedVector = multiplyMatrixVector(inverseMatrix, textVector);

        return vectorToText(decryptedVector);
    }

    private static int[][] getKeyMatrix(String key) {
        int[][] keyMatrix = new int[2][2];
        int k = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                keyMatrix[i][j] = key.charAt(k) - 'A';
                k++;
            }
        }
        return keyMatrix;
    }

    private static int[] getTextVector(String text) {
        int[] textVector = new int[2];
        for (int i = 0; i < 2; i++) {
            textVector[i] = text.charAt(i) - 'A';
        }
        return textVector;
    }

    private static int[] multiplyMatrixVector(int[][] matrix, int[] vector) {
        int[] result = new int[2];
        for (int i = 0; i < 2; i++) {
            result[i] = 0;
            for (int j = 0; j < 2; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
            result[i] = result[i] % 26;
            if (result[i] < 0) {
                result[i] += 26;
            }
        }
        return result;
    }

    private static String vectorToText(int[] vector) {
        StringBuilder text = new StringBuilder();
        for (int val : vector) {
            text.append((char) (val + 'A'));
        }
        return text.toString();
    }

    private static int[][] getInverseMatrix(int[][] matrix) {
        // Implement the method to find the inverse of a 2x2 matrix
        // For simplicity, let's assume the determinant is not zero and there's always
        // an inverse
        int determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        determinant = modInverse(determinant, 26);

        int[][] inverseMatrix = new int[2][2];
        inverseMatrix[0][0] = matrix[1][1] * determinant % 26;
        inverseMatrix[1][1] = matrix[0][0] * determinant % 26;
        inverseMatrix[0][1] = -matrix[0][1] * determinant % 26;
        inverseMatrix[1][0] = -matrix[1][0] * determinant % 26;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (inverseMatrix[i][j] < 0) {
                    inverseMatrix[i][j] += 26;
                }
            }
        }

        return inverseMatrix;
    }

    private static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return 1; // In case there is no modular inverse, this is a fallback
    }
}
