package Matematiikka;

import Graafinenkayttoliittyma.PiirraKayra;
import dk.ange.octave.OctaveEngine;
import dk.ange.octave.OctaveEngineFactory;
import dk.ange.octave.type.OctaveDouble;
import dk.ange.octave.type.OctaveInt;
import dk.ange.octave.type.OctaveObject;
import dk.ange.octave.type.OctaveString;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.SwingUtilities;

public class Influenssapopulaatiossa {

    OctaveEngine octave = new OctaveEngineFactory().getScriptEngine();
    private double[] tuloksetI;
    private double[] tuloksetS;
    private int N;
    private int I;
    private double B;
    private double a;
    private double[] T;
    private ArrayList<double[]> tulokset = new ArrayList<>();

    public ArrayList<double[]> laskeSIS(int N, int I, double B, double a) {

        this.N = N;
        this.I = I;
        this.B = B;
        this.a = a;

        //**luodaan ensin yhtälö stirngiin. Käytetään octavea hyväksi tavallisen differentiaaliyhtälömme ratkaisuun:*/
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

        octave.close();

        return this.tulokset;

    }

    public ArrayList<double[]> laskeSIR(int N, int I, double B, double a) {
        this.N = N;
        this.I = I;
        this.B = B;
        this.a = a;
   

        /**
         * Metodissa laskemme taudin kehityksen kun sairastuneet saavat
         * sairastettuaan pysyvän immuniteetin. Approksimoimme diff.yhtälöparia
         * dS/dt = -BSI, dI/dt = -BSI - aI nk. Eulerin menetelmällä. Muotoa y' =
         * F(x,t) olevaa diff. yhtälöä voi approksimoida diskreetisti y(i+1) =
         * F(i,t)*h + y(i), missä h on valittu väli. Mallissamme siis
         * populaation jäsenet siirtyvät sairastuneiden luokasta I immuniteetin
         * saaneideen luokkaan 'R': S --> I --> R, missä S on sairaudelle
         * alttiiden määrä. R voidaan tässä jättää huomioimatta yhtälöissämme.
         * Luodaan ensin yhtälöt. Asetetaan h=0.2.
         *
         * Sairaudelle alttiiden määrä alussa:
         */
        int S = N - I;
        /**
         * Sairaudelle alttiita alussa:
         */
        String S0 = "S(1) = " + S;
        /**
         * Sairaita alussa:
         */
        String I0 = "I(1) = " + I;

        octave.eval(S0);
        octave.eval(I0);
        octave.eval("B = " + B);
        octave.eval("a= " + a);

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

        octave.close();
        return this.tulokset;
    }

//    public String Tulostatulokset() {
//
//        String tulostring = "";
//        /**
//         * Käydään ratkaisut läpi ja lisätään palautettavaan stringiin:
//         */
//        for (int i = 0; i < 200; i++) {
//
//            /**
//             * Tulostetaan ratkaisut t arvoilla 1,20 (väli jaettu sataan osaan)
//             * Ratkaisu kuvaa siis sairaiden määrää populaatiossa:
//             */
//            tulostring = tulostring + (this.tulokset[i] + " ");
//        }
//        return tulostring;
//
//    }
    public String TulostaRajaArvoSIS() {

        double v = N - (a / B);

        /*TriviaaliRatkaisuna kun I_0 = 0 --> I = 0 kaikilla t: */
        if (this.I == 0) {
            return "Ei sairastuneita alussa, tauti ei puhkea.";
        }
        if (v < 0) {

            return "I-->0, Tauti on ohimenevä.";

        }
        if (v > 0) {

            return "Tauti on endeeminen (syntyy epidemia). I-->" + (int) (v + 0.5);
        }

        return "";

    }

//    public String TulostaRajaArvoSIR() {
//        /**
//         * Laskemme S:n raja-arvon immuniteettimallissa. Tässä mallissa sairaus
//         * ei pysy populaatiossa, sillä kaikki sairastaneet saavat lopulta
//         * immuniteetin. Lasketaan siis taudin sairastaneiden kokonaismäärä
//         * ennen kuin epidemia katoaa. On osoitettavissa, että se hoituu
//         * laskemalla yhtälön 0=(1-s)+(1/R0)*ln(s) juuret. Tässä s= S/N ja R0 =
//         * (B/a)*N
//         */
//
//        double R0 = (this.B / this.a) * this.N;
//
//        /**
//         * Jos R0 < 1, Tartunnan saaneet henkilöt 'eivät tartuta ketään lisää'.
//         * Siis epidemiaa ei synny ja :
//         */
//        if (R0 < 1) {
//            return "Epidemiaa ei synny. ";
//
//        } /**
//         * Muuten lasketaan juuri numeerisesti octavessa. Otetaan juurea lähellä
//         * olevaksi "arvaukseksi" S:n vii*meinen arvo ja muutetaan se
//         * suhteelliseksi osuudeksi s=S/N:
//         */
//        else if (R0 >= 1) {
//
//            double s = this.tulokset[1000] / this.N;
//            octave.eval("function y = f(x) y =(1-x)+(1/" + R0 + ")*log(x); endfunction; ");
//            octave.eval("sairaat =" + N + "- (fsolve (\"f\"," + s + "))*" + N + ";");
//
//            octave.eval("sairaat = int8(sairaat);");
//
//            OctaveInt S = octave.get(OctaveInt.class, "sairaat");
//            octave.close();
//            int[] sairastuneet = S.getData();
//
//            return "Epidemiassa sairastuneiden määrä: " + sairastuneet[0];
//
//        }
//
//        return null;
//
//    }
}
