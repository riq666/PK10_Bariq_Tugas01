package pk10_tugas01_12.pkg20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Typing Tutor
 * @author Bariq 03/07-2024
 */

public class TypingTutor extends JFrame 
{

    private JTextArea textArea;
    private Map<String, JButton> keyMap;
    private final Color originalColor = new JButton().getBackground();
    private final Color highlightColor = Color.YELLOW;

    public TypingTutor() 
    {
        // Mengatur frame
        setTitle("Aplikasi Mengetik");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Membuat area teks
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 36));
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.NORTH);

        // Membuat label informasi
        JLabel infoLabel = new JLabel("<html>Ketik beberapa teks menggunakan keyboard Anda. Tombol yang Anda tekan akan disorot dan teks akan ditampilkan.<br>Catatan: Mengklik tombol dengan mouse Anda tidak akan melakukan tindakan apa pun.</html>");
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        add(infoLabel, BorderLayout.SOUTH);

        // Membuat panel untuk keyboard
        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setLayout(new GridBagLayout());

        // Membuat peta untuk menyimpan tombol keyboard
        keyMap = new HashMap<>();

        // Teks tombol keyboard
        String[][] keyTexts = 
        {
            {"~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=", "Backspace"},
            {"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\"},
            {"Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "'", "Enter"},
            {"Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "/", "Shift"},
            {"", "", "", "Space", "", "", "", "", "", "", "", ""},
        };

        // Membuat tombol keyboard dan menambahkannya ke panel dan peta
        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < keyTexts.length; row++) 
        {
            for (int col = 0; col < keyTexts[row].length; col++) 
            {
                if (!keyTexts[row][col].isEmpty()) {
                    JButton button = new JButton(keyTexts[row][col]);
                    button.setFont(new Font("Arial", Font.PLAIN, 24));
                    gbc.gridx = col;
                    gbc.gridy = row;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weightx = 1.0;
                    gbc.weighty = 1.0;
                    gbc.fill = GridBagConstraints.BOTH;

                    // Mengatur lebar tombol tertentu
                    if (keyTexts[row][col].equals("Backspace")) 
                    {
                        gbc.gridwidth = 2;
                    }
                    else if (keyTexts[row][col].equals("Tab")) 
                    {
                        gbc.gridwidth = 1;
                    }
                    else if (keyTexts[row][col].equals("Caps")) 
                    {
                        gbc.gridwidth = 1;
                    }
                    else if (keyTexts[row][col].equals("Enter")) 
                    {
                        gbc.gridwidth = 2;
                    }
                    else if (keyTexts[row][col].equals("Shift")) 
                    {
                        gbc.gridwidth = 2;
                    }
                    else if (keyTexts[row][col].equals("Space")) 
                    {
                        gbc.gridwidth = 6;
                    }

                    keyboardPanel.add(button, gbc);
                    keyMap.put(keyTexts[row][col], button);
                }
            }
        }

        // Menambahkan tombol panah ke pojok kanan bawah
        String[] arrowKeys = {"Up", "Left", "Down", "Right"};
        JButton[] arrowButtons = new JButton[4];
        for (int i = 0; i < arrowKeys.length; i++) 
        {
            arrowButtons[i] = new JButton(arrowKeys[i]);
            arrowButtons[i].setFont(new Font("Arial", Font.PLAIN, 24));
        }
        
        // Menempatkan tombol panah di pojok kanan bawah
        gbc.gridwidth = 1;
        gbc.gridx = 10;
        gbc.gridy = 4;
        keyboardPanel.add(arrowButtons[0], gbc); // Up
        
        gbc.gridx = 9;
        gbc.gridy = 5;
        keyboardPanel.add(arrowButtons[1], gbc); // Left
        
        gbc.gridx = 10;
        gbc.gridy = 5;
        keyboardPanel.add(arrowButtons[2], gbc); // Down
        
        gbc.gridx = 11;
        gbc.gridy = 5;
        keyboardPanel.add(arrowButtons[3], gbc); // Right
        
        // Menambahkan tombol panah ke peta
        for (JButton button : arrowButtons) 
        {
            keyMap.put(button.getText(), button);
        }

        // Menambahkan panel keyboard ke frame
        add(keyboardPanel, BorderLayout.CENTER);

        // Menambahkan KeyListener untuk menangani penekanan tombol
        textArea.addKeyListener(new KeyAdapter() 
        {
            @Override
            public void keyPressed(KeyEvent e) 
            {
                String keyText = KeyEvent.getKeyText(e.getKeyCode());
                if (keyMap.containsKey(keyText)) 
                {
                    JButton button = keyMap.get(keyText);
                    button.setBackground(highlightColor);
                    switch (e.getKeyCode()) 
                    {
                        case KeyEvent.VK_BACK_SPACE:
                            String text = textArea.getText();
                            if (text.length() > 0) 
                            {
                                textArea.setText(text.substring(0, text.length() - 1));
                            }
                            break;
                        case KeyEvent.VK_TAB:
                            textArea.append("\t");
                            e.consume();  // Konsumsi event untuk mencegah default behavior
                            break;
                        case KeyEvent.VK_ENTER:
                            textArea.append("\n");
                            break;
                        case KeyEvent.VK_SPACE:
                            textArea.append(" ");
                            break;
                        case KeyEvent.VK_DELETE:
                            text = textArea.getText();
                            int caretPos = textArea.getCaretPosition();
                            if (caretPos < text.length()) {
                                textArea.setText(text.substring(0, caretPos) + text.substring(caretPos + 1));
                                textArea.setCaretPosition(caretPos);
                            }
                            break;
                        case KeyEvent.VK_LEFT:
                            textArea.setCaretPosition(Math.max(0, textArea.getCaretPosition() - 1));
                            break;
                        case KeyEvent.VK_RIGHT:
                            textArea.setCaretPosition(Math.min(textArea.getText().length(), textArea.getCaretPosition() + 1));
                            break;
                        case KeyEvent.VK_UP:
                            textArea.setCaretPosition(0); // Move caret to start of text
                            break;
                        case KeyEvent.VK_DOWN:
                            textArea.setCaretPosition(textArea.getText().length()); // Move caret to end of text
                            break;
                        default:
                            textArea.append(String.valueOf(e.getKeyChar()));
                            break;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) 
            {
                String keyText = KeyEvent.getKeyText(e.getKeyCode());
                if (keyMap.containsKey(keyText)) 
                {
                    JButton button = keyMap.get(keyText);
                    button.setBackground(originalColor);
                }
            }
        });

        // Membuat frame terlihat
        setVisible(true);
        textArea.requestFocusInWindow();
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> 
        {
            new TypingTutor();
        });
    }
}