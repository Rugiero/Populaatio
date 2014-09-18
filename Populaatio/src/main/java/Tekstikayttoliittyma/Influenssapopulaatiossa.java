package Tekstikayttoliittyma;

import java.util.Scanner;

public class Influenssapopulaatiossa {

    private final Scanner lukija = new Scanner(System.in);
//    N:Populaation koko, I: Sairastuneita populaatiossa aluksi, B=tarttumisintesiteetti, a=parantumistodennakoisyys
    private String syote;
    private int N;
    private int I;
    private double B;
    private double a;
    private Populaatiot.PopulaatioYksiLaji Populaatio;
    private Populaatiot.SyotteidenTestaus Syotteidentestaus = new Populaatiot.SyotteidenTestaus();

    public void paanakyma() {
        //Luodaan ensin populaatiollemme olio:

        //Ensin kysytään populaation kokoa:
        System.out.println("Anna populaation koko:");
        syote = lukija.nextLine();
        while (true) {
            if (Syotteidentestaus.KokonaisluvunSyotto(syote) == true) {
                this.N = Integer.parseInt(syote);
                break;
            } else {
                System.out.println("Anna populaation koko:");
                syote = lukija.nextLine();
            }
        }

        //Sitten kysytään leviämistodennäköisyyttä:
        System.out.println("Anna sairastuneiden määrä aluksi");
        syote = lukija.nextLine();
        while (true) {
            if (Syotteidentestaus.KokonaisluvunSyotto(syote) == true) {
                this.I = Integer.parseInt(syote);
                break;
            } else {
                System.out.println("Anna airastuneiden määrä aluksi:");
                syote = lukija.nextLine();
            }
        }
        //Lisääntymistahtia:
        System.out.println("Anna tarttumisintesiteetti");
        syote = lukija.nextLine();
        while (true) {
            if (Syotteidentestaus.DesimaalinSyotto(syote) == true) {
                this.B = Double.parseDouble(syote);
                break;
            } else {
                System.out.println("Anna tarttumisintesiteetti:");
                syote = lukija.nextLine();
            }
        }
        //Parantumistodennakoisyytta:
        System.out.println("Anna parantumistodennakoisyys (per aikayksikko):");
        syote = lukija.nextLine();
        while (true) {
            if (Syotteidentestaus.DesimaalinSyotto(syote) == true) {
                this.a = Double.parseDouble(syote);
                break;
            } else {
                System.out.println("Anna parantumistodennakoisyys (per aikayksikko):");
                syote = lukija.nextLine();
            }
        }

        this.Populaatio = new Populaatiot.PopulaatioYksiLaji(N, I, B, a);

        System.out.println("Lasketaan arvot:");

        this.Populaatio.laskeKehitys();

    }

}
