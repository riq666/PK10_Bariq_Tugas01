package pk10_tugas01_12.pkg10;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Membuat GUI 12.10
 * @author Bariq 25/6-2024
 */

public class AksiTombol implements ActionListener 
{
    private final PK10_Tugas01_1210 frame;

    public AksiTombol(PK10_Tugas01_1210 frame) 
    {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("Ok")) 
        {
            Color warnaPilihan = frame.getWarnaPilihan();
            if (frame.isLatarDipilih()) 
            {
                frame.ubahLatar(warnaPilihan);
            }
            if (frame.isTeksDipilih()) 
            {
                frame.ubahTeks(warnaPilihan);
            }
        } 
        else if (e.getActionCommand().equals("Batal")) 
        {
            frame.resetPilihan();
        }
    }
}