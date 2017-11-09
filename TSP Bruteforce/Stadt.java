import java.awt.*;
public class Stadt
{
   int xPos, yPos;
   String name;
   int nummer, next;
   StadtArray altkreis;
   static int anzahl = 11;
   
    public Stadt(int nr, int x, int y, String n)
  {
      nummer = nr;
      xPos = x;
      yPos = y;
      name = n;
      next = 0;
    
      
  }
    
  public void paint(Graphics g){
      g.setColor(Color.RED);
      g.fillOval(xPos-5,yPos-5,10,10);
      g.setColor(Color.BLACK);
      g.drawOval(xPos-5,yPos-5,10,10);
      g.setColor(Color.BLUE);
      g.drawString(name,xPos-name.length()*4,yPos+20);
    }
}