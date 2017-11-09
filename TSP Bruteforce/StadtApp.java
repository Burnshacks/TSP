import java.awt.*;
import javax.swing.*;


public class StadtApp extends JApplet {
    private StadtArray randomCities;

    public void init() {
        randomCities = new StadtArray();
    }


    public void paint(Graphics g) {
        randomCities.paint(g);
    }
}
