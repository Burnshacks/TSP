import java.awt.*;

class Stadt {
    int xPos, yPos;
    private String name;
    int next;

    Stadt(int x, int y, String n) {
        xPos = x;
        yPos = y;
        name = n;
    }

    void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(xPos - 5, yPos - 5, 10, 10);
        g.setColor(Color.BLACK);
        g.drawOval(xPos - 5, yPos - 5, 10, 10);
        g.setColor(Color.BLUE);
        g.drawString(name, xPos - name.length() * 4, yPos + 20);
    }
}