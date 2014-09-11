
package Populaatiot;

import java.util.Scanner;

//Tällä luokalla testataan syötteiden oikeellisuutta.

public class SyotteidenTestaus {
    
    Scanner lukija = new Scanner(System.in);
    
     //Metodi kokonaislukujen syöttämiseen, palauttaa 'true' onnistuessaan:
    public void KokonaisluvunSyotto(String syote, int luku) {

        while (true) {

           //Tarkistetaan onko syöte ylipäänsä numero ja että onko se oikealla välillä:
            if (TarkistaOnkoNumeroOikeallaValilla(syote)) {
                //Kaikki ok ja asetetaan populaation syöte populaation arvoksi:

                luku = Integer.parseInt(syote);
                break;

            } else {
                //Muuten herjataan:
                System.out.println("Anna numero väliltä 2-1000!");
                syote = lukija.nextLine();

            }

        }

    }

    //Metodi, jonka avulla syötetään desimaalilukuja välillä 0-1, palauttaa 'true' onnistueassaan.
    public void DesimaalinSyotto(String syote, double desimaali) {

        while (true) {

            if (TarkistaOnkovalillaNollaJaYksi(syote)) {
//Jos syöte on halutulla välillä, niin
                //asetetaan syöte leviämistodennäköisyyden arvoksi:
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
        //Tyhjä syöte palauttaa false:
        if(syote.isEmpty()) {
            return false;
        }
        for (int i = 0; i < syote.length(); i++) {
            char a = syote.charAt(i);
            if (!Character.isDigit(a)) {
                //Syöte sisälsi kirjaimen tai erikoismerkin,joten palautetaan false:
                return false;
            }
        }
        //Tarkistetaan vielä, että syöte on oikealla välillä:

        return Integer.parseInt(syote) >= 2 && Integer.parseInt(syote) <= 1000;
    }

//Metodi testaamaan onko numero välillä nolla ja yksi:
    public boolean TarkistaOnkovalillaNollaJaYksi(String syote) {
        //Tyhjä syöte, tai pelkkä nolla palauttaa false (Haluamme luvun aidosti välillä (0,1)):
        if(syote.isEmpty() || syote.equals("0")) {
            return false;
        }
        //ensimmäisen merkin tulee olla nolla:
        
        if (syote.charAt(0) != '0') {
            
            return false;
        }

        if (syote.length() >= 2) {
            //toisen merkin tulee olla piste:
            if (syote.charAt(1) != '.') {
                return false;
            }
            if (syote.length() >= 3) {
                for (int i = 2; i < syote.length(); i++) {
                    char a = syote.charAt(i);

                    if (!Character.isDigit(a)) {
                        //Syöte sisälsi kirjaimen tai erikoismerkin,joten palautetaan false:
                        return false;
                    }
                }
            }
            //Muuten kaikki ok, ja palautetaan true:

        }
        return true;
    }

    

}

    
    
    
    
    

