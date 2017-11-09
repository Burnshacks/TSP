import java.awt.*;
import java.util.*;
public class StadtArray
{
    ArrayList<Stadt> lst;
    int[][] entfernung;
    int anzahl;
    int gesamtlaenge = 6000;
    public ArrayList<Stadt> bestRoute;
    public ArrayList<Stadt> shortestRoute;
    Random rand;
    Stadt stadt;
    
    public StadtArray()
    {
        anzahl =Stadt.anzahl;
        ArrayList<Stadt> lst = new ArrayList<Stadt>();
        for (int i = 0; i < anzahl; ++i){
            
            lst.add(new Stadt(i,getRandomInt(),getRandomInt(),"Stadt "+(i)));
        }
        entfernung = new int[20][20];
        bestRoute = (ArrayList<Stadt>) lst.clone();
        ArrayList<Stadt> route = new ArrayList<Stadt>();
        bruteForceFindBestRoute(route, lst);
    }

    public void bruteForceFindBestRoute
        (ArrayList<Stadt> r,
         ArrayList<Stadt> citiesNotInRoute)
    {
        if(!citiesNotInRoute.isEmpty())
        {
            for(int i = 0; i<citiesNotInRoute.size(); i++)
            {
                Stadt justRemoved =
                    (Stadt) citiesNotInRoute.remove(0);
                ArrayList<Stadt> newRoute =
                    (ArrayList<Stadt>) r.clone();
                newRoute.add(justRemoved);
                
                bruteForceFindBestRoute(newRoute, citiesNotInRoute);
                 citiesNotInRoute.add(justRemoved);
            }
        }
        else
        {
            
            bestRoute = r;
            entfernungsliste();
            isBestRoute(r);
        }
       
        
    }
    
     private int getRandomInt(){
        Random rand = new Random();
        int randomPos = rand.nextInt(800);
        return randomPos;
    }
    
    private boolean isBestRoute(ArrayList<Stadt> r) {
        int laenge = 0;
        for( int i= 0; i < anzahl; i++){
            if(i < anzahl-1)
            laenge += entfernung[i][i+1];
            else if(i == anzahl-1)
            laenge += entfernung[i][0];
        }
        if (laenge < gesamtlaenge){
            gesamtlaenge = laenge;
            shortestRoute = (ArrayList<Stadt>) r.clone();
            naechsteStadt();
        } 
        return true;
    }
    
    public int entfernung(int s1, int s2){
       int dx, dy, dx2, dy2;
        dx = bestRoute.get(s1).xPos - bestRoute.get(s2).xPos;
        dy = bestRoute.get(s1).yPos - bestRoute.get(s2).yPos;
         dx2 = dx * dx;
         dy2 = dy * dy;
       
         return (int)Math.sqrt(dx2 + dy2);
    }
    
    public void entfernungsliste(){
         
        for(int k = 0; k < anzahl; k++){
            
            for(int i = 0; i < anzahl; i++)
            {
             entfernung[i][k] = entfernung(i,k);
            }
        }
        
    }
    
    public void naechsteStadt(){
        for(int i = 0; i < anzahl;i++){
            if(i < anzahl-1)
            shortestRoute.get(i).next = i+1;
            else 
            shortestRoute.get(i).next = 0;
        }
        
    }
    
    public void paint(Graphics g)
    {
        int next = 0;
        int x1,y1,x2,y2;
        
        do{
            shortestRoute.get(next).paint(g);
            x1 = shortestRoute.get(next).xPos;
            y1 = shortestRoute.get(next).yPos;
            next = shortestRoute.get(next).next;
            x2 = shortestRoute.get(next).xPos;
            y2 = shortestRoute.get(next).yPos;
            g.drawLine(x1,y1,x2,y2);
        }
        while (next != 0);
    }
}