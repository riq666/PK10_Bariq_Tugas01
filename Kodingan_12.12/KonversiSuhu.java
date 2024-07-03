package pk10_tugas01_12.pkg12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Konversi temperatur 12.12
 * @autor Bariq 25/6-2024
 */

public class KonversiSuhu extends JFrame {

    private JTextField fahrenheitTextField;
    private JLabel celsiusLabel;

    public KonversiSuhu() {
        super("Konverter Fahrenheit ke Celsius");

        // Mengatur tata letak
        setLayout(new FlowLayout());

        // Membuat komponen
        JLabel fahrenheitLabel = new JLabel("Fahrenheit:");
        fahrenheitTextField = new JTextField(10);
        JButton convertButton = new JButton("Konversi");
        celsiusLabel = new JLabel("Celsius:");

        // Menambahkan komponen ke frame
        add(fahrenheitLabel);
        add(fahrenheitTextField);
        add(convertButton);
        add(celsiusLabel);

        // Menambahkan aksi klik tombol
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                konversiSuhu();
            }
        });

        // Mengatur properti frame
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void konversiSuhu() {
        try {
            // Mendapatkan suhu Fahrenheit dari text field
            double fahrenheit = Double.parseDouble(fahrenheitTextField.getText());

            // Mengkonversi ke Celsius
            double celsius = (fahrenheit - 32) * 5 / 9;

            // Menampilkan suhu Celsius
            celsiusLabel.setText(String.format("Celsius: %.2f", celsius));
        } catch (NumberFormatException e) {
            // Menangani input tidak valid
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid", "Input Tidak Valid", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new KonversiSuhu();
    }
}