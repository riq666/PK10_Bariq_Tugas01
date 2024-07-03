package pk10_tugas01_12.pkg18;

/**
 * Mewakili transaksi penarikan
 * @author Bariq 03/07-2024
 */

public class Penarikan extends Transaksi 
{
    private PengeluarUang pengeluarUang;
    private final static int DIBATALKAN = 6;

    public Penarikan(int nomorRekening, Layar layar, DatabaseBank databaseBank, PengeluarUang pengeluarUang) 
    {
        super(nomorRekening, layar, databaseBank);
        this.pengeluarUang = pengeluarUang;
    }

    @Override
    public void laksanakan() 
    {
        DatabaseBank databaseBank = getDatabaseBank();
        Layar layar = getLayar();
        int jumlah = tampilkanMenuJumlah();

        if (jumlah != DIBATALKAN) 
        {
            if (pengeluarUang.cukupUangTersedia(jumlah)) 
            {
                databaseBank.debit(getNomorRekening(), jumlah);
                pengeluarUang.keluarkanUang(jumlah);
                layar.tampilkanPesanBaris("\nUang Anda telah dikeluarkan. Silakan ambil uang Anda sekarang.");
            }
            else
            {
                layar.tampilkanPesanBaris("\nUang tidak mencukupi di ATM.");
            }
        } 
        else 
        {
            layar.tampilkanPesanBaris("\nMembatalkan transaksi...");
        }
    }

    private int tampilkanMenuJumlah() 
    {
        int pilihanPengguna = 0;
        Layar layar = getLayar();
        int[] jumlah = { 0, 20, 40, 60, 100, 200 };

        while (pilihanPengguna == 0) 
        {
            layar.tampilkanPesanBaris("\nMenu Penarikan:");
            layar.tampilkanPesanBaris("1 - Rp200000");
            layar.tampilkanPesanBaris("2 - Rp400000");
            layar.tampilkanPesanBaris("3 - Rp600000");
            layar.tampilkanPesanBaris("4 - Rp1000000");
            layar.tampilkanPesanBaris("5 - Rp2000000");
            layar.tampilkanPesanBaris("6 - Batalkan transaksi");
            layar.tampilkanPesan("\nPilih jumlah penarikan: ");

            int input = layar.getInput();

            switch (input) 
            {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    pilihanPengguna = jumlah[input];
                    break;
                case DIBATALKAN:
                    pilihanPengguna = DIBATALKAN;
                    break;
                default:
                    layar.tampilkanPesanBaris("\nPilihan tidak valid. Coba lagi.");
            }
        }
        return pilihanPengguna;
    }
}