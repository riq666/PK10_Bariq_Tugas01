package pk10_tugas01_12.pkg17;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Kelas Persegi Panjang
 * @author Bariq 30/06-2024
 */

public class PersegiPanjangKu extends BentukKu 
{
    private boolean isi;

    public PersegiPanjangKu(int x1, int y1, int x2, int y2, Color warna, boolean isi) 
    {
        super(x1, y1, x2, y2, warna);
        this.isi = isi;
    }

    @Override
    public void draw(Graphics g) 
    {
        g.setColor(getColor());
        if (isi) 
        {
            g.fillRect(Math.min(getX1(), getX2()), Math.min(getY1(), getY2()), 
                       Math.abs(getX1() - getX2()), Math.abs(getY1() - getY2()));
        } 
        else 
        {
            g.drawRect(Math.min(getX1(), getX2()), Math.min(getY1(), getY2()), 
                       Math.abs(getX1() - getX2()), Math.abs(getY1() - getY2()));
        }
    }
}