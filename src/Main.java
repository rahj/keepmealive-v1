/**
 * KeepMeAlive will keep your computer awake and never idle
 *
 * September 23, 2020
 * by Reynaldo A. Hipolito
 */
import com.rahj.KeepMeAlive;
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        displayGUI();
    }

    public static void displayGUI()
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                KeepMeAlive kma = new KeepMeAlive();
            }
        });
    }
}
