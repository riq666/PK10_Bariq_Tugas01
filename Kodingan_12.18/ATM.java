package pk10_tugas01_12.pkg18;

/**
 * Mewakili Mesin Anjungan Tunai Mandiri (ATM)
 * @author Bariq 03/07-2024
 */

public class ATM 
{
    private boolean userAuthenticated;
    private int currentAccountNumber;
    private Layar layar;
    private DatabaseBank databaseBank;
    private PengeluarUang pengeluarUang;
    private SlotSetor slotSetor;

    public ATM() 
    {
        userAuthenticated = false;
        currentAccountNumber = 0;
        layar = new Layar();
        databaseBank = new DatabaseBank();
        pengeluarUang = new PengeluarUang();
        slotSetor = new SlotSetor();
    }

    public boolean autentikasiPengguna(int nomorRekening, int pin) 
    {
        userAuthenticated = databaseBank.autentikasiPengguna(nomorRekening, pin);
        if (userAuthenticated) 
        {
            currentAccountNumber = nomorRekening;
        }
        return userAuthenticated;
    }

    public void lakukanTransaksi() 
    {
        Transaksi transaksiSaatIni = null;
        boolean userKeluar = false;
        while (!userKeluar) 
        {
            int pilihanMenuUtama = tampilkanMenuUtama();
            switch (pilihanMenuUtama) 
            {
                case 1:
                    transaksiSaatIni = new CekSaldo(currentAccountNumber, layar, databaseBank);
                    break;
                case 2:
                    transaksiSaatIni = new Penarikan(currentAccountNumber, layar, databaseBank, pengeluarUang);
                    break;
                case 3:
                    transaksiSaatIni = new Setoran(currentAccountNumber, layar, databaseBank, slotSetor);
                    break;
                case 4:
                    userKeluar = true;
                    layar.tampilkanPesanBaris("\nKeluar dari sistem...");
                    break;
                default:
                    layar.tampilkanPesanBaris("\nAnda tidak memasukkan pilihan yang valid. Coba lagi.");
                    break;
            }
            if (transaksiSaatIni != null) 
            {
                transaksiSaatIni.laksanakan();
                transaksiSaatIni = null;
            }
        }
    }

    private int tampilkanMenuUtama() 
    {
        layar.tampilkanPesanBaris("\nMenu Utama:");
        layar.tampilkanPesanBaris("1 - Lihat saldo saya");
        layar.tampilkanPesanBaris("2 - Tarik uang tunai");
        layar.tampilkanPesanBaris("3 - Setor dana");
        layar.tampilkanPesanBaris("4 - Keluar\n");
        return layar.getInput();
    }
}