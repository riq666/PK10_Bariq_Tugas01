package pk10_tugas01_12.pkg14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Game Tebak Nomor 12.14
 * @author Bariq 25/6-2024
 */

public class GameTebakNomor extends JFrame 
{
    private final Random random = new Random();
    private int angkaUntukDitebak;
    private int selisihTebakanSebelumnya;

    private final JTextField bidangTebakan;
    private final JLabel labelPesan;
    private final JButton tombolPermainanBaru;

    public GameTebakNomor() 
    {
        super("Permainan Tebak Angka");

        // Inisialisasi komponen
        bidangTebakan = new JTextField(10);
        labelPesan = new JLabel("Saya punya angka antara 1 dan 1000. Tebak angka saya?");
        tombolPermainanBaru = new JButton("Permainan Baru");

        // Mengatur layout
        setLayout(new FlowLayout());

        // Menambahkan komponen ke frame
        add(labelPesan);
        add(bidangTebakan);
        add(tombolPermainanBaru);

        // Mengatur status awal
        mulaiPermainanBaru();

        // Menambahkan event listener
        bidangTebakan.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                tanganiTebakan();
            }
        });

        tombolPermainanBaru.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                mulaiPermainanBaru();
            }
        });

        // Mengatur properti frame
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void mulaiPermainanBaru() 
    {
        angkaUntukDitebak = random.nextInt(1000) + 1;
        selisihTebakanSebelumnya = Integer.MAX_VALUE;
        bidangTebakan.setEditable(true);
        bidangTebakan.setText("");
        labelPesan.setText("Saya punya angka antara 1 dan 1000. Tebak angka saya?");
        getContentPane().setBackground(null);
    }

    private void tanganiTebakan() 
    {
        try {
            int tebakan = Integer.parseInt(bidangTebakan.getText());
            int selisihTebakan = Math.abs(tebakan - angkaUntukDitebak);

            if (tebakan == angkaUntukDitebak) 
            {
                labelPesan.setText("Tebakan Anda benar!");
                bidangTebakan.setEditable(false);
            } else 
            {
                if (selisihTebakan < selisihTebakanSebelumnya) {
                    getContentPane().setBackground(Color.RED);
                    labelPesan.setText(tebakan < angkaUntukDitebak ? "Terlalu Rendah" : "Terlalu Tinggi");
                } else 
                {
                    getContentPane().setBackground(Color.BLUE);
                    labelPesan.setText(tebakan < angkaUntukDitebak ? "Terlalu Rendah" : "Terlalu Tinggi");
                }
                selisihTebakanSebelumnya = selisihTebakan;
            }
        } catch (NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid", "Input Tidak Valid", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) 
    {
        new GameTebakNomor();
    }
}