package pk10_tugas01_12.pkg18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Antarmuka Pengguna Grafis untuk ATM
 * @author Bariq 03/07-2024
 */

public class ATMGUI extends JFrame 
{
    private final ATM atm;
    private final JTextField fieldNomorRekening;
    private final JPasswordField fieldPin;
    private final JTextArea areaTampilan;
    private final JButton tombolEnter;

    public ATMGUI() 
    {
        atm = new ATM();
        fieldNomorRekening = new JTextField(10);
        fieldPin = new JPasswordField(10);
        areaTampilan = new JTextArea(20, 30);
        tombolEnter = new JButton("Masuk");

        setLayout(new BorderLayout());
        add(createPanelInput(), BorderLayout.NORTH);
        add(new JScrollPane(areaTampilan), BorderLayout.CENTER);
        add(createPanelTombol(), BorderLayout.SOUTH);

        tombolEnter.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                handleTombolEnter();
            }
        });

        setTitle("ATM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createPanelInput() 
    {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Nomor Rekening:"));
        panel.add(fieldNomorRekening);
        panel.add(new JLabel("PIN:"));
        panel.add(fieldPin);
        return panel;
    }

    private JPanel createPanelTombol() 
    {
        JPanel panel = new JPanel();
        panel.add(tombolEnter);
        return panel;
    }

    private void handleTombolEnter() 
    {
        int nomorRekening = Integer.parseInt(fieldNomorRekening.getText());
        int pin = Integer.parseInt(new String(fieldPin.getPassword()));

        if (atm.autentikasiPengguna(nomorRekening, pin)) 
        {
            areaTampilan.setText("Autentikasi berhasil!\n");
            atm.lakukanTransaksi();
        } else 
        {
            areaTampilan.setText("Autentikasi gagal!\n");
        }
    }

    public void updateTampilan(String pesan) 
    {
        areaTampilan.append(pesan + "\n");
    }
}