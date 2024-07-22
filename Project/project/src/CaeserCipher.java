public class CaeserCipher {

    public static String encrypt(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder();

        for (char letter : plaintext.toCharArray()) {
            if (Character.isLetter(letter)) {
                char base = Character.isUpperCase(letter) ? 'A' : 'a';
                char encryptedLetter = (char) ((letter - base + shift) % 26 + base);
                ciphertext.append(encryptedLetter);
            } else {
                ciphertext.append(letter); // Non-letters are not encrypted
            }
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int shift) {
        return ciphertext;
    }
}