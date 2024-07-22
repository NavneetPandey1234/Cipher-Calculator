public class OneTimePadCipher {

    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char k = key.charAt(i % key.length());
            result.append((char) (c ^ k));
        }
        return result.toString();
    }

    public static String decrypt(String text, String key) {
        return encrypt(text, key); // One-time pad decryption is identical to encryption
    }
}
