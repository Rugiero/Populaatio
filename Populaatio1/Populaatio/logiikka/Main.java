
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        String syote = lukija.nextLine();       
        System.out.println("Avataanko ohjelma \"Populaatio\"  joo/ei");
        switch (syote) {
            case "joo":
                break;
            case "ei":
                break;
            default:
                System.out.println("Syötä joo tai ei");
                break;
        }
        
 
        
        
        
    }

}
