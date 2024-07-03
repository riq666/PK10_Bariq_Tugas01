package pk10_tugas01_12.pkg17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel Gambar
 * @author Bariq 30/06-2024
 */

public class PanelGambar extends JPanel 
{
    private BentukKu[] shapes;
    private int jumlahBentuk;
    private int jenisBentuk;
    private BentukKu bentukSaatIni;
    private Color warnaSaatIni;
    private boolean bentukIsi;
    private JLabel labelStatus;

    public PanelGambar(JLabel labelStatus) 
    {
        this.labelStatus = labelStatus;
        shapes = new BentukKu[100];
        jumlahBentuk = 0;
        jenisBentuk = 0; // Default ke garis
        bentukSaatIni = null;
        warnaSaatIni = Color.BLACK;
        bentukIsi = false;

        setBackground(Color.WHITE);
        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }

    public void setJenisBentuk(int jenisBentuk) 
    {
        this.jenisBentuk = jenisBentuk;
    }

    public void setWarnaSaatIni(Color warna) 
    {
        warnaSaatIni = warna;
    }

    public void setBentukIsi(boolean isi) 
    {
        bentukIsi = isi;
    }

    public void bersihkanBentukTerakhir() 
    {
        if (jumlahBentuk > 0) {
            jumlahBentuk--;
            repaint();
        }
    }

    public void bersihkanGambar() 
    {
        jumlahBentuk = 0;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        for (int i = 0; i < jumlahBentuk; i++) 
        {
            shapes[i].draw(g);
        }
        if (bentukSaatIni != null) 
        {
            bentukSaatIni.draw(g);
        }
    }

    private class MouseHandler extends MouseAdapter implements MouseMotionListener 
    {
        @Override
        public void mousePressed(MouseEvent event) 
        {
            switch (jenisBentuk) 
            {
                case 0: 
                    bentukSaatIni = new GarisKu(event.getX(), event.getY(), event.getX(), event.getY(), warnaSaatIni);
                    break;
                case 1: 
                    bentukSaatIni = new PersegiPanjangKu(event.getX(), event.getY(), event.getX(), event.getY(), warnaSaatIni, bentukIsi);
                    break;
                case 2: 
                    bentukSaatIni = new OvalKu(event.getX(), event.getY(), event.getX(), event.getY(), warnaSaatIni, bentukIsi);
                    break;
            }
        }

        @Override
        public void mouseReleased(MouseEvent event) 
        {
            if (bentukSaatIni != null) 
            {
                bentukSaatIni.draw(getGraphics());
                shapes[jumlahBentuk++] = bentukSaatIni;
                bentukSaatIni = null;
                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent event) 
        {
            labelStatus.setText(String.format("Mouse at (%d, %d)", event.getX(), event.getY()));
        }

        @Override
        public void mouseDragged(MouseEvent event) 
        {
            if (bentukSaatIni != null) 
            {
                switch (jenisBentuk) 
                {
                    case 0:
                        bentukSaatIni = new GarisKu(bentukSaatIni.getX1(), bentukSaatIni.getY1(), event.getX(), event.getY(), warnaSaatIni);
                        break;
                    case 1:
                        bentukSaatIni = new PersegiPanjangKu(bentukSaatIni.getX1(), bentukSaatIni.getY1(), event.getX(), event.getY(), warnaSaatIni, bentukIsi);
                        break;
                    case 2:
                        bentukSaatIni = new OvalKu(bentukSaatIni.getX1(), bentukSaatIni.getY1(), event.getX(), event.getY(), warnaSaatIni, bentukIsi);
                        break;
                }
                repaint();
                labelStatus.setText(String.format("Mouse at (%d, %d)", event.getX(), event.getY()));
            }
        }
    }
}