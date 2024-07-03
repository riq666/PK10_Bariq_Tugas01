package pk10_tugas01_12.pkg16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Permainan Craps
 * @author Bariq 25/6-2024
 */

public class PermainanCraps extends JFrame 
{
    private final JLabel labelDadu1, labelDadu2, labelJumlah, labelPoin;
    private final JTextField fieldDadu1, fieldDadu2, fieldJumlah, fieldPoin;
    private final JButton tombolLempar;
    private final Random random;
    
    private enum StatusPermainan { LANJUT, MENANG, KALAH }
    private int poinSaya;
    private StatusPermainan statusPermainan;
    
    public PermainanCraps() 
    {
        super("Permainan Craps");
        setLayout(new GridLayout(5, 2, 10, 10));
        
        random = new Random();
        
        labelDadu1 = new JLabel("Dadu 1:");
        labelDadu2 = new JLabel("Dadu 2:");
        labelJumlah = new JLabel("Jumlah:");
        labelPoin = new JLabel("Poin:");
        
        fieldDadu1 = new JTextField();
        fieldDadu2 = new JTextField();
        fieldJumlah = new JTextField();
        fieldPoin = new JTextField();
        
        fieldDadu1.setEditable(false);
        fieldDadu2.setEditable(false);
        fieldJumlah.setEditable(false);
        fieldPoin.setEditable(false);
        
        tombolLempar = new JButton("Lempar Dadu");
        tombolLempar.addActionListener(new PenanganTombolLempar());
        
        add(labelDadu1);
        add(fieldDadu1);
        add(labelDadu2);
        add(fieldDadu2);
        add(labelJumlah);
        add(fieldJumlah);
        add(labelPoin);
        add(fieldPoin);
        add(new JLabel());
        add(tombolLempar);
        
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private class PenanganTombolLempar implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent event) 
        {
            int dadu1 = 1 + random.nextInt(6);
            int dadu2 = 1 + random.nextInt(6);
            int jumlah = dadu1 + dadu2;
            
            fieldDadu1.setText(String.valueOf(dadu1));
            fieldDadu2.setText(String.valueOf(dadu2));
            fieldJumlah.setText(String.valueOf(jumlah));
            
            if (statusPermainan == null) 
            {
                switch (jumlah) 
                {
                    case 7: case 11:
                        statusPermainan = StatusPermainan.MENANG;
                        JOptionPane.showMessageDialog(PermainanCraps.this, "Anda menang!");
                        break;
                    case 2: case 3: case 12:
                        statusPermainan = StatusPermainan.KALAH;
                        JOptionPane.showMessageDialog(PermainanCraps.this, "Anda kalah!");
                        break;
                    default:
                        statusPermainan = StatusPermainan.LANJUT;
                        poinSaya = jumlah;
                        fieldPoin.setText(String.valueOf(poinSaya));
                        JOptionPane.showMessageDialog(PermainanCraps.this, "Poin adalah " + poinSaya);
                        break;
                }
            } 
            else 
            {
                if (jumlah == poinSaya) 
                {
                    statusPermainan = StatusPermainan.MENANG;
                    JOptionPane.showMessageDialog(PermainanCraps.this, "Anda menang!");
                } 
                else if (jumlah == 7) 
                {
                    statusPermainan = StatusPermainan.KALAH;
                    JOptionPane.showMessageDialog(PermainanCraps.this, "Anda kalah!");
                }
            }
            
            if (statusPermainan != StatusPermainan.LANJUT) 
            {
                statusPermainan = null;
                fieldPoin.setText("");
            }
        }
    }
}