package pk10_tugas01_12.pkg15;

import javax.swing.JFrame;

/**
 * Menampilkan Peristiwa 12.15
 * @author Bariq 25/6-2024
 */

public class PK10_Tugas01_1215 
{
     public static void main(String[] args) 
     {
        // Buat instance dari GUI TampilkanEvent dan set propertinya
        TampilkanEvent frame = new TampilkanEvent();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
