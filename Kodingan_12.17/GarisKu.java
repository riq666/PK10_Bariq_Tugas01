package pk10_tugas01_12.pkg17;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Kelas Garis
 * @authr Bariq 30/06-2024
 */

public class GarisKu extends BentukKu 
{
    public GarisKu(int x1, int y1, int x2, int y2, Color warna) 
    {
        super(x1, y1, x2, y2, warna);
    }

    @Override
    public void draw(Graphics g) 
    {
        g.setColor(getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }
}