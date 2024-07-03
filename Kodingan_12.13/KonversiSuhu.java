package pk10_tugas01_12.pkg13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Konversi temperatur 12.13
 * @autor Bariq 25/6-2024
 */

public class KonversiSuhu extends JFrame 
{
    private JTextField inputTemperatureField;
    private JLabel outputTemperatureLabel;
    private JComboBox<String> inputScaleComboBox;
    private JComboBox<String> outputScaleComboBox;

    public KonversiSuhu() 
    {
        super("Konverter Suhu");

        // Mengatur layout manager
        setLayout(new GridLayout(4, 2, 10, 10));

        // Membuat komponen
        JLabel inputTemperatureLabel = new JLabel("Masukkan Suhu:");
        inputTemperatureField = new JTextField(10);
        
        JLabel inputScaleLabel = new JLabel("Dari:");
        String[] scales = {"Fahrenheit", "Celsius", "Kelvin"};
        inputScaleComboBox = new JComboBox<>(scales);
        
        JLabel outputScaleLabel = new JLabel("Ke:");
        outputScaleComboBox = new JComboBox<>(scales);
        
        JButton convertButton = new JButton("Konversi");
        outputTemperatureLabel = new JLabel("Suhu Keluaran:");

        // Menambahkan komponen ke frame
        add(inputTemperatureLabel);
        add(inputTemperatureField);
        add(inputScaleLabel);
        add(inputScaleComboBox);
        add(outputScaleLabel);
        add(outputScaleComboBox);
        add(convertButton);
        add(outputTemperatureLabel);

        // Menambahkan aksi klik tombol
        convertButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                konversiSuhu();
            }
        });

        // Mengatur properti frame
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void konversiSuhu() 
    {
        try 
        {
            // Mendapatkan suhu masukan dari text field
            double inputTemperature = Double.parseDouble(inputTemperatureField.getText());

            // Mendapatkan skala yang dipilih
            String inputScale = (String) inputScaleComboBox.getSelectedItem();
            String outputScale = (String) outputScaleComboBox.getSelectedItem();

            // Mengkonversi suhu masukan ke skala keluaran
            double outputTemperature = konversi(inputTemperature, inputScale, outputScale);

            // Menampilkan suhu keluaran
            outputTemperatureLabel.setText(String.format("Suhu Keluaran: %.2f", outputTemperature));
        } catch (NumberFormatException e) 
        {
            // Menangani input tidak valid
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid", "Input Tidak Valid", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double konversi(double suhu, String dariSkala, String keSkala) 
    {
        double suhuCelsius = 0;

        // Mengkonversi suhu masukan ke Celsius
        switch (dariSkala) 
        {
            case "Fahrenheit":
                suhuCelsius = (suhu - 32) * 5 / 9;
                break;
            case "Celsius":
                suhuCelsius = suhu;
                break;
            case "Kelvin":
                suhuCelsius = suhu - 273.15;
                break;
        }

        // Mengkonversi suhu Celsius ke skala keluaran
        switch (keSkala) 
        {
            case "Fahrenheit":
                return suhuCelsius * 9 / 5 + 32;
            case "Celsius":
                return suhuCelsius;
            case "Kelvin":
                return suhuCelsius + 273.15;
        }

        return 0; // Baris ini seharusnya tidak pernah tercapai
    }

    public static void main(String[] args) 
    {
        new KonversiSuhu();
    }
}