package pk10_tugas01_12.pkg10;

import javax.swing.*;
import java.awt.*;

/**
 * Membuat GUI 12.10
 * @author Bariq 25/6-2024
 */

public class PK10_Tugas01_1210 extends JFrame 
{
    private final JButton tombolOk;
    private final JButton tombolBatal;
    private final JCheckBox latar, teks;
    private final JComboBox<String> daftarWarna;
    private final JPanel panelTengah, panelBawah;

    public PK10_Tugas01_1210() 
    {
        // Pengaturan JFrame
        setTitle("Pemilih Warna");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout utama
        getContentPane().setLayout(new BorderLayout());

        // Bagian atas (utara)
        daftarWarna = new JComboBox<>();
        daftarWarna.addItem("MERAH");
        daftarWarna.addItem("HIJAU");
        daftarWarna.addItem("BIRU");
        getContentPane().add(daftarWarna, BorderLayout.NORTH);

        // Bagian tengah
        panelTengah = new JPanel();
        latar = new JCheckBox("latar belakang");
        teks = new JCheckBox("teks depan");
        panelTengah.add(latar);
        panelTengah.add(teks);
        getContentPane().add(panelTengah, BorderLayout.CENTER);

        // Bagian bawah (selatan)
        tombolOk = new JButton("Ok");
        tombolBatal = new JButton("Batal");
        panelBawah = new JPanel();
        panelBawah.add(tombolOk);
        panelBawah.add(tombolBatal);
        getContentPane().add(panelBawah, BorderLayout.SOUTH);

        // Aksi untuk tombol
        AksiTombol aksi = new AksiTombol(this);
        tombolOk.addActionListener(aksi);
        tombolBatal.addActionListener(aksi);
    }

    public Color getWarnaPilihan() 
    {
        return getWarnaDariPilihan((String) daftarWarna.getSelectedItem());
    }

    public boolean isLatarDipilih() 
    {
        return latar.isSelected();
    }

    public boolean isTeksDipilih() 
    {
        return teks.isSelected();
    }

    public void resetPilihan() 
    {
        daftarWarna.setSelectedIndex(0);
        latar.setSelected(false);
        teks.setSelected(false);
        getContentPane().setBackground(getBackground()); // Reset ke latar belakang default
        getContentPane().setForeground(getForeground()); // Reset ke teks depan default
    }

    private Color getWarnaDariPilihan(String warna) 
    {
        switch (warna) 
        {
            case "MERAH":
                return Color.RED;
            case "HIJAU":
                return Color.GREEN;
            case "BIRU":
                return Color.BLUE;
            default:
                return Color.BLACK;
        }
    }

    public void ubahLatar(Color warna) 
    {
        getContentPane().setBackground(warna);
    }

    public void ubahTeks(Color warna) 
    {
        getContentPane().setForeground(warna);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> 
        {
            new PK10_Tugas01_1210().setVisible(true);
        });
    }
}
