package matematiikka;

import dk.ange.octave.OctaveEngine;
import dk.ange.octave.OctaveEngineFactory;
import dk.ange.octave.type.OctaveDouble;
import dk.ange.octave.type.OctaveString;
import java.util.Arrays;

public class influenssapopulaatiossa {

    OctaveEngine octave = new OctaveEngineFactory().getScriptEngine();

    public void laske(int N, int I, double B, double a) {

 
        
        String f =   B + "*x*(" + (N -(a/B)) +"-x)";

        octave.eval("function x_prime = f(x,t) x_prime = " +B + "*x*(" + (N -(a/B)) +"-x)" +  "; endfunction;");
        octave.eval("x_0 = " + I +";");
        octave.eval("t=linspace(0,20,100);");
        octave.eval("y = lsode(@(x, t) " + f + ", x_0,t);");

        OctaveDouble h = octave.get(OctaveDouble.class, "y");
        octave.close();
     
        double[] result = h.getData();
       for(int i=0; i < 100; i++) {
           
           System.out.print(result[i] + " ");
           
       }


    }

}
