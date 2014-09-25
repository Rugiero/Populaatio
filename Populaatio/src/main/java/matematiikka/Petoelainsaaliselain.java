package matematiikka;

import dk.ange.octave.OctaveEngine;
import dk.ange.octave.OctaveEngineFactory;
import dk.ange.octave.type.OctaveDouble;
import dk.ange.octave.type.OctaveString;

public class Petoelainsaaliselain {

    OctaveEngine octave = new OctaveEngineFactory().getScriptEngine();
    private int N;
    private int t0;
    private int tN;
    private double a;
    private double b;
    private double c;
    private double d;
        private double[] tulokset;
    
    public void laske(int N1, int t01, int tN1, double a, double b, double c, double d) {
        
        this.N = N1;
        this.t0 = t01;
        this.tN = tN1;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        
        double h = (double) (this.tN - this.t0) / (double)this.N;
        
        octave.eval("R(1)=3; F(1)=1;");
        octave.eval("for i = 1:"+this.N +" R(i+1) = R(i) + " + h + "*R(i)*("+ this.a +"-"+ this.c + "*F(i)); F(i+1) = F(i) +" + h + "*F(i)*("+ -this.b + "+"+ this.d + "*R(i)); end;");
        octave.eval("T=" +this.t0 +":" + h +":" + this.tN);
        
        System.out.println("for i = 1:"+this.N +" R(i+1) = R(i) + " + h + "*R(i)*("+ this.a +"-"+ this.c + "*F(i)); F(i+1) = F(i) +" + h + "*F(i)*("+ -this.b + "+"+ this.d + "*R(i)); end;");
        OctaveDouble arvot = octave.get(OctaveDouble.class, "R");
       //octave.eval("plot(R,F);");
        
        octave.close();
        
        
        this.tulokset = arvot.getData();
          
        String tulostring = "";
        //Käydään ratkaisut läpi ja lisätään palautettavaan stringiin:
        for (int i = 0; i < this.tulokset.length; i++) {

            
            tulostring = tulostring + (this.tulokset[i] + " ");
        }
       
        System.out.println(tulostring);
    }

        
        
    
    
}
