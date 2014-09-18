package matematiikka;

import dk.ange.octave.OctaveEngine;
import dk.ange.octave.OctaveEngineFactory;
import dk.ange.octave.type.OctaveDouble;
import dk.ange.octave.type.OctaveString;
import java.util.Arrays;

public class influenssapopulaatiossa {

    OctaveEngine octave = new OctaveEngineFactory().getScriptEngine();
    private double[] tulokset;
    private int N;
    private int I;
    private double B;
    private double a;

    public void laske(int N, int I, double B, double a) {

        this.N = N;
        this.I = I;
        this.B = B;
        this.a = a;

        //luodaan ensin yhtälö stirngiin:
        String f = B + "*x*(" + (N - (a / B)) + "-x)";

        //Käytetään octavea hyväksi yksinkertaisen differentiaaliyhtälömme ratkaisuun:
        octave.eval("function x_prime = f(x,t) x_prime = " + B + "*x*(" + (N - (a / B)) + "-x)" + "; endfunction;");
        octave.eval("x_0 = " + I + ";");
        octave.eval("t=linspace(0,20,100);");
        octave.eval("y = lsode(@(x, t) " + f + ", x_0,t);");

        OctaveDouble h = octave.get(OctaveDouble.class, "y");
        octave.close();

        //Listataan ratkaisut:
        this.tulokset = h.getData();

        //Tulostetaan ratkaisuja:
        for (int i = 0; i < 100; i++) {

            //Pyöristetään lähimpään kokonaislukuun, ja tulostetaan ratkaisut t arvoilla 1,20 (väli jaettu sataan osaan) Ratkaisu kuvaa siis sairaiden määrää populaatiossa:
            System.out.print((int) (this.tulokset[i] + 0.5) + " ");

        }
        System.out.println("");
        System.out.println(Tulostatulokset() +"\\"+ TulostaRajaArvo() );

    }

    public String Tulostatulokset() {

        String tulostring = "";
        //Käydään ratkaisut läpi ja lisätään palautettavaan stringiin:
        for (int i = 0; i < 100; i++) {

            //Pyöristetään lähimpään kokonaislukuun, ja tulostetaan ratkaisut t arvoilla 1,20 (väli jaettu sataan osaan) Ratkaisu kuvaa siis sairaiden määrää populaatiossa:
            tulostring = tulostring + ((int) (this.tulokset[i] + 0.5) + " ");
        }
        return tulostring;

    }

    public String TulostaRajaArvo() {

        double v = N - (a / B);

        //TriviaaliRatkaisuna kun I_0 = 0 --> I = 0 kaikilla t:
        if(this.I == 0) {
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

}
