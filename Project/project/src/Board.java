import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame {

    private JTextField textInput, vigenereKeyInput, railFenceKeyInput, playfairKeyInput,
            rowTranspositionKeyInput, affineKeyAInput, affineKeyBInput, hillKeyInput;
    private JTextArea outputArea;

    public Board() {
        setTitle("Cipher Board");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(10, 2));

        textInput = new JTextField();
        inputPanel.add(new JLabel("Text:"));
        inputPanel.add(textInput);

        vigenereKeyInput = new JTextField();
        inputPanel.add(new JLabel("Vigenere Key:"));
        inputPanel.add(vigenereKeyInput);

        railFenceKeyInput = new JTextField();
        inputPanel.add(new JLabel("Rail Fence Key:"));
        inputPanel.add(railFenceKeyInput);

        playfairKeyInput = new JTextField();
        inputPanel.add(new JLabel("Playfair Key:"));
        inputPanel.add(playfairKeyInput);

        rowTranspositionKeyInput = new JTextField();
        inputPanel.add(new JLabel("Row Transposition Key:"));
        inputPanel.add(rowTranspositionKeyInput);

        affineKeyAInput = new JTextField();
        inputPanel.add(new JLabel("Affine Key A:"));
        inputPanel.add(affineKeyAInput);

        affineKeyBInput = new JTextField();
        inputPanel.add(new JLabel("Affine Key B:"));
        inputPanel.add(affineKeyBInput);

        hillKeyInput = new JTextField();
        inputPanel.add(new JLabel("Hill Key:"));
        inputPanel.add(hillKeyInput);

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        // Caesar Cipher
        JButton caesarEncryptButton = new JButton("Caesar Encrypt");
        caesarEncryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textInput.getText();
                String result = CaeserCipher.encrypt(text, 3);
                outputArea.setText(result);
            }
        });
        buttonPanel.add(caesarEncryptButton);

        JButton caesarDecryptButton = new JButton("Caesar Decrypt");
        caesarDecryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textInput.getText();
                String result = CaeserCipher.decrypt(text, 3);
                outputArea.setText(result);
            }
        });
        buttonPanel.add(caesarDecryptButton);

        // Vigenere Cipher
        JButton vigenereEncryptButton = new JButton("Vigenere Encrypt");
        vigenereEncryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textInput.getText();
                String key = vigenereKeyInput.getText();
                String result = VigenereCipher.encrypt(text, key);
                outputArea.setText(result);
            }
        });
        buttonPanel.add(vigenereEncryptButton);

        JButton vigenereDecryptButton = new JButton("Vigenere Decrypt");
        vigenereDecryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textInput.getText();
                String key = vigenereKeyInput.getText();
                String result = VigenereCipher.decrypt(text, key);
                outputArea.setText(result);
            }
        });
        buttonPanel.add(vigenereDecryptButton);

        // Rail Fence Cipher
        JButton railFenceEncryptButton = new JButton("Rail Fence Encrypt");
        railFenceEncryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textInput.getText();
                int key = Integer.parseInt(railFenceKeyInput.getText());
                String result = RailFenceCipher.encrypt(text, key);
                outputArea.setText(result);
            }
        });
        buttonPanel.add(railFenceEncryptButton);

        JButton railFenceDecryptButton = new JButton("Rail Fence Decrypt");
        railFenceDecryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textInput.getText();
                int key = Integer.parseInt(railFenceKeyInput.getText());
                String result = RailFenceCipher.decrypt(text, key);
                outputArea.setText(result);
            }
        });
        buttonPanel.add(railFenceDecryptButton);

        // Playfair Cipher
        JButton playfairEncryptButton = new JButton("Playfair Encrypt");
        playfairEncryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textInput.getText();
                String key = playfairKeyInput.getText();
                String result = PlayfairCipher.encrypt(text, key);
                outputArea.setText(result);
            }
        });
        buttonPanel.add(playfairEncryptButton);

        JButton playfairDecryptButton = new JButton("Playfair Decrypt");
        playfairDecryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textInput.getText();
                String key = playfairKeyInput.getText();
                String result = PlayfairCipher.decrypt(text, key);
                outputArea.setText(result);
            }
        });
        buttonPanel.add(playfairDecryptButton);

        // Row Transposition Cipher
        JButton rowTranspositionEncryptButton = new JButton("Row Transposition Encrypt");
        rowTranspositionEncryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textInput.getText();
                String key = rowTranspositionKeyInput.getText();
                String result = RowTranspositionCipher.encrypt(text, key);
                outputArea.setText(result);
            }
        });
        buttonPanel.add(rowTranspositionEncryptButton);

        JButton rowTranspositionDecryptButton = new JButton("Row Transposition Decrypt");
        rowTranspositionDecryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textInput.getText();
                String key = rowTranspositionKeyInput.getText();
                String result = RowTranspositionCipher.decrypt(text, key);
                outputArea.setText(result);
            }
        });
        buttonPanel.add(rowTranspositionDecryptButton);

        // Affine Cipher
        JButton affineEncryptButton = new JButton("Affine Encrypt");
        affineEncryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textInput.getText();
                int a = Integer.parseInt(affineKeyAInput.getText());
                int b = Integer.parseInt(affineKeyBInput.getText());
                String result = AffineCipher.encrypt(text, a, b);
                outputArea.setText(result);
            }
        });
        buttonPanel.add(affineEncryptButton);

        JButton affineDecryptButton = new JButton("Affine Decrypt");
        affineDecryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textInput.getText();
                int a = Integer.parseInt(affineKeyAInput.getText());
                int b = Integer.parseInt(affineKeyBInput.getText());
                String result = AffineCipher.decrypt(text, a, b);
                outputArea.setText(result);
            }
        });
        buttonPanel.add(affineDecryptButton);

        // Hill Cipher
        JButton hillEncryptButton = new JButton("Hill Encrypt");
        hillEncryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textInput.getText();
                String key = hillKeyInput.getText();
                String result = HillCipher.encrypt(text, key);
                outputArea.setText(result);
            }
        });
        buttonPanel.add(hillEncryptButton);

        JButton hillDecryptButton = new JButton("Hill Decrypt");
        hillDecryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textInput.getText();
                String key = hillKeyInput.getText();
                String result = HillCipher.decrypt(text, key);
                outputArea.setText(result);
            }
        });
        buttonPanel.add(hillDecryptButton);

        add(buttonPanel, BorderLayout.CENTER);

        outputArea = new JTextArea();
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Board board = new Board();
            board.setVisible(true);
        });
    }
}
