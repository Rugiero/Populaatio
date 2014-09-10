package logiikka;

import java.util.Scanner;

public class paavalikko {

    private final Scanner lukija = new Scanner(System.in);
    String syote;
    private logiikka.influenssapopulaatiossa influenssapopulaatiossa = new logiikka.influenssapopulaatiossa();
    private logiikka.petoelainsaaliselain petoelainsaaliselain = new logiikka.petoelainsaaliselain();

    public void alkunakyma() {

        System.out.println("Tervetuloa Populaatio ohjelman pariin! Valitse vaihtoehdoista:");
        System.out.println("1: Influenssa Populaatiossa");
        System.out.println("2: Petoeläin- saaliseläin populaatio");
        System.out.println("3: exit");

        while (true) {
            this.syote = lukija.nextLine();

            if (this.syote.equals("1")) {
                this.influenssapopulaatiossa.paanakyma();
            } else if (this.syote.equals("2")) {
                this.petoelainsaaliselain.paanakyma();
                
            } 
            else if( this.syote.equals("3")) {
                break;
            }
                else {
                System.out.println("");
                System.out.println("Valitse vaihtoehdoista:");
                System.out.println("1: Influenssa Populaatiossa");
                System.out.println("2: Petoeläin- saaliseläin populaatio");
            }
        }

    }

}
