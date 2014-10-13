package Matematiikka;

import Graafinenkayttoliittyma.PiirraKayra;

import dk.ange.octave.OctaveEngine;
import dk.ange.octave.OctaveEngineFactory;
import dk.ange.octave.type.OctaveDouble;
import dk.ange.octave.type.OctaveInt;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.SwingUtilities;

/**
 * N= Populaation koko I= Sairastuneita alussa B = tarttumisintesiteetti a =
 * tod.näk parantua/ aikayksikkö T = aikataulukko TuloksetI = taulukko I:lle
 * lasketuista tuloksista TuloksetS = vastaava S:lle
 *
 * Esimerkkiarvot: N=50, I = 1, B=0.003, a = 0.1.
 *
 */
public class Influenssapopulaatiossa {

    OctaveEngine octave = new OctaveEngineFactory().getScriptEngine();
    private double[] tuloksetI;
    private double[] tuloksetS;
    private double N;
    private double I;
    private double B;
    private double a;
    private double[] T;
    private ArrayList<double[]> tulokset = new ArrayList<>();

    /**
     * Lasketaan taudin kehitys populaatiossa differentiaaliyhtälöstä.
     * Approksimoimme diff.yhtälöparia dS/dt = -BSI +aI, dI/dt = -BSI - aI nk.
     * Runge-Kutan menetelmällä octavessa lsode- nimisellä scriptillä
     *
     *
     * @param N - populaation koko
     * @param I - sairastuneita alussa
     * @param B - tarttumisintesiteetti
     * @param a - tod.näk tervehty' per aikayksikkö
     * @return
     */
    public ArrayList<double[]> laskeSIS(double N, double I, double B, double a, double t1) {

        this.N = N;
        this.I = I;
        this.B = B;
        this.a = a;
        double S = N - I;

        String S0 = "S0 = " + S;

        String I0 = "I0 = " + I;

        octave.eval(S0 + ";");
        octave.eval(I0 + ";");

        octave.eval("function ret = f(X,t) ret = [-" + this.B + "*X(1)*X(2) + " + this.a + "*X(2)," + this.B + "*X(1)*X(2)-" + this.a + "*X(2)]; end");
        octave.eval("T=linspace(0," + t1 + "," + t1 * 15 + ");");

        //Syötteen ollessa niin suuri että lasku mahdoton octavelle, palautetaan silloin arraylist missä on vain tyhjiä taulukoita:
        try {
            octave.eval("X=lsode('f',[S0, I0], T);");
        } catch (dk.ange.octave.exception.OctaveEvalException e) {
            return null;
        }

        octave.eval(" S =X(:,1)';");
        octave.eval("I = X(:,2)';");

        OctaveDouble arvot = octave.get(OctaveDouble.class, "T");
        this.T = arvot.getData();
        this.tulokset.add(this.T);

        arvot = octave.get(OctaveDouble.class, "I");
        this.tuloksetI = arvot.getData();
        this.tulokset.add(this.tuloksetI);

        arvot = octave.get(OctaveDouble.class, "S");
        this.tuloksetS = arvot.getData();
        this.tulokset.add(this.tuloksetS);

        octave.eval("clear all");

        return this.tulokset;

    }

    /**
     * Metodissa laskemme taudin kehityksen kun sairastuneet saavat
     * sairastettuaan pysyvän immuniteetin.Approksimoimme diff.yhtälöparia dS/dt
     * = -BSI, dI/dt = -BSI - aI nk. Runge-Kutan menetelmällä octavessa lsode-
     * nimisellä scriptillä
     *
     *
     * Sairaudelle alttiiden määrä alussa:
     *
     * @param N - Populaation koko
     * @param I - Sairastuneita alussa
     * @param B - Tarttumisintesiteetti
     * @param a - Tod.näk. tervehtyä per aikayksikkö.
     * @return
     */
    public ArrayList<double[]> laskeSIR(double N, double I, double B, double a, double t1) {
        this.N = N;
        this.I = I;
        this.B = B;
        this.a = a;
        double S = N - I;

        //Syötetään octavelle arvot:
        String S0 = "S0 = " + S;

        String I0 = "I0 = " + I;

        octave.eval(S0 + ";");
        octave.eval(I0 + ";");

        octave.eval("function ret = f(X,t) ret = [-" + this.B + "*X(1)*X(2)," + this.B + "*X(1)*X(2)-" + this.a + "*X(2)]; end");
        octave.eval("T=linspace(0," + t1 + "," + t1 * 15 + ");");

        try {
            octave.eval("X=lsode('f',[S0, I0], T);");
        } catch (dk.ange.octave.exception.OctaveEvalException e) {
            return null;
        }

        octave.eval(" S =X(:,1)';");
        octave.eval("I = X(:,2)';");

        OctaveDouble arvot = octave.get(OctaveDouble.class, "T");
        this.T = arvot.getData();
        this.tulokset.add(this.T);

        arvot = octave.get(OctaveDouble.class, "I");
        this.tuloksetI = arvot.getData();
        this.tulokset.add(this.tuloksetI);

        arvot = octave.get(OctaveDouble.class, "S");
        this.tuloksetS = arvot.getData();
        this.tulokset.add(this.tuloksetS);

        octave.eval("clear all");
        return this.tulokset;
    }

    /**
     *
     * Palautetaan pysyvästi sairastuneiden lukumäärä SIS- mallissa. On
     * osoitettavissa että se on laskettavissa kaavasta v = N - (a / B). Tapaus
     * B=0 käsitellään erikseen.
     *
     * @return raja-arvo
     */
    public double TulostaRajaArvoSIS() {

        if (B == 0) {
            if (a == 0) {
                return this.I;
            } else {
                return 0;
            }
        }

        double v = N - (a / B);

        if (this.I == 0) {
            return 0;
        }
        if (v < 0) {

            return 0;

        } else if (v > 0) {

            return v;
        }

        return 0;

    }

  
//    public double PalautaR() {
//        if (this.a == 0) {
//            return Double.MAX_VALUE;
//        }
//        
//        return (this.B / this.a) * this.N;
//    }

    /**
     * Laskemme S:n raja-arvon immuniteettimallissa. Tässä mallissa sairaus ei
     * pysy populaatiossa, sillä kaikki sairastaneet saavat lopulta
     * immuniteetin. Lasketaan siis taudin sairastaneiden kokonaismäärä ennen
     * kuin epidemia katoaa. Taudin sairastaneet lopussa on sama kuin
     * immuniteettiluokassa olevat, eli N-S
     *
     *
     * @return -palauttaa double- muotoisen raja-arvon
     */
    public double TulostaRajaArvoSIR() {

        return N - tuloksetS[tuloksetS.length - 1];

    }

    /**
     * Palautetaan I:n suurin arvo
     *
     * @return palauttaa double muotoisen arvon
     */
    public double PalautaSairaitaMax() {
        double suurin = 0;

        for (double l : tulokset.get(1)) {
            if (suurin < l) {
                suurin = l;
            }
        }
        return suurin;
    }
}
