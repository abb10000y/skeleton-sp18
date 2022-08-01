import java.lang.reflect.Field;
import java.sql.Array;

public class NBody {

    public static double readRadius(String path) {
        In in = new In(path);
        int nP = in.readInt();
        double uR = in.readDouble();
        return uR;
    }

    public static Planet[] readPlanets(String path) {
        In in = new In(path);
        int nP = in.readInt();
        double uR = in.readDouble();
        Planet[] gPlanet = new Planet[nP];
        while (nP > 0) {
            double xP = in.readDouble(),
                   yP = in.readDouble(),
                   xV = in.readDouble(),
                   yV = in.readDouble(),
                   m = in.readDouble();
            String img = in.readString();
            Planet P = new Planet(xP, yP, xV, yV, m, img);
            gPlanet[nP - 1] = P;
            nP -= 1;
        }
        return gPlanet;
    }

    public static void main(String[] args) {
        String imageToDraw = "images/starfield.jpg";
        double T = Double.valueOf(args[0]),
               dT = Double.valueOf(args[1]),
               sT = 0;
        String filename = args[2];
        double uR = readRadius(filename);
        Planet[] gP = readPlanets(filename);
        int cntP = 0;
        for (Planet P1 : gP) {
            cntP += 1;
        }
        double[] xForces = new double[cntP];
        double[] yForces = new double[cntP];

        StdDraw.enableDoubleBuffering();


        while (sT <= T) {

            StdDraw.setScale(-uR, uR);
            StdDraw.clear();
            StdDraw.picture(0, 0, imageToDraw);
            StdDraw.show();

            int i = 0, j = 0;
            for (Planet P : gP) {
                P.draw();
                xForces[i] = P.calcNetForceExertedByX(gP);
                yForces[j] = P.calcNetForceExertedByY(gP);
                i +=1;
                j +=1;    
                StdDraw.show();
            }

            i = 0;
            j = 0;
            for (Planet P : gP) {
                P.update(dT, xForces[i], yForces[j]);
                i +=1;
                j +=1;
            }

            StdDraw.pause(10);

            sT += dT;
        }
        

    }
}
