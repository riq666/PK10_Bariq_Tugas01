package pk10_tugas01_12.pkg08;

import javax.swing.*;
import java.awt.*;

/**
 * Membuat GUI 12.08
 * @author Bariq 25/6-2024
 */
public class PK10_Tugas01_1208 extends JFrame {
   private JButton ok, batal, bantuan; 
   private JTextField nilaiX, nilaiY;
   private JCheckBox jepret, tampilkan;
   private JLabel labelX, labelY;
   private JPanel panelCentang, panelTombol,
                  panelField1, panelField2,
                  panelField;

   public PK10_Tugas01_1208() {
      super("Selaraskan");

      // membangun panelCentang
      jepret = new JCheckBox("Jepret ke Grid");
      tampilkan = new JCheckBox("Tampilkan Grid");
      panelCentang = new JPanel();
      panelCentang.setLayout(new GridLayout(2, 1));
      panelCentang.add(jepret);
      panelCentang.add(tampilkan);

      // membangun panelField1
      labelX = new JLabel("X: ");
      nilaiX = new JTextField("8", 3);
      panelField1 = new JPanel();
      panelField1.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 5));
      panelField1.add(labelX);
      panelField1.add(nilaiX);

      labelY = new JLabel("Y: ");
      nilaiY = new JTextField("8", 3);
      panelField2 = new JPanel();
      panelField2.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 5));
      panelField2.add(labelY);
      panelField2.add(nilaiY);

      panelField = new JPanel();
      panelField.setLayout(new BorderLayout());
      panelField.add(panelField1, BorderLayout.NORTH);
      panelField.add(panelField2, BorderLayout.SOUTH);

      // membangun panelTombol
      ok = new JButton("Ok");
      batal = new JButton("Batal");
      bantuan = new JButton("Bantuan");
      panelTombol = new JPanel();
      panelTombol.setLayout(new GridLayout(3, 1, 10, 5));
      panelTombol.add(ok);
      panelTombol.add(batal);
      panelTombol.add(bantuan);

      // mengatur layout untuk frame
      setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
      add(panelCentang);
      add(panelField);
      add(panelTombol);

      setSize(300, 200);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   public static void main(String[] args) {
      new PK10_Tugas01_1208();
   }
} // akhir kelas