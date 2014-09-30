/**
 * Luokkaan konstruoidaan olio mikä vastaa populaatiota missä on kaksi lajia.
 * Tarkoitettu petoeläin- saaliseläin tilanteeseen. Huom: Luokka on vielä kesken
 */
package Populaatiot;

import java.util.ArrayList;

public class PopulaatioKaksiLajia {

    private double R1;
    private double F1;
    private double a;
    private double b;
    private double c;
    private double d;
private final Matematiikka.Petoelainsaaliselain math = new Matematiikka.Petoelainsaaliselain();
    /**
     * Konstruoidaan populaatio:
     * @param R1
     * @param F1
     * @param a
     * @param b
     * @param c
     * @param d
     */
    public PopulaatioKaksiLajia(double R1, double F1, double a, double b, double c, double d) {
        this.F1 = F1;
        this.R1 = R1;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

    }
    
    public ArrayList<double[]> LaskeKehitys() { 
        return math.laske(R1, F1,  a, b,  c, d);   
    }
    
    
    
}
