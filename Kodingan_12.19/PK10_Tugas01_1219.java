package pk10_tugas01_12.pkg19;

import javax.swing.SwingUtilities;

/**
 * Ecofont
 * @author Bariq 03/07-2024
 */

// Karena web tdk bisa diakses, maka font menggunakan font default (Arial)

public class PK10_Tugas01_1219 
{
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> 
        {
            new GUIEcofont();
        });
    }
}