/**
 * Luokalla konstruoidaan olio, mikä sisältää tiedot yhden lajin populaatiossa.
 * Tarkoitettu 'Influenssapopulaatiossa' tilanteeseen.
 */
package Populaatiot;

public class PopulaatioYksiLaji {

    private int populaationkoko;
    private int sairastuneitaalussa;

    private double tarttuvuus;
    private double tiheys;
    private double todennakoisyystoipua;

    private matematiikka.Influenssapopulaatiossa math = new matematiikka.Influenssapopulaatiossa();

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
    public double[] laskeKehitysSISmalli() {

       return math.laskeSIS(this.populaationkoko, this.sairastuneitaalussa, this.tarttuvuus, this.todennakoisyystoipua);

    }

    /**
     * Lasketaan kehitys immuniteetilla
     */
    public void laskeKehitysSIRmalli() {

        math.laskeSIR(this.populaationkoko, this.sairastuneitaalussa, this.tarttuvuus, this.todennakoisyystoipua);
    }

//    public void AsetaPopulaatio(int a) {
//        this.populaationkoko = a;
//
//    }
//
//    public void AsetaTarttuvuus(double a) {
//        this.tarttuvuus = a;
//
//    }
//
//
//    public void Asetatiheys(double a) {
//        this.tiheys = a;
//
//    }
//
//    @Override
//    public String toString() {
//        return "Koko: " + populaatio + "Lisääntymistahti: " + lisaantymistahti + "Tarttuvuus: " + tarttuvuus + "Tiheys: " + tiheys;
//    }
}
