
import java.awt.*;
import javax.swing.*;


public class StadtApp extends JApplet
{
   StadtArray altkreis;
   
    public void init()
    {
     altkreis = new StadtArray();
     //altkreis.erzeuge();
     //altkreis.nearestNeighbour();
     //altkreis.entfernungsliste();
    }

    
    public void paint(Graphics g)
    {
        altkreis.paint(g);
    }

    
}
