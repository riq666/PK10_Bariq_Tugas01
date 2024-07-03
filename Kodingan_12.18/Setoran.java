package pk10_tugas01_12.pkg18;

/**
 * Mewakili transaksi setoran
 * @author Bariq 03/07-2024
 */

public class Setoran extends Transaksi 
{
    private double jumlah;
    private SlotSetor slotSetor;
    private final static int DIBATALKAN = 0;

    public Setoran(int nomorRekening, Layar layar, DatabaseBank databaseBank, SlotSetor slotSetor) 
    {
        super(nomorRekening, layar, databaseBank);
        this.slotSetor = slotSetor;
    }

    @Override
    public void laksanakan() 
    {
        DatabaseBank databaseBank = getDatabaseBank();
        Layar layar = getLayar();

        jumlah = mintaJumlahSetoran();
        if (jumlah != DIBATALKAN) 
        {
            layar.tampilkanPesan("\nSilakan masukkan amplop setoran yang berisi Rp" + jumlah);
            if (slotSetor.isAmplopDiterima()) 
            {
                databaseBank.kredit(getNomorRekening(), jumlah);
                layar.tampilkanPesanBaris("\nAmplop Anda telah diterima.");
            }
            else
            {
                layar.tampilkanPesanBaris("\nAnda tidak memasukkan amplop.");
            }
        } 
        else 
        {
            layar.tampilkanPesanBaris("\nMembatalkan transaksi...");
        }
    }

    private double mintaJumlahSetoran() 
    {
        Layar layar = getLayar();
        layar.tampilkanPesan("\nSilakan masukkan jumlah setoran (atau 0 untuk membatalkan): ");
        int input = layar.getInput();
        return (input / 100.0);
    }
}
