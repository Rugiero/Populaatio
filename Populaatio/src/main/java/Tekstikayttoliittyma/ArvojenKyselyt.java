package Tekstikayttoliittyma;

import java.util.Scanner;

public class ArvojenKyselyt {

    private final Tekstikayttoliittyma.SyotteidenTestaus Syotteidentestaus = new Tekstikayttoliittyma.SyotteidenTestaus();
    private String syote;
    private final Scanner lukija = new Scanner(System.in);

    public int ArvojenKyselyKokonaisluvut(String stringi) {

        System.out.println(stringi);
        syote = lukija.nextLine();
        while (true) {
            if (Syotteidentestaus.KokonaisluvunSyotto(syote) == true) {
                return Integer.parseInt(syote);

            } else {
                System.out.println(stringi);
                syote = lukija.nextLine();
            }
        }
    }

    public double ArvojenKyselyDesimaalitValilla0Ja1(String stringi) {
        System.out.println(stringi);
        syote = lukija.nextLine();
        while (true) {
            if (Syotteidentestaus.DesimaalinSyottoValilla0Ja1(syote) == true) {
                return Double.parseDouble(syote);

            } else {
                System.out.println(stringi);
                syote = lukija.nextLine();
            }
        }
    }
      public double ArvojenKyselyDesimaalit(String stringi) {
        System.out.println(stringi);
        syote = lukija.nextLine();
        while (true) {
            if (Syotteidentestaus.DesimaalinSyotto(syote) == true) {
                return Double.parseDouble(syote);

            } else {
                System.out.println(stringi);
                syote = lukija.nextLine();
            }
        }
    }
    

}
