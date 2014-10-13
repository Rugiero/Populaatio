package Matematiikka;

import dk.ange.octave.OctaveEngine;
import dk.ange.octave.OctaveEngineFactory;
import dk.ange.octave.type.OctaveDouble;
import java.util.ArrayList;
import dk.ange.octave.OctaveEngine;
import dk.ange.octave.OctaveEngineFactory;
import dk.ange.octave.type.OctaveDouble;

/**
 * Luokka laskee Volteran peto saalis- mallin mukaan numeerisesti octaven
 * 'lsode' scrpitillä.
 *
 *
 * Esimerkkiarvot: F1 = 1, R1 = #, a= 0.3, b=0.4, c= 0.2 d=0.15.
 *
 */
public class Petoelainsaaliselain {

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
     * Palautetaan ArrayList, joka sisältää vastaukset taulukoituna (t, R, F)
     *
     *
     * @param R1
     * @param F1
     * @param N1
     * @param tN1
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public ArrayList<double[]> laske(double R1, double F1, double a, double b, double c, double d, double t1) {

        this.F1 = F1;
        this.R1 = R1;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

        double h = 0.01;
        octave.eval("function ret = f(X,t) ret = [" + this.a + "*X(1)-" + this.b + "*X(1)*X(2)," + this.c + "*X(1)*X(2)-" + this.d + "*X(2)]; end");
        octave.eval("T=linspace(0," + t1 + "," + t1 * 15 + ");");

        //Syötteen ollessa niin suuri että lasku mahdoton octavelle, palautetaan tyhjä array:
        try {
            octave.eval("X=lsode('f',[" + this.R1 + "," + this.F1 + "], T);");
        } catch (dk.ange.octave.exception.OctaveEvalException e) {
            return null;
        }

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

        octave.eval("clear all");

        return this.tulokset;
    }

    public double PalautaMaxPetoja() {

        double suurin = 0;
        for (double l : tuloksetF) {
            if (l > suurin) {
                suurin = l;
            }
        }
        return suurin;

    }

    public double PalautaMaxsaaliita() {

        double suurin = 0;
        for (double l : tuloksetR) {
            if (l > suurin) {
                suurin = l;
            }

        }
        return suurin;

    }

    public double PalautaMinsaaliita() {

        double pienin = tuloksetR[0];
        for (double l : tuloksetR) {
            if (l < pienin) {
                pienin = l;
            }

        }
        return pienin;

    }

    public double PalautaMinpetoja() {

        double pienin = tuloksetF[0];
        for (double l : tuloksetF) {
            if (l < pienin) {
                pienin = l;
            }

        }
        return pienin;

    }

}
