package pk10_tugas01_12.pkg18;

/**
 * Mewakili transaksi
 * @author Bariq 03/07-2024
 */

public abstract class Transaksi 
{
    private int nomorRekening;
    private Layar layar;
    private DatabaseBank databaseBank;

    public Transaksi(int nomorRekening, Layar layar, DatabaseBank databaseBank) 
    {
        this.nomorRekening = nomorRekening;
        this.layar = layar;
        this.databaseBank = databaseBank;
    }

    public int getNomorRekening() 
    {
        return nomorRekening;
    }

    public Layar getLayar() 
    {
        return layar;
    }

    public DatabaseBank getDatabaseBank() 
    {
        return databaseBank;
    }

    public abstract void laksanakan();
}
