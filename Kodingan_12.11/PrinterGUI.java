package pk10_tugas01_12.pkg11;

import javax.swing.*;
import java.awt.*;

/**
 * Membuat GUI 12.11
 * @author Bariq 25/6-2024
 */

public class PrinterGUI extends JFrame 
{ 
    public PrinterGUI() 
    {
        super("Printer");
        
        // Set layout manager
        setLayout(new BorderLayout());

        // Create a panel for the center part of the layout
        JPanel centerPanel = new JPanel(new GridLayout(3, 3));

        // Create checkboxes
        JCheckBox imageCheckBox = new JCheckBox("Gambar");
        JCheckBox textCheckBox = new JCheckBox("Teks");
        JCheckBox codeCheckBox = new JCheckBox("Kode");

        // Create radio buttons
        JRadioButton selectionRadioButton = new JRadioButton("Seleksi");
        JRadioButton allRadioButton = new JRadioButton("Semua", true);
        JRadioButton appletRadioButton = new JRadioButton("Applet");

        // Group the radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(selectionRadioButton);
        group.add(allRadioButton);
        group.add(appletRadioButton);

        // Add components to center panel
        centerPanel.add(imageCheckBox);
        centerPanel.add(selectionRadioButton);
        centerPanel.add(new JLabel());
        centerPanel.add(textCheckBox);
        centerPanel.add(allRadioButton);
        centerPanel.add(new JLabel());
        centerPanel.add(codeCheckBox);
        centerPanel.add(appletRadioButton);
        centerPanel.add(new JLabel());

        // Create a panel for the bottom part of the layout
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Create print quality dropdown
        JLabel printQualityLabel = new JLabel("Kualitas Cetak:");
        String[] qualities = { "Tinggi", "Sedang", "Rendah" };
        JComboBox<String> printQualityComboBox = new JComboBox<>(qualities);

        // Create Print to File checkbox
        JCheckBox printToFileCheckBox = new JCheckBox("Cetak ke File");

        // Add components to bottom panel
        bottomPanel.add(printQualityLabel);
        bottomPanel.add(printQualityComboBox);
        bottomPanel.add(printToFileCheckBox);

        // Create a panel for the right part of the layout
        JPanel rightPanel = new JPanel(new GridLayout(6, 1, 5, 5));
        
        // Create buttons
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Batal");
        JButton setupButton = new JButton("Atur...");
        JButton helpButton = new JButton("Bantuan");

        // Add buttons to right panel
        rightPanel.add(okButton);
        rightPanel.add(cancelButton);
        rightPanel.add(setupButton);
        rightPanel.add(helpButton);
        rightPanel.add(new JLabel());
        rightPanel.add(new JLabel());

        // Add panels to the frame
        add(new JLabel("Printer: PrinterSaya"), BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        add(rightPanel, BorderLayout.EAST);
    }
}