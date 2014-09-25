/**
 * Luokkaan konstruoidaan olio mikä vastaa populaatiota missä on kaksi lajia.
 * Tarkoitettu petoeläin- saaliseläin tilanteeseen. Huom: Luokka on vielä kesken
 */
package Populaatiot;

public class PopulaatioKaksiLajia {

    private int populaatioPedot = 0;
    private int populaatioSaalikset = 0;
    private double lisaantymistahtiPedot = 0;
    private double petoelaintentehokkuus = 0;
    private double lisaantymistahtiSaalikset = 0;

    /**
     * Konstruoidaan populaatio:
     */
    public PopulaatioKaksiLajia(int koko1, int koko2, double lisaantymistahti1, double tehokkuus, double lisaantymistahti2) {
        this.populaatioPedot = koko1;
        this.populaatioSaalikset = koko2;
        this.lisaantymistahtiPedot = lisaantymistahti1;
        this.petoelaintentehokkuus = tehokkuus;
        this.lisaantymistahtiSaalikset = lisaantymistahti2;

    }

    @Override
    public String toString() {
        return "Petojen populaatio: " + populaatioPedot + "Saalisten populaatio: "
                + populaatioSaalikset + "Petojen lisääntymistahti: " + lisaantymistahtiPedot + "Saalisten lisääntymistahti: " + lisaantymistahtiSaalikset
                + "Petoeläinten tehokkuus: " + petoelaintentehokkuus;
    }

}
