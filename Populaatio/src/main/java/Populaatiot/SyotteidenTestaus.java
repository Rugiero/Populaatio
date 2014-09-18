
package Populaatiot;

import java.util.Scanner;

//Tällä luokalla testataan syötteiden oikeellisuutta.

public class SyotteidenTestaus {
    
    Scanner lukija = new Scanner(System.in);
    
     //Metodi kokonaislukujen syöttämiseen:
    public boolean KokonaisluvunSyotto(String syote) {

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

//Tarkistetaan vielä, että numero on yli nolla:
        return Integer.parseInt(syote)>= 0;
    }

    

    //Metodi, jonka avulla syötetään desimaalilukuja välillä 0-1:
    public boolean DesimaalinSyotto(String syote) {
        //Tyhjä syöte palauttaa false:
        if(syote.isEmpty()) {
            return false;
        }
        //Toisen kirjaimen pitää olla '.' ja ensimmäisen nolla:
        if(syote.charAt(0) != '0' || syote.charAt(1) != '.') {
            return false;
        }
      
        for (int i = 2; i < syote.length(); i++) {
            char a = syote.charAt(i);
            
            if (!Character.isDigit(a)) {
                //Syöte sisälsi kirjaimen tai erikoismerkin,joten palautetaan false:
                return false;
            }
        }

//Tarkistetaan vielä, että numero on yli nolla:
        return Double.parseDouble(syote)>= 0;
    }


   
    }

    



    
    
    
    
    

