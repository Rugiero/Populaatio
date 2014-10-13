package pop_ohjelma.graafinenkayttoliittyma;

import java.util.Scanner;

/**
 * Tällä luokalla testataan syötteiden oikeellisuutta
 */
public class SyotteidenTestaus {

    Scanner lukija = new Scanner(System.in);

    /**
     * Metodi kokonaislukujen syöttämiseen:
     */
//    public boolean KokonaisluvunSyotto(String syote) {
//
//        /**
//         * Tyhjä syöte palauttaa false:
//         */
//        if (syote.isEmpty()) {
//            return false;
//        }
//        for (int i = 0; i < syote.length(); i++) {
//            char a = syote.charAt(i);
//            if (!Character.isDigit(a)) {
//                /**
//                 * syöte sisälsi kirjaimen tai erikoismerkin,joten palautetaan
//                 * false:
//                 */
//
//                return false;
//            }
//        }
//
//        /**
//         * Tarkistetaan vielä, että numero on yli nolla:
//         */
//        return Integer.parseInt(syote) >= 0;
//    }
//
//    /**
//     * Metodi, jonka avulla syötetään desimaalilukuja välillä 0-1:
//     *
//     * @param syote
//     * @return
//     */
//    public boolean DesimaalinSyottoValilla0Ja1(String syote) {
//
//        if (DesimaalinSyotto(syote) == false) {
//            return false;
//        }
//        return Double.parseDouble(syote) >= 0 && Double.parseDouble(syote) <= 1;
//    }

    /**
     * Metodi testaa että annettu syöte on luku. Syöte saa sisältää tasan yhden
     * pisteen '.'. Muuten syötteen tulee sisältää vain numeroita. Piste ei saa
     * olla viimeinen merkki eikä ensimmäinen merkki. Tyhjä syöte palauttaa
     * 'false'.
     *
     * @param syote String-muotoinen syöte
     * @return palauttaa true/false sen perusteella onko syöte oikea luku.
     */
    public Boolean DesimaalinSyotto(String syote) {
        if (syote.isEmpty()) {
            return false;
        }
        if (syote.charAt(0) == '.' || syote.charAt(syote.length() - 1) == '.') {
            return false;
        }
        boolean onkopistetta = false;

        for (int i = 0; i < syote.length(); i++) {
            char a = syote.charAt(i);
            if (a == '.') {
                if (onkopistetta == true) {
                    return false;
                } else {
                    onkopistetta = true;
                }
            }

            if (!Character.isDigit(a) && a != '.') {
                /**
                 * Syöte sisälsi kirjaimen tai erikoismerkin (lukuunottamatta
                 * '.'), joten palautetaan false:
                 *
                 */
                return false;
            }
        }

        /**
         * Tarkistetaan vielä, että numero on yli nolla:
         */
        return Double.parseDouble(syote) >= 0;

    }

}
