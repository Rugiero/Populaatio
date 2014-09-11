//Luokkaan konstruoidaan olio mikä vastaa populaatiota ,missä on kaksi lajia. Tarkoitettu
//petoeläin- saaliseläin tilanteeseen.
package Populaatiot;

public class PopulaatioKaksiLajia {

    private int populaatioPedot;
    private int populaatioSaalikset;
    private double lisaantymistahtiPedot;
    private double petoelaintentehokkuus;
    private double lisaantymistahtiSaalikset;

    //Konstruoidaan populaatio:
    public PopulaatioKaksiLajia(int koko1, int koko2, double lisaantymistahti1, double tehokkuus, double lisaantymistahti2) {
        this.populaatioPedot = koko1;
        this.populaatioSaalikset = koko2;
        this.lisaantymistahtiPedot = lisaantymistahti1;
        this.petoelaintentehokkuus = tehokkuus;
        this.lisaantymistahtiSaalikset = lisaantymistahti2;

    }
        

}
