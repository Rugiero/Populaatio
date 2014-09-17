package Tekstikayttoliittyma;

import java.util.Scanner;

public class petoelainsaaliselain {

    private final Scanner lukija = new Scanner(System.in);

    private int populaatioPedot=0;
    private int populaatioSaalikset=0;
    private double lisaantymistahtiPedot=0;
    private double petoelaintentehokkuus=0;
    private double lisaantymistahtiSaalikset=0;
    private Populaatiot.PopulaatioKaksiLajia Populaatio;
    private Populaatiot.SyotteidenTestaus Syotteidentestaus = new Populaatiot.SyotteidenTestaus();
    public void paanakyma() {
        {
            
            //Luodaan ensin populaatiollemme olio:
            this.Populaatio = new Populaatiot.PopulaatioKaksiLajia(populaatioPedot, populaatioSaalikset, lisaantymistahtiPedot, petoelaintentehokkuus, lisaantymistahtiSaalikset);
            //Ensin kysytään petojen populaation kokoa:
            System.out.println("Anna petojen populaation koko (2-1000)");

           Syotteidentestaus.KokonaisluvunSyotto(lukija.nextLine(), this.populaatioPedot);

            //Sitten saalisten populaation kokoa:
            System.out.println("Anna saalisten populaatio koko (2-1000)");
                 Syotteidentestaus.KokonaisluvunSyotto(lukija.nextLine(), this.populaatioPedot);

            //Sitten lisääntymistahtia:
            System.out.println("Anna petojen lisääntymistahti desimaalina väliltä 0.0-1.0");
           Syotteidentestaus.DesimaalinSyotto(lukija.nextLine(), this.lisaantymistahtiPedot);
            System.out.println("Anna saalisten lisääntymistahti desimaalina väliltä 0.0-1.0");
            Syotteidentestaus.DesimaalinSyotto(lukija.nextLine(), this.lisaantymistahtiSaalikset);

            //Sitten petojen 'tehokkuutta':
            System.out.println("Anna petojen tehokkuus desimaalina väliltä 0.0-1.0");
            Syotteidentestaus.DesimaalinSyotto(lukija.nextLine(), this.lisaantymistahtiSaalikset);

        }

    }

  
}
