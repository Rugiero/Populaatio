package pop_ohjelma.graafinenkayttoliittyma;

import java.util.Scanner;

/**
 * TLuokalla testataan että syötteet ovat oikeita lukuja.
 *
 * @author iangervu
 */
public class SyotteidenTestaus {

    Scanner lukija = new Scanner(System.in);

    /**
     * Testaa että annettu syöte on luku (desimaali tai kokonais).
     *
     * @param syote string muotoinen syöte
     * @return palauttaa true jos syöte oli luku
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

                //  Syöte sisälsi kirjaimen tai erikoismerkin (lukuunottamatta
                //  '.'), joten palautetaan false:
                return false;
            }
        }

        //Kaikki ok, palautetaan true:
        return true;

    }

}
