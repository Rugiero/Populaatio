package Tekstikayttoliittyma;

import java.util.Scanner;

public class Influenssapopulaatiossa {

    private final Scanner lukija = new Scanner(System.in);

    private int koko = 0;
    private double lisaantymistahti = 0;
    private double tarttuvuus = 0;
    private double tiheys = 0;
    private Populaatiot.PopulaatioYksiLaji Populaatio;
    private Populaatiot.SyotteidenTestaus Syotteidentestaus = new Populaatiot.SyotteidenTestaus();
    

    public void paanakyma() {
        //Luodaan ensin populaatiollemme olio:
        this.Populaatio = new Populaatiot.PopulaatioYksiLaji(koko, lisaantymistahti, tarttuvuus, tiheys);
        //Ensin kysytään populaation kokoa:
        System.out.println("Anna populaation koko (2-1000)");
        Syotteidentestaus.KokonaisluvunSyotto(lukija.nextLine(), this.koko);

        //Sitten kysytään leviämistodennäköisyyttä:
        System.out.println("Anna tarttuvuus desimaalina väliltä 0.0-1.0");
        Syotteidentestaus.DesimaalinSyotto(lukija.nextLine(), this.tarttuvuus);
        //Lisääntymistahtia:
        System.out.println("Anna lisääntymistahti desimaalina väliltä 0.0-1.0");
        Syotteidentestaus.DesimaalinSyotto(lukija.nextLine(), this.lisaantymistahti);
        //Tiheyttä:
        System.out.println("Anna tiheys desimaalina väliltä 0.0-1.0");
        Syotteidentestaus.DesimaalinSyotto(lukija.nextLine(), this.tiheys);

      
    }


}
