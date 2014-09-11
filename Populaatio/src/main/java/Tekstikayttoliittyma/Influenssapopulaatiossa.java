package Tekstikayttoliittyma;

import java.util.Scanner;

public class Influenssapopulaatiossa {

    private final Scanner lukija = new Scanner(System.in);

    private int koko;
    private double lisaantymistahti;
    private double tarttuvuus;
    private double tiheys;

    public void paanakyma() {

        //Ensin kysytään populaation kokoa:
        System.out.println("Anna populaation koko (2-1000)");
        KokonaisluvunSyotto(lukija.nextLine(), this.koko);

        //Sitten kysytään leviämistodennäköisyyttä:
        System.out.println("Anna tarttuvuus desimaalina väliltä 0.0-1.0");
        DesimaalinSyotto(lukija.nextLine(), this.tarttuvuus);
        //Lisääntymistahtia:
        System.out.println("Anna lisääntymistahti desimaalina väliltä 0.0-1.0");
        DesimaalinSyotto(lukija.nextLine(), this.lisaantymistahti);
        //Tiheyttä:
        System.out.println("Anna tiheys desimaalina väliltä 0.0-1.0\"");
        DesimaalinSyotto(lukija.nextLine(), this.tiheys);
        
        
        //Lopuksi luodaan uusi populaatio-olio:
        Populaatiot.PopulaatioYksiLaji UusiPopulaatio = new Populaatiot.PopulaatioYksiLaji(koko, lisaantymistahti, tarttuvuus, tiheys);

    }

    //Metodi kokonaislukujen syöttämiseen:
    
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

    //Metodi, jonka avulla syötetään desimaalilukuja välillä 0-1.
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
//Metodi testaamaan, onko annettu syöte ylipäänsä numero:

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

//Metodi testaamaan onko numero välillä nolla ja yksi:
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
