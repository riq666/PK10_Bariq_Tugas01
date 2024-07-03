package pk10_tugas01_12.pkg19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ecofont
 * @author Bariq 03/07-2024
 */

// Karena web tdk bisa diakses, maka font menggunakan font default (Arial)

public class GUIEcofont extends JFrame 
{

    private JTextField inputField;
    private JLabel displayLabel;
    private int fontSize;

    public GUIEcofont() 
    {
        // Mengatur frame
        setTitle("Ecofont GUI");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Mengatur ukuran font awal
        fontSize = 9;

        // Membuat field input
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, fontSize));

        // Membuat label untuk menampilkan teks
        displayLabel = new JLabel("", JLabel.CENTER);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, fontSize));

        // Membuat panel untuk tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Tombol untuk memperbesar ukuran font
        JButton increaseButton = new JButton("Perbesar Ukuran Font");
        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                fontSize++;
                updateFontSize();
            }
        });

        // Tombol untuk memperkecil ukuran font
        JButton decreaseButton = new JButton("Perkecil Ukuran Font");
        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                fontSize--;
                updateFontSize();
            }
        });

        // Menambahkan tombol ke panel
        buttonPanel.add(increaseButton);
        buttonPanel.add(decreaseButton);

        // Menambahkan komponen ke frame
        add(inputField, BorderLayout.NORTH);
        add(displayLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Menambahkan ActionListener untuk mengupdate teks saat mengetik
        inputField.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                updateText();
            }
        });

        // Membuat frame terlihat
        setVisible(true);
    }

    private void updateFontSize() 
    {
        Font font = new Font("Arial", Font.PLAIN, fontSize);
        inputField.setFont(font);
        displayLabel.setFont(font);
    }

    private void updateText() 
    {
        String text = inputField.getText();
        displayLabel.setText(text);
    }
}