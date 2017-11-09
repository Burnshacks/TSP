import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

class StadtArray {
    private int[][] entfernungen;
    private int anzahl = 10;
    private int gesamtlaenge = 6000;
    private ArrayList<Stadt> possibleRoutes;
    private ArrayList<Stadt> shortestRoute;
    private Random rand = new Random();

    StadtArray() {
        ArrayList<Stadt> lst = new ArrayList<>();
        for (int i = 0; i < anzahl; ++i) {

            lst.add(new Stadt(rand.nextInt(800), rand.nextInt(800), "Stadt " + (i)));
        }
        entfernungen = new int[20][20];
        possibleRoutes = new ArrayList<>(lst);
        ArrayList<Stadt> route = new ArrayList<>();
        bruteForceFindBestRoute(route, lst);
    }

    private void bruteForceFindBestRoute(ArrayList<Stadt> route, ArrayList<Stadt> citiesNotInRoute) {
        if (!citiesNotInRoute.isEmpty()) {
            for (int i = 0; i < citiesNotInRoute.size(); i++) {
                Stadt justRemoved = citiesNotInRoute.remove(0);
                ArrayList<Stadt> newRoute = new ArrayList<>(route);
                newRoute.add(justRemoved);

                bruteForceFindBestRoute(newRoute, citiesNotInRoute);
                citiesNotInRoute.add(justRemoved);
            }
        } else {

            possibleRoutes = route;
            entfernungsliste();
            getShortestRoute(route);
        }
    }

    private void getShortestRoute(ArrayList<Stadt> route) {
        int laenge = 0;
        for (int i = 0; i < anzahl; i++) {
            if (i < anzahl - 1)
                laenge += entfernungen[i][i + 1];
            else if (i == anzahl - 1)
                laenge += entfernungen[i][0];
        }
        if (laenge < gesamtlaenge) {
            gesamtlaenge = laenge;
            shortestRoute = new ArrayList<>(route);
            naechsteStadt();
        }
    }

    private int entfernung(int s1, int s2) {
        int dx, dy, dx2, dy2;
        dx = possibleRoutes.get(s1).xPos - possibleRoutes.get(s2).xPos;
        dy = possibleRoutes.get(s1).yPos - possibleRoutes.get(s2).yPos;
        dx2 = dx * dx;
        dy2 = dy * dy;

        return (int) Math.sqrt(dx2 + dy2);
    }

    private void entfernungsliste() {

        for (int k = 0; k < anzahl; k++) {

            for (int i = 0; i < anzahl; i++) {
                entfernungen[i][k] = entfernung(i, k);
            }
        }

    }

    private void naechsteStadt() {
        for (int i = 0; i < anzahl; i++) {
            if (i < anzahl - 1)
                shortestRoute.get(i).next = i + 1;
            else
                shortestRoute.get(i).next = 0;
        }

    }

    void paint(Graphics g) {
        int next = 0;
        int x1, y1, x2, y2;

        do {
            shortestRoute.get(next).paint(g);
            x1 = shortestRoute.get(next).xPos;
            y1 = shortestRoute.get(next).yPos;
            next = shortestRoute.get(next).next;
            x2 = shortestRoute.get(next).xPos;
            y2 = shortestRoute.get(next).yPos;
            g.drawLine(x1, y1, x2, y2);
        }
        while (next != 0);
    }
}