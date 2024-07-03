package pk10_tugas01_12.pkg17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Bingkai Gambar
 * @author Bariq 30/06-2024
 */

public class BingkaiGambar extends JFrame 
{
    private final PanelGambar panelGambar;
    private final JButton tombolUndo;
    private final JButton tombolClear;
    private final JComboBox<String> pilihanWarna;
    private final JComboBox<String> pilihanBentuk;
    private final JCheckBox kotakCentangIsi;
    private final JLabel labelStatus;

    private static final String[] namaWarna = 
    {
        "Hitam", "Biru", "Sian", "Abu-abu", "Hijau", "Magenta", "Oranye", "Merah Muda", "Merah", "Kuning"
    };

    private static final Color[] warna = 
    {
        Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW
    };

    private static final String[] namaBentuk = 
    {
        "Garis", "Persegi Panjang", "Oval"
    };

    public BingkaiGambar() 
    {
        super("Aplikasi Menggambar");

        labelStatus = new JLabel("(0, 0)");
        panelGambar = new PanelGambar(labelStatus);

        tombolUndo = new JButton("Undo");
        tombolClear = new JButton("Clear");

        pilihanWarna = new JComboBox<>(namaWarna);
        pilihanBentuk = new JComboBox<>(namaBentuk);
        kotakCentangIsi = new JCheckBox("Isi");

        JPanel panelKontrol = new JPanel();
        panelKontrol.setLayout(new FlowLayout());

        panelKontrol.add(tombolUndo);
        panelKontrol.add(tombolClear);
        panelKontrol.add(pilihanWarna);
        panelKontrol.add(pilihanBentuk);
        panelKontrol.add(kotakCentangIsi);

        tombolUndo.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                panelGambar.bersihkanBentukTerakhir();
            }
        });

        tombolClear.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                panelGambar.bersihkanGambar();
            }
        });

        pilihanWarna.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                panelGambar.setWarnaSaatIni(warna[pilihanWarna.getSelectedIndex()]);
            }
        });

        pilihanBentuk.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                panelGambar.setJenisBentuk(pilihanBentuk.getSelectedIndex());
            }
        });

        kotakCentangIsi.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                panelGambar.setBentukIsi(kotakCentangIsi.isSelected());
            }
        });

        add(panelKontrol, BorderLayout.NORTH);
        add(panelGambar, BorderLayout.CENTER);
        add(labelStatus, BorderLayout.SOUTH);

        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}