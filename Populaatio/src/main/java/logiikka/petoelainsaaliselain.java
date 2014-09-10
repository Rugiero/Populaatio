package logiikka;

import java.util.Scanner;

public class petoelainsaaliselain {

    private final Scanner lukija = new Scanner(System.in);

    private final matematiikka.petoelainsaaliselain petoelainsaaliselainmatematiikka = new matematiikka.petoelainsaaliselain();
    private int populaationkoko;
    private double petojenlisaantymistahti;
    private double saalistenlisaantymistahti;
    private double petojentehokkuus;

    public void paanakyma() {
        {

            //Ensin kysytään populaation kokoa:
            System.out.println("Anna populaation koko (2-1000)");

            while (true) {

                String syote = lukija.nextLine();
                //jos syote on numero, pitää vielä tarkistaa että se kuuluu annetulle välille:
                if (TarkistaOnkoNumero(syote) && Integer.parseInt(syote) >= 2 && Integer.parseInt(syote) <= 1000) {
                    //Kaikki ok ja asetetaan populaation syöte populaation arvoksi:

                    this.populaationkoko = Integer.parseInt(syote);
                    break;

                } else {
                    //Muuten herjataan:
                    System.out.println("Anna numero väliltä 2-1000!");
                }

            }

            //Sitten lisääntymistahtia:
            System.out.println("Anna petojen lisääntymistahti desimaalina väliltä 0.0-1.0");
            DesimaalinSyotto(lukija.nextLine(), this.petojenlisaantymistahti);
            System.out.println("Anna saalisten lisääntymistahti desimaalina väliltä 0.0-1.0");
            DesimaalinSyotto(lukija.nextLine(), this.saalistenlisaantymistahti);

            //Sitten petojen 'tehokkuutta':
               System.out.println("Anna petojen tehokkuus desimaalina väliltä 0.0-1.0");
            DesimaalinSyotto(lukija.nextLine(), this.petojentehokkuus);
            
            
            //Tässä kohtaa suoritetaan paketin 'matematiikka' luokka 'petoelainsaaliselain'

        }

    }

    public void DesimaalinSyotto(String syote, double desimaali) {

        while (true) {
            //jos syöte on halutulla välillä:
            if (TarkistaOnkovalillaNollaJaYksi(syote)) {

                //Asetetaan syöte leviämistodennäköisyyden arvoksi:
                desimaali = Double.parseDouble(syote);
                break;

            } else {
                //muuten herjataan
                System.out.println("Anna luku desimaaliluku väliltä 0.0-1.0!");
                syote = lukija.nextLine();
            }

        }

    }

    public boolean TarkistaOnkoNumero(String syote) {
        for (int i = 0; i < syote.length(); i++) {
            char a = syote.charAt(i);
            if (!Character.isDigit(a)) {
                //Syöte sisälsi kirjaimen tai erikoismerkin,joten palautetaan false:
                return false;
            }
        }
        return true;
    }

    public boolean TarkistaOnkovalillaNollaJaYksi(String syote) {
        //ensimmäisen merkin tulee olla nolla: 
        if (syote.charAt(0) != '0') {
            return false;
        }
        //toisen merkin tulee olla piste:
        if (syote.charAt(1) != '.') {
            return false;
        }

        for (int i = 2; i < syote.length(); i++) {
            char a = syote.charAt(i);

            if (!Character.isDigit(a)) {
                //Syöte sisälsi kirjaimen tai erikoismerkin,joten palautetaan false:
                return false;
            }
        }
        //Muuten kaikki ok, ja palautetaan true:
        return true;

    }
}
