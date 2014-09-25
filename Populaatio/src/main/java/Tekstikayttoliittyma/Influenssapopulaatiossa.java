package Tekstikayttoliittyma;

import java.util.Scanner;

public class Influenssapopulaatiossa {

    /**
     * N:Populaation koko, I: Sairastuneita populaatiossa aluksi,
     * B=tarttumisintesiteetti, a=parantumistodennakoisyys
     *
     */
    private final Scanner lukija = new Scanner(System.in);

    private String syote;
    private int N;
    private int I;
    private double B;
    private double a;
    private Populaatiot.PopulaatioYksiLaji Populaatio;
    private final Populaatiot.SyotteidenTestaus Syotteidentestaus = new Populaatiot.SyotteidenTestaus();

    public void paanakyma() {

        /**
         * Ensin kysytään populaation kokoa:
         */
        this.N = ArvojenKyselyKokonaisluvut("Populaation koko: ");

        /**
         * Sitten kysytään sairastuneiden määrää aluksi. Tarkistetaan myös että
         * N>=I:
         */
        while (true) {
            this.I = ArvojenKyselyKokonaisluvut("Sairastuneiden määrä aluksi");
            if (this.I <= this.N) {
                break;
            }
        }

        /**
         * Tarttumisintesiteettiä:
         */
        this.B = ArvojenKyselyDesimaalit("Tarttumisintesiteetti välillä 0-1 (Arvolle on tietty biologinen määritelmä. Saa olla hyvin pieni varsinkin isoilla populaatioilla");
        //Parantumistodennakoisyytta:
        this.a = ArvojenKyselyDesimaalit("Parantumistodennakoisyys (per aikayksikko): ");

        this.Populaatio = new Populaatiot.PopulaatioYksiLaji(N, I, B, a);

        /**
         * Kysytään vielä kummassa mallissa halutaan laskea:
         */
        System.out.println("Valitse malli immuniteetilla tai ilman.");
        OUTER:
        while (true) {
            System.out.println("SIR/SIS");
            syote = lukija.nextLine();
            switch (syote) {
                case "SIR":

                    this.Populaatio.laskeKehitysSIRmalli();
                    break OUTER;
                case "SIS":

                    this.Populaatio.laskeKehitysSISmalli();
                    break OUTER;
            }
        }

    }

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
