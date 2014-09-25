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

        //Käytetään octavea hyväksi tavallisen differentiaaliyhtälömme ratkaisuun:
        octave.eval("function x_prime = f(x,t) x_prime = " + B + "*x*(" + (N - (a / B)) + "-x)" + "; endfunction;");
        octave.eval("x_0 = " + I + ";");
        octave.eval("t=linspace(0,20,100);");
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

        //Metodissa laskemme taudin kehityksen kun sairastuneet saavat sairastettuaan pysyvän immuniteetin. Approksimoimme diff.yhtälöparia 
        // dS/dt = -BSI, dI/dt = -BSI - aI 
        //nk. Eulerin menetelmällä. Muotoa y' = F(x,t) olevaa diff. yhtälöä voi approksimoida diskreetisti y(i+1) = F(i,t)*h + y(i), missä h on valittu väli.
        //Mallissamme siis populaation jäsenet siirtyvät lopulta immuniteetin saaneideen luokkaan 'R': S --> I --> R, missä S on sairaudelle alttiiden määrä. R voidaan tässä jättää huomioimatta yhtälöissämme.
        //Luodaan ensin yhtälöt. Asetetaan h=0.2:
//        String dS = "S(i+1) = (-B*S(i)*I(i))*0.2+S(i)";
//        String dI = "(B*S(i)*I(i)-a*I(i))*0.2+I(i)";
        //Sairaudelle alttiiden määrä alussa:
        int S = N - I;
        String S0 = "S(1) = " + S;
        //Sairaita alussa:
        String I0 = "S(1) = " + I;
        
        octave.eval(S0);
        octave.eval(I0);
        octave.eval("B = " + B);
        octave.eval("a= " + a);
        
        octave.eval("for 1:1000 S(i+1) = (-B*S(i)*I(i))*0.2+S(i); I(i+1) = (B*S(i)*I(i)-a*I(i))*0.2+I(i); endfor;");
        
        OctaveDouble sairastuneita = octave.get(OctaveDouble.class, "I");
     
        octave.close();
        
        
        this.tulokset = sairastuneita.getData();
        System.out.println(Tulostatulokset());
        

        
        
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
    
    public String TulostaRajaArvoImmuniteetilla() {
        //Laskemme S:n raja-arvon immuniteettimallissa. On osoitettavissa, että se hoituu laskemalla yhtälön
        // 0=(1-s)+(1/R0)*ln(s) juuret. Tässä s= S/N ja R0 = (B/a)*N
        
        //Jos R0 < 1, Tartunnan saaneet henkilöt eivät tartuta ketään lisää. Siis epidemiaa ei synny ja :
        
       // if()
        
        
        
        
        return null;
        
        
        
    }
    
    
    
    
    
}
