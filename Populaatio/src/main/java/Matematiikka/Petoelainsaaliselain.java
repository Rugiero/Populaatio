package Matematiikka;

import dk.ange.octave.OctaveEngine;
import dk.ange.octave.OctaveEngineFactory;
import dk.ange.octave.type.OctaveDouble;
import dk.ange.octave.type.OctaveString;
import java.util.ArrayList;

public class Petoelainsaaliselain {

    /**
     * Luokka laskee Volteran peto saalis- mallin mukaan numeerisesti eulerin
     * menetelmällä.
     *
     * Esimerkkiarvot: F1 = 1, R1 = #, a= 0.3, b=0.4, c= 0.2 d=0.15.
     *
     */
    OctaveEngine octave = new OctaveEngineFactory().getScriptEngine();

    private double F1;
    private double R1;
    private double a;
    private double b;
    private double c;
    private double d;
    private double[] tuloksetR;
    private double[] tuloksetF;
    private double[] T;
    private ArrayList<double[]> tulokset = new ArrayList<>();

    /**
     * Palautetaan listat vastauksista arraylistinä ajan suhteen saaliseläimille
     * 'F' ja petoeläimille 'R'
     *
     * @param N1
     * @param tN1
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public ArrayList<double[]> laske(double R1, double F1, double a, double b, double c, double d) {

//
        this.F1 = F1;
        this.R1 = R1;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

//        double h = (double) this.tN / (double) this.N;
        double h = 0.01;
//        octave.eval("R(1)=" + this.R1 + "; F(1)=" + this.F1 + ";");
//        octave.eval("for i = 1:" + 4999 + " R(i+1) = R(i) + " + h + "*R(i)*(" + this.a + "-" + this.c + "*F(i)); F(i+1) = F(i) +" + h + "*F(i)*(" + -this.b + "+" + this.d + "*R(i)); end;");
//        octave.eval("T=linspace(0,50,5000);");
//
//   
        octave.eval("function ret = f(X,t) ret = [" + this.a + "*X(1)-" + this.b + "*X(1)*X(2)," + this.c + "*X(1)*X(2)-" + this.d + "*X(2)]; end");
        octave.eval("T=linspace(0,200,3000);");
        octave.eval("X=lsode('f',[" + this.R1 + "," + this.F1 + "], T);");

        OctaveDouble arvot = octave.get(OctaveDouble.class, "T");
        this.T = arvot.getData();
        this.tulokset.add(this.T);
        octave.eval(" R =X(:,1)';");
        octave.eval("F = X(:,2)';");

        arvot = octave.get(OctaveDouble.class, "R");
        this.tuloksetR = arvot.getData();
        this.tulokset.add(this.tuloksetR);

        arvot = octave.get(OctaveDouble.class, "F");
        this.tuloksetF = arvot.getData();
        this.tulokset.add(this.tuloksetF);

        octave.close();

        /**
         * Käydään ratkaisut läpi ja lisätään palautettavaan stringiin:
         */
        return this.tulokset;
    }

}
