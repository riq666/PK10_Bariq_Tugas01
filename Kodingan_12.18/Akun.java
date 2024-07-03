package pk10_tugas01_12.pkg18;

/**
 * Mewakili akun bank
 * @author Bariq 03/07-2024
 */

public class Akun 
{
    private int nomorRekening;
    private int pin;
    private double saldoTersedia;
    private double totalSaldo;

    // Konstruktor Akun menginisialisasi atribut
    public Akun(int nomorRekening, int pin, double saldoTersedia, double totalSaldo) 
    {
        this.nomorRekening = nomorRekening;
        this.pin = pin;
        this.saldoTersedia = saldoTersedia;
        this.totalSaldo = totalSaldo;
    }

    // Menentukan apakah PIN yang dimasukkan pengguna sesuai dengan PIN di Akun
    public boolean validasiPIN(int userPIN) 
    {
        return userPIN == pin;
    }

    // Mengembalikan saldo tersedia
    public double getSaldoTersedia() 
    {
        return saldoTersedia;
    }

    // Mengembalikan total saldo
    public double getTotalSaldo() 
    {
        return totalSaldo;
    }

    // Menambah jumlah ke akun
    public void kredit(double jumlah) 
    {
        totalSaldo += jumlah; // Menambah total saldo
    }

    // Mengurangi jumlah dari akun
    public void debit(double jumlah) 
    {
        saldoTersedia -= jumlah; // Mengurangi saldo tersedia
        totalSaldo -= jumlah; // Mengurangi total saldo
    }

    // Mengembalikan nomor rekening
    public int getNomorRekening() 
    {
        return nomorRekening;
    }
}