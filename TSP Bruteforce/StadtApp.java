import java.awt.*;
import javax.swing.*;


public class StadtApp {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("StadtArray");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        StadtArray stadtArray = new StadtArray();
        jFrame.getContentPane().add(stadtArray);
        stadtArray.setPreferredSize(new Dimension(800,800));
        jFrame.pack();

        jFrame.setVisible(true);
    }
}
