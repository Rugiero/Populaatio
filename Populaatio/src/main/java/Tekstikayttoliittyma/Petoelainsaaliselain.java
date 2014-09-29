package Tekstikayttoliittyma;

import Graafinenkayttoliittyma.PiirraKayra;
import java.util.ArrayList;
import java.util.Scanner;

public class Petoelainsaaliselain {

    private final Scanner lukija = new Scanner(System.in);
    private ArrayList<double[]> tulokset;
    private int N1 = 1000;

    private double a = 5;
    private double b = 3;
    private double c = 5;
    private double d = 4;
    private matematiikka.Petoelainsaaliselain laskin = new matematiikka.Petoelainsaaliselain();
    //   private Populaatiot.PopulaatioKaksiLajia Populaatio;
    private Populaatiot.SyotteidenTestaus Syotteidentestaus = new Populaatiot.SyotteidenTestaus();

    public void paanakyma() {
        tulokset = laskin.laske(N1, 0.4, 0.37, 0.3, 0.05);

        PiirraKayra kayra = new PiirraKayra("Saalikset ja pedot", "lkm.", "t", tulokset);
        
    kayra.Piirretaankayra();
           kayra.setVisible(true);
           
           PiirraKayra kayra1 = new PiirraKayra("Saalikset ja pedot faasidiagrammi", "Jänöt", "Ketut", tulokset);  
        kayra1.PiirretaankayraFaasi();
         kayra1.setVisible(true);
        
    }
}
