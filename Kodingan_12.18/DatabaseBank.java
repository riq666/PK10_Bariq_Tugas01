package pk10_tugas01_12.pkg18;

/**
 * Mewakili database bank
 * @author Bariq 03/07-2024
 */

public class DatabaseBank 
{
    private Akun[] akun;

    public DatabaseBank() 
    {
        akun = new Akun[2];
        akun[0] = new Akun(12345, 54321, 1000000.0, 1200000.0);
        akun[1] = new Akun(98765, 56789, 200000.0, 200000.0);
    }

    public boolean autentikasiPengguna(int nomorRekening, int pin) 
    {
        Akun akun = getAkun(nomorRekening);
        if (akun != null) 
        {
            return akun.validasiPIN(pin);
        } 
        else 
        {
            return false;
        }
    }

    public double getSaldoTersedia(int nomorRekening) 
    {
        Akun akun = getAkun(nomorRekening);
        return akun.getSaldoTersedia();
    }

    public void kredit(int nomorRekening, double jumlah) 
    {
        Akun akun = getAkun(nomorRekening);
        if (akun != null) 
        {
            akun.kredit(jumlah);
        }
    }

    public void debit(int nomorRekening, double jumlah) 
    {
        Akun akun = getAkun(nomorRekening);
        if (akun != null) 
        {
            akun.debit(jumlah);
        }
    }

    private Akun getAkun(int nomorRekening) 
    {
        for (Akun akun : akun) 
        {
            if (akun.getNomorRekening() == nomorRekening) 
            {
                return akun;
            }
        }
        return null;
    }
}
