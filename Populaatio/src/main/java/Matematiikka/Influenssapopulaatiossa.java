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
     * Lasketaan taudin kehitys populaatiossa differentiaaliyhtälöstä f =
     * B*x*((N-(a/B))-x). Käytetään hyväksi octaven 'lsode' scriptiä-
     *
     *
     * @param N - populaation koko
     * @param I - sairastuneita alussa
     * @param B - tarttumisintesiteetti
     * @param a - tod.näk tervehty' per aikayksikkö
     * @return
     */
    public ArrayList<double[]> laskeSIS(double N, double I, double B, double a) {

        this.N = N;
        this.I = I;
        this.B = B;
        this.a = a;

        String f = B + "*x*(" + (N - (a / B)) + "-x)";

        octave.eval("function x_prime = f(x,t) x_prime = " + B + "*x*(" + (N - (a / B)) + "-x)" + "; endfunction;");
        octave.eval("x_0 = " + I + ";");
        octave.eval("t=linspace(0,200,1000);");
        octave.eval("y = lsode(@(x, t) " + f + ", x_0,t);");

        OctaveDouble arvot = octave.get(OctaveDouble.class, "t");
        this.T = arvot.getData();
        this.tulokset.add(this.T);

        arvot = octave.get(OctaveDouble.class, "y");
        this.tuloksetI = arvot.getData();
        this.tulokset.add(this.tuloksetI);

        octave.eval("clear all");

        return this.tulokset;

    }

    /**
     * Metodissa laskemme taudin kehityksen kun sairastuneet saavat
     * sairastettuaan pysyvän immuniteetin.Approksimoimme diff.yhtälöparia dS/dt
     * = -BSI, dI/dt = -BSI - aI nk. Eulerin menetelmällä. Muotoa y' = F(x,t)
     * olevaa diff. yhtälöä voi approksimoida diskreetisti y(i+1) = F(i,t)*h +
     * y(i), missä h on valittu väli. Mallissamme siis populaation jäsenet
     * siirtyvät sairastuneiden luokasta I immuniteetin saaneideen luokkaan 'R':
     * S --> I --> R, missä S on sairaudelle alttiiden määrä. R voidaan tässä
     * jättää huomioimatta yhtälöissämme. Luodaan ensin yhtälöt. Asetetaan
     * h=0.2.
     *
     * Sairaudelle alttiiden määrä alussa:
     *
     * @param N - Populaation koko
     * @param I - Sairastuneita alussa
     * @param B - Tarttumisintesiteetti
     * @param a - Tod.näk. tervehtyä per aikayksikkö.
     * @return
     */
    public ArrayList<double[]> laskeSIR(double N, double I, double B, double a) {
        this.N = N;
        this.I = I;
        this.B = B;
        this.a = a;
        double S = N - I;

        //Syötetään octavelle arvot:
        String S0 = "S(1) = " + S;

        String I0 = "I(1) = " + I;

        octave.eval(S0 + ";");
        octave.eval(I0 + ";");
        octave.eval("B = " + B + ";");
        octave.eval("a= " + a + ";");

        octave.eval("for i = 1:999    S(i+1) = (-B*S(i)*I(i))*0.2+S(i); I(i+1) = (B*S(i)*I(i)-a*I(i))*0.2+I(i); endfor;");
        octave.eval("T=linspace(0,200,1000);");

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

    public double TulostaRajaArvoSIS() {

        double v = N - (a / B);

        /*TriviaaliRatkaisuna kun I_0 = 0 --> I = 0 kaikilla t: */
        if (this.I == 0) {
            return 0;
        }
        if (v < 0) {

            return 0;

        }
        if (v > 0) {

            return (int) (v + 0.5);
        }

        return 0;

    }

    public double PalautaR() {

        return (this.B / this.a) * this.N;
    }

    /**
     * Laskemme S:n raja-arvon immuniteettimallissa. Tässä mallissa sairaus ei
     * pysy populaatiossa, sillä kaikki sairastaneet saavat lopulta
     * immuniteetin. Lasketaan siis taudin sairastaneiden kokonaismäärä ennen
     * kuin epidemia katoaa. On osoitettavissa, että se hoituu laskemalla
     * yhtälön 0=(1-s)+(1/R0)*ln(s) juuret. Tässä s= S/N ja R0 = (B/a)*N
     *
     * @return -palauttaa double- muotoisen raja-arvon
     */
    public double TulostaRajaArvoSIR() {

        double R0 = (this.B / this.a) * this.N;
        /**
         * Jos R0 < 1, Tartunnan saaneet henkilöt 'eivät tartuta ketään lisää'.
         * Siis epidemiaa ei synny ja :
         *
         *
         * Muuten lasketaan juuri numeerisesti octavessa. Otetaan juurea lähellä
         * olevaksi "arvaukseksi" S:n vii*meinen arvo ja muutetaan se
         * suhteelliseksi osuudeksi s=S/N.
         */

        if (R0 < 1) {
            return this.I;

        } else if (R0 >= 1) {

            double s = this.tulokset.get(2)[tulokset.get(2).length - 1] / this.N;

            octave.eval("function y = f(x) y =(1-x)+(1/" + R0 + ")*log(x); endfunction; ");
            octave.eval("sairaat =" + N + "- (fsolve (\"f\"," + s + "))*" + N + ";");

            OctaveDouble S = octave.get(OctaveDouble.class, "sairaat");
            octave.close();
            double[] sairastuneet = S.getData();

            return sairastuneet[0];
        }
        return 0;

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
