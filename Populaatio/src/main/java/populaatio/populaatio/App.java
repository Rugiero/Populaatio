package populaatio.populaatio;

import java.util.Scanner;
import Tekstikayttoliittyma.Paavalikko;

public class App {


    public static void main(String[] args){
        
 Tekstikayttoliittyma.Paavalikko valikko = new Paavalikko();
        Scanner lukija = new Scanner(System.in);

        System.out.println("Avataanko ohjelma \"Populaatio\"  joo/ei");

        String syote = lukija.nextLine();
        while (true) {

            if (syote.equals("joo")) {
                valikko.alkunakyma();
                System.out.println("Nähdään!");
                break;
            } else if (syote.equals("ei")) {
                System.out.println("Nähdään!");
               break;
            } else {
                System.out.println("Syötä joo tai ei");
            }
            syote = lukija.nextLine();

        }
        
        
 
    }

}
