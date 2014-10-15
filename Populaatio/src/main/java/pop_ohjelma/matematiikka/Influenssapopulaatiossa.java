package pop_ohjelma.matematiikka;

import dk.ange.octave.OctaveEngine;
import dk.ange.octave.OctaveEngineFactory;
import dk.ange.octave.type.OctaveDouble;
import java.util.ArrayList;

/**
 * Luokka laskee taudin kehityksen populaatiossa SIS tai SIR mallien mukaisesti.
 * Käytetään numeerista Runge-Kuttan menetelmää octaven 'lsode' scriptissä.
 * @author iangervu
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
     * Runge-Kutan menetelmällä octavessa lsode- nimisellä scriptillä.
     *
     *
     * @param N populaation koko
     * @param I sairastuneita alussa
     * @param B tarttumisintesiteetti
     * @param a tod.näk tervehty' per aikayksikkö
     * @param t1 aika-arvo mihin lasketaan
     * @return ArrayList taulukoita
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
     * nimisellä scriptillä.
     *
     *
     *
     *
     * @param N Populaation koko
     * @param I Sairastuneita alussa
     * @param B Tarttumisintesiteetti
     * @param a Tod.näk. tervehtyä per aikayksikkö.
     * @param t1 aika-arvo mihin lasketaan
     * @return ArrayList taulukoita
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
     * @return Tulos on eksakti riippumatta valitusta t1
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

    /**
     * Laskee sairastuneiden määrän kokonaisuudessaan ennen kuin tauti katoaa
     * populaatiosta SIR-mallissa. Tässä mallissa sairaus ei pysy populaatiossa,
     * sillä kaikki sairastaneet saavat lopulta immuniteetin. Lasketaan siis
     * taudin sairastaneiden kokonaismäärä ennen kuin epidemia 'katoaa'
     * populaatiossa. Taudin sairastaneet lopussa on sama kuin
     * immuniteettiluokassa olevat, eli N-S
     *
     *
     * @return double- muotoinen raja-arvo, laskettu viimeisestä lasketusta
     * arvosta t1, tulos ei ole siis eksakti
     */
    public double TulostaRajaArvoSIR() {

        return N - tuloksetS[tuloksetS.length - 1];

    }

    /**
     * Palautetaan I:n suurin arvo
     *
     * @return palauttaa double muotoisena sairastuneiden maksimimäärän
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

    /**
     * Palauttaa arvon mikä vastaa kuinka monta yksi sairastunut keskimäärin
     * sairastuttaa.
     *
     * @param B tarttumisintesiteetti
     * @param a tod.näk parantua/aikayksikkö
     * @param N populaation koko
     * @return double muotoinen arvo
     */
    public double PalautaR(double B, double a, double N) {

        return (B / a) * N;

    }
}
