package Tekstikayttoliittyma;

import Graafinenkayttoliittyma.PiirraFaasikayra;
import Graafinenkayttoliittyma.PiirraKayra;
import java.util.ArrayList;
import java.util.Scanner;

public class PetoelainSaaliselain {

    /**
     * N1: Populaation koko.
     *
     * * @param N1 : populaation koko.
     *
     * @param R1 : saaliseläinten tiheys aluksi
     * @param F1 : petoeläintn tiheys aluksi
     * @param a : pos. vakio
     * @param b : pos. vakio
     * @param c : pos. vakio
     * @param d : pos. vakio
     *
     *
     *
     */
    private final Scanner lukija = new Scanner(System.in);
    private ArrayList<double[]> tulokset;
    //private int N = 1000;
    private Double R1;
    private Double F1;
    private double a = 5;
    private double b = 3;
    private double c = 5;
    private double d = 4;
    private Matematiikka.Petoelainsaaliselain laskin = new Matematiikka.Petoelainsaaliselain();
    private Populaatiot.PopulaatioKaksiLajia Populaatio;
    private Graafinenkayttoliittyma.SyotteidenTestaus Syotteidentestaus = new Graafinenkayttoliittyma.SyotteidenTestaus();
    private final ArvojenKyselyt arvojenkysely = new ArvojenKyselyt();
    


    public void paanakyma() {
        /**
         * Kysytään parametreja:
         *
         */

        this.R1 = arvojenkysely.ArvojenKyselyDesimaalit("Saalisten tiheys:  ");
        this.F1 = arvojenkysely.ArvojenKyselyDesimaalit("Vihollisten tiheys: ");

        this.a = arvojenkysely.ArvojenKyselyDesimaalit("a ");
        this.b = arvojenkysely.ArvojenKyselyDesimaalit("b ");
        this.c = arvojenkysely.ArvojenKyselyDesimaalit("c ");
        this.d = arvojenkysely.ArvojenKyselyDesimaalit("d ");

        this.Populaatio = new Populaatiot.PopulaatioKaksiLajia(R1, F1, a, b, c, d);

        tulokset = Populaatio.LaskeKehitys();
        
        PiirraKayra kayra = new PiirraKayra("Saalikset ja pedot", "lkm", "t", tulokset);
        kayra.Piirretaankayra();
        kayra.setVisible(true);

        PiirraFaasikayra kayra1 = new PiirraFaasikayra("Saalikset ja pedot faasidiagrammi", "Jänöt", "Ketut", tulokset);
        kayra1.PiirretaankayraFaasi();
        kayra1.setVisible(true);

    }
}
