package matematiikka;

import dk.ange.octave.OctaveEngine;
import dk.ange.octave.OctaveEngineFactory;
import dk.ange.octave.type.OctaveDouble;
import dk.ange.octave.type.OctaveString;
import java.util.ArrayList;

public class Petoelainsaaliselain {

    OctaveEngine octave = new OctaveEngineFactory().getScriptEngine();
    private int N;
    private int t0;
    private int tN;
    private double a;
    private double b;
    private double c;
    private double d;
    private double[] tuloksetR;
    private double[] tuloksetF;
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
    public ArrayList<double[]> laske(int N1, double a, double b, double c, double d) {

//        this.N = N1;
        this.t0 = 0;
        this.tN = 200;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

//        double h = (double) this.tN / (double) this.N;
        double h = 0.01;
        octave.eval("R(1)=7.4; F(1)=1.335;");
        octave.eval("for i = 1:" + 5000 + " R(i+1) = R(i) + " + h + "*R(i)*(" + this.a + "-" + this.c + "*F(i)); F(i+1) = F(i) +" + h + "*F(i)*(" + -this.b + "+" + this.d + "*R(i)); end;");
        octave.eval("T=" + this.t0 + ":" + h + ":" + this.tN + ";");

        octave.eval("F");
        octave.eval("R");
        System.out.println(h);

        OctaveDouble arvot = octave.get(OctaveDouble.class, "R");
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
