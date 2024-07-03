package pk10_tugas01_12.pkg18;

/**
 * Mewakili pengeluar uang
 * @author Bariq 03/07-2024
 */

public class PengeluarUang 
{
    private final static int JUMLAH_DEFAULT = 500;

    private int uangTersedia;

    public PengeluarUang() 
    {
        uangTersedia = JUMLAH_DEFAULT;
    }

    public void keluarkanUang(int jumlah) 
    {
        uangTersedia -= jumlah;
    }

    public boolean cukupUangTersedia(int jumlah) 
    {
        return uangTersedia >= jumlah;
    }
}