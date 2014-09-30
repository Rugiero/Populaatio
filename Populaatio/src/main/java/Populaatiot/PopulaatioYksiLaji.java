/**
 * Luokalla konstruoidaan olio, mikä sisältää tiedot yhden lajin populaatiossa.
 * Tarkoitettu 'Influenssapopulaatiossa' tilanteeseen.
 */
package Populaatiot;

import java.util.ArrayList;

public class PopulaatioYksiLaji {

    private int populaationkoko;
    private int sairastuneitaalussa;
    private double tarttuvuus;
    private double tiheys;
    private double todennakoisyystoipua;

    private Matematiikka.Influenssapopulaatiossa math = new Matematiikka.Influenssapopulaatiossa();

    /**
     * Luokkaan listataan yhden lajin populaation ominaisuuksia.
     * @param N
     * @param I
     * @param B
     * @param a
     */
    public PopulaatioYksiLaji(int N, int I, double B, double a) {

        this.populaationkoko = N;
        this.sairastuneitaalussa = I;
        this.tarttuvuus = B;
        this.todennakoisyystoipua = a;

    }

    /**
     * Lasketaan kehitys ilman immuniteettia:
     * @return 
     */
    public ArrayList<double[]> laskeKehitysSISmalli() {

       return math.laskeSIS(this.populaationkoko, this.sairastuneitaalussa, this.tarttuvuus, this.todennakoisyystoipua);

    }

    /**
     * Lasketaan kehitys immuniteetilla
     * @return 
     */
    public ArrayList<double[]> laskeKehitysSIRmalli() {

       return math.laskeSIR(this.populaationkoko, this.sairastuneitaalussa, this.tarttuvuus, this.todennakoisyystoipua);
    }



}
