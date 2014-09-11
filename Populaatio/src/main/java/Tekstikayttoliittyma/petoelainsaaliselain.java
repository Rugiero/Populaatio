package Tekstikayttoliittyma;

import java.util.Scanner;

public class petoelainsaaliselain {

    private final Scanner lukija = new Scanner(System.in);

    private int populaatioPedot;
    private int populaatioSaalikset;
    private double lisaantymistahtiPedot;
    private double petoelaintentehokkuus;
    private double lisaantymistahtiSaalikset;

    public void paanakyma() {
        {

            //Ensin kysytään petojen populaation kokoa:
            System.out.println("Anna petojen populaation koko (2-1000)");

            KokonaisluvunSyotto(lukija.nextLine(), this.populaatioPedot);

           //Sitten saalisten populaation kokoa:
            System.out.println("Anna saalisten populaatio koko (2-1000)");
            KokonaisluvunSyotto(lukija.nextLine(), this.populaatioSaalikset);

            //Sitten lisääntymistahtia:
            System.out.println("Anna petojen lisääntymistahti desimaalina väliltä 0.0-1.0");
            DesimaalinSyotto(lukija.nextLine(), this.lisaantymistahtiPedot);
            System.out.println("Anna saalisten lisääntymistahti desimaalina väliltä 0.0-1.0");
            DesimaalinSyotto(lukija.nextLine(), this.lisaantymistahtiSaalikset);

            //Sitten petojen 'tehokkuutta':
            System.out.println("Anna petojen tehokkuus desimaalina väliltä 0.0-1.0");
            DesimaalinSyotto(lukija.nextLine(), this.petoelaintentehokkuus);

            
            //Lopuksi luodaan populaatio-olio annetuilla arvoilla
            Populaatiot.PopulaatioKaksiLajia UusiPopulaatio = new Populaatiot.PopulaatioKaksiLajia(populaatioPedot, populaatioSaalikset, lisaantymistahtiPedot, petoelaintentehokkuus, lisaantymistahtiSaalikset);
            
          
        }

    }

    public void DesimaalinSyotto(String syote, double desimaali) {

        while (true) {
            //jos syöte on halutulla välillä:
            if (TarkistaOnkovalillaNollaJaYksi(syote)) {

                //Asetetaan syöte leviämistodennäköisyyden arvoksi:
                desimaali = Double.parseDouble(syote);
                break;

            } else {
                //muuten herjataan
                System.out.println("Anna luku desimaaliluku väliltä 0.0-1.0!");
                syote = lukija.nextLine();
            }

        }

    }

    public void KokonaisluvunSyotto(String syote, int luku) {

        while (true) {

            syote = lukija.nextLine();
            //jos syote on numero, pitää vielä tarkistaa että se kuuluu annetulle välille:
            if (TarkistaOnkoNumeroOikeallaValilla(syote)) {
                //Kaikki ok ja asetetaan populaation syöte populaation arvoksi:

                luku = Integer.parseInt(syote);
                break;

            } else {
                //Muuten herjataan:
                System.out.println("Anna numero väliltä 2-1000!");
            }

        }

    }

    public boolean TarkistaOnkoNumeroOikeallaValilla(String syote) {
        for (int i = 0; i < syote.length(); i++) {
            char a = syote.charAt(i);
            if (!Character.isDigit(a) && Integer.parseInt(syote) >= 2 && Integer.parseInt(syote) <= 1000) {
                //Syöte sisälsi kirjaimen tai erikoismerkin,joten palautetaan false:
                return false;
            }
        }
        return true;
    }

    public boolean TarkistaOnkovalillaNollaJaYksi(String syote) {
        //ensimmäisen merkin tulee olla nolla: 
        if (syote.charAt(0) != '0') {
            return false;
        }
        //toisen merkin tulee olla piste:
        if (syote.charAt(1) != '.') {
            return false;
        }

        for (int i = 2; i < syote.length(); i++) {
            char a = syote.charAt(i);

            if (!Character.isDigit(a)) {
                //Syöte sisälsi kirjaimen tai erikoismerkin,joten palautetaan false:
                return false;
            }
        }
        //Muuten kaikki ok, ja palautetaan true:
        return true;

    }
}
