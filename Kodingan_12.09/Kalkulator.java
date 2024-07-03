package pk10_tugas01_12.pkg09;

import javax.swing.*;
import java.awt.*;

/**
 * Membuat GUI 12.9
 * @author Bariq 25/6-2024
 */

public class Kalkulator extends JFrame 
{

    private JTextField display;

    public Kalkulator() 
    {
        // Membuat frame
        setTitle("Kalkulator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat field display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);

        // Membuat panel untuk tombol-tombol
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5)); // Mengatur grid gap menjadi 5

        // Teks tombol
        String[] teksTombol = 
        {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        // Membuat tombol-tombol dan menambahkannya ke panel
        for (String teks : teksTombol) 
        {
            JButton tombol = new JButton(teks);
            tombol.setFont(new Font("Arial", Font.PLAIN, 20)); // Mengatur ukuran font
            tombol.setPreferredSize(new Dimension(60, 60)); // Mengatur ukuran preferensi
            panel.add(tombol);
        }

        // Menambahkan display dan panel ke frame
        setLayout(new BorderLayout(10, 10));
        add(display, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        // Membuat frame terlihat
        setVisible(true);
    }
}