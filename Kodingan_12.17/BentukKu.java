package pk10_tugas01_12.pkg17;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Abstraksi Bentuk Saya
 * @author Bariq 30/06-2024
 */
public abstract class BentukKu 
{
    private int x1, y1, x2, y2;
    private Color warna;

    public BentukKu(int x1, int y1, int x2, int y2, Color warna) 
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.warna = warna;
    }

    public int getX1() { return x1; }
    public int getY1() { return y1; }
    public int getX2() { return x2; }
    public int getY2() { return y2; }
    public Color getColor() { return warna; }

    public abstract void draw(Graphics g);
}
