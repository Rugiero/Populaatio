package Tekstikayttoliittyma;

import java.util.Scanner;

public class Paavalikko {

    private final Scanner lukija = new Scanner(System.in);
    String syote;
    private Tekstikayttoliittyma.Influenssapopulaatiossa influenssapopulaatiossa = new Tekstikayttoliittyma.Influenssapopulaatiossa();
    private Tekstikayttoliittyma.petoelainsaaliselain petoelainsaaliselain = new Tekstikayttoliittyma.petoelainsaaliselain();

    public void alkunakyma() {

        System.out.println("Tervetuloa Populaatio ohjelman pariin! Valitse vaihtoehdoista:");
        System.out.println("1: Luo uusi yhden lajin populaatio");
        System.out.println("2: Luo uusi kahden lajin populaatio");
        System.out.println("5: exit");

        while (true) {
            this.syote = lukija.nextLine();

            if (this.syote.equals("1")) {
                this.influenssapopulaatiossa.paanakyma();
            } else if (this.syote.equals("2")) {
                //TEST!:
                matematiikka.petoelainsaaliselain laskin = new matematiikka.petoelainsaaliselain();
                laskin.laske(5000, 0, 100, 0.4, 0.37, 0.3, 0.05);

            } else if (this.syote.equals("5")) {
                break;
            } else {
                System.out.println("");
                System.out.println("Valitse vaihtoehdoista:");
                System.out.println("1: Luo uusi yhden lajin populaatio");
                System.out.println("2: Luo uusi kahden lajin populaatio");
                System.out.println("5: exit");
            }
        }

    }

}
