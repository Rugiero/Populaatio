package Tekstikayttoliittyma;

import Graafinenkayttoliittyma.PiirraFaasikayra;
import Graafinenkayttoliittyma.PiirraKayra;
import java.util.ArrayList;
import java.util.Scanner;

public class InfluenssaPopulaatiossa {

    /**
     * N:Populaation koko, I: Sairastuneita populaatiossa aluksi,
     * B=tarttumisintesiteetti, a=parantumistodennakoisyys
     *
     */
    private final Scanner lukija = new Scanner(System.in);

    private ArrayList<double[]> tulokset;
    private String syote;
    private int N;
    private int I;
    private double B;
    private double a;
    private Populaatiot.PopulaatioYksiLaji Populaatio;
    private final Graafinenkayttoliittyma.SyotteidenTestaus Syotteidentestaus = new Graafinenkayttoliittyma.SyotteidenTestaus();
    private final ArvojenKyselyt arvojenkysely = new ArvojenKyselyt();

    public void paanakyma() {

        /**
         * Ensin kysytään populaation kokoa. Tarkistetaan myös N != 0
         */
        while (true) {
            this.N = arvojenkysely.ArvojenKyselyKokonaisluvut("Populaation koko: ");
            if (this.N != 0) {
                break;
            }
        }
        /**
         * Sitten kysytään sairastuneiden määrää aluksi. Tarkistetaan myös että
         * N>=I ja N!= 0.
         */
        while (true) {
            this.I = arvojenkysely.ArvojenKyselyKokonaisluvut("Sairastuneiden määrä aluksi");
            if (this.I <= this.N) {
                break;
            }
        }

        /**
         * Tarttumisintesiteettiä:
         */
        this.B = arvojenkysely.ArvojenKyselyDesimaalitValilla0Ja1("Tarttumisintesiteetti välillä 0-1 (Arvolle on tietty biologinen määritelmä. Saa olla hyvin pieni varsinkin isoilla populaatioilla");
        /**
         * Parantumistodennakoisyytta. Tämäkään ei saa olla 0, nimittäin
         * numeerinen laskumenetelmä ei toimi kyseisessä tilanteessa. Muutenkin
         * tapaus on epämielenkiintoinen (tauti leviää räjähdysmäisesti).
         */

        while (true) {

            this.a = arvojenkysely.ArvojenKyselyDesimaalitValilla0Ja1("Parantumistodennakoisyys (per aikayksikko): ");
            if (this.a != 0) {
                break;
            }
        }
        this.Populaatio = new Populaatiot.PopulaatioYksiLaji(N, I, B, a);

        /**
         * Kysytään kummassa mallissa halutaan laskea, ja piirretään käyrä.
         */
        System.out.println("Valitse malli immuniteetilla tai ilman.");

        OUTER:
        while (true) {
            System.out.println("SIR/SIS");
            syote = lukija.nextLine();
            switch (syote) {
                case "SIR":
                    this.tulokset = this.Populaatio.laskeKehitysSIRmalli();

                    PiirraKayra kayra = new PiirraKayra("Sairastuneet ja alttiit", "lkm", "t", tulokset);
                    kayra.Piirretaankayra();
                    kayra.setVisible(true);

                    PiirraFaasikayra kayra1 = new PiirraFaasikayra("Sairastuneet ja alttiit faasidiagrammi", "Sairastuneet", "Alttiit", tulokset);
                    kayra1.PiirretaankayraFaasi();
                    kayra1.setVisible(true);

                    break OUTER;
                case "SIS":

                    this.tulokset = this.Populaatio.laskeKehitysSISmalli();

                    kayra = new PiirraKayra("Sairastuneiden määrä", "lkm", "t", tulokset);
                    kayra.Piirretaankayra();
                    kayra.setVisible(true);

                    break OUTER;
            }
        }

    }
}
