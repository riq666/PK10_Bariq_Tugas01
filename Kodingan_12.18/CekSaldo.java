package pk10_tugas01_12.pkg18;

/**
 * Mewakili transaksi cek saldo
 * @author Bariq 03/07-2024
 */

public class CekSaldo extends Transaksi 
{
    public CekSaldo(int nomorRekening, Layar layar, DatabaseBank databaseBank) 
    {
        super(nomorRekening, layar, databaseBank);
    }

    @Override
    public void laksanakan() 
    {
        DatabaseBank databaseBank = getDatabaseBank();
        Layar layar = getLayar();

        double saldoTersedia = databaseBank.getSaldoTersedia(getNomorRekening());

        layar.tampilkanPesanBaris("\nInformasi Saldo:");
        layar.tampilkanPesanBaris(" - Saldo tersedia: Rp" + saldoTersedia);
    }
}