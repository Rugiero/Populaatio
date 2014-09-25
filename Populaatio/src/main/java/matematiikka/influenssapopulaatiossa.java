package matematiikka;

import dk.ange.octave.OctaveEngine;
import dk.ange.octave.OctaveEngineFactory;
import dk.ange.octave.type.OctaveDouble;
import dk.ange.octave.type.OctaveObject;
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

        //Käytetään octavea hyväksi tavallisen differentiaaliyhtälömme ratkaisuun:
        
        octave.eval("function x_prime = f(x,t) x_prime = " + B + "*x*(" + (N - (a / B)) + "-x)" + "; endfunction;");
        octave.eval("x_0 = " + I + ";");
        octave.eval("t=linspace(0,200,1000);");
        octave.eval("y = lsode(@(x, t) " + f + ", x_0,t);");

        OctaveDouble h = octave.get(OctaveDouble.class, "y");
        octave.close();

        //Listataan ratkaisut:
        this.tulokset = h.getData();

        //Tulostetaan ratkaisuja:
        System.out.println("");
        System.out.println(Tulostatulokset());
        System.out.println(TulostaRajaArvo());

    }

    public void laskeImmuniteetilla(int N, int I, double B, double a) {
        this.N = N;
        this.I = I;
        this.B = B;
        this.a = a;

        //Metodissa laskemme taudin kehityksen kun sairastuneet saavat sairastettuaan pysyvän immuniteetin. Approksimoimme diff.yhtälöparia 
        // dS/dt = -BSI, dI/dt = -BSI - aI 
        //nk. Eulerin menetelmällä. Muotoa y' = F(x,t) olevaa diff. yhtälöä voi approksimoida diskreetisti y(i+1) = F(i,t)*h + y(i), missä h on valittu väli.
        //Mallissamme siis populaation jäsenet siirtyvät sairastuneiden luokasta I immuniteetin saaneideen luokkaan 'R': S --> I --> R. S on siis sairaudelle alttiiden määrä. R voidaan tässä jättää huomioimatta yhtälöissämme.
        //Luodaan ensin yhtälöt. Asetetaan h=0.2:
//        String dS = "S(i+1) = (-B*S(i)*I(i))*0.2+S(i)";
//        String dI = "(B*S(i)*I(i)-a*I(i))*0.2+I(i)";
        //Sairaudelle alttiiden määrä alussa:
        int S = N - I;
        System.out.println(S);
        String S0 = "S(1) = " + S;
        //Sairaita alussa:
        String I0 = "I(1) = " + I;

        octave.eval(S0);
        octave.eval(I0);
        octave.eval("B = " + B);
        octave.eval("a= " + a);

        octave.eval("for i = 1:1000    S(i+1) = (-B*S(i)*I(i))*0.2+S(i); I(i+1) = (B*S(i)*I(i)-a*I(i))*0.2+I(i); endfor;");

        OctaveDouble sairastuneita = octave.get(OctaveDouble.class, "I");

    //    octave.close();

        this.tulokset = sairastuneita.getData();
        System.out.println(Tulostatulokset());
        System.out.println(TulostaTaudinSairastaneidenRajaArvo());

    }

    public String Tulostatulokset() {

        String tulostring = "";
        //Käydään ratkaisut läpi ja lisätään palautettavaan stringiin:
        for (int i = 0; i < 200; i++) {

            //Tulostetaan ratkaisut t arvoilla 1,20 (väli jaettu sataan osaan) Ratkaisu kuvaa siis sairaiden määrää populaatiossa:
            tulostring = tulostring + (this.tulokset[i] + " ");
        }
        return tulostring;

    }

    public String TulostaRajaArvo() {

        double v = N - (a / B);

        //TriviaaliRatkaisuna kun I_0 = 0 --> I = 0 kaikilla t:
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

    public String TulostaTaudinSairastaneidenRajaArvo() {
        //Laskemme S:n raja-arvon immuniteettimallissa. Tässä mallissa sairaus ei pysy populaatiossa, 
        ///sillä kaikki sairastaneet saavat lopulta immuniteetin. Lasketaan sairastaneiden määrä. On osoitettavissa, että se hoituu laskemalla yhtälön
        // 0=(1-s)+(1/R0)*ln(s) juuret. Tässä s= S/N ja R0 = (B/a)*N

        double R0 = (this.B / this.a) * (double) this.N;

      
        //Jos R0 < 1, Tartunnan saaneet henkilöt 'eivät tartuta ketään lisää'. Siis epidemiaa ei synny ja :
        if (R0 < 1) {
            return "Epidemiaa ei synny. ";

        } //Muuten lasketaan juuri numeerisesti octavessa. Otetaan juurea lähellä olevaksi "arvaukseksi" S:n viimeinen arvo ja muutetaan se suhteelliseksi
        //osuudeksi s=S/N:
        else if (R0 >= 1) {
            
            double s = this.tulokset[1000] / this.N;
            octave.eval("function y = f(x) y =(1-x)+(1/" + R0 + ")*log(x); endfunction; ");
            octave.eval("juuri= fsolve (\"f\"," + s + ");");
            OctaveDouble juuri = octave.get(OctaveDouble.class, "juuri");
            octave.close();
            double[] koko = juuri.getData();
            //Immunineettiluokassa olevien, siis sairastuneiden määrä, on nyt:
            double sairastuneet = N - koko[0]*N;
            return "Epidemiassa sairastuneiden määrä: " + sairastuneet;

        }

        return null;

    }

}
