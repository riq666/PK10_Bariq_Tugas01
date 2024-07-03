package pk10_tugas01_12.pkg18;

import java.util.Scanner;

/**
 * Mewakili layar ATM
 * @author Bariq 03/07-2024
 */

public class Layar 
{
    private Scanner input = new Scanner(System.in);

    public void tampilkanPesan(String pesan) 
    {
        System.out.print(pesan);
    }

    public void tampilkanPesanBaris(String pesan) 
    {
        System.out.println(pesan);
    }

    public int getInput() 
    {
        return input.nextInt();
    }
}