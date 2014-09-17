


//Luokalla konstruoidaan olio, mikä sisältää tiedot yhden lajin populaatiossa. Tarkoitettu 'Influenssapop-
//ulaatiossa tilanteeseen.
package Populaatiot;

  
public class PopulaatioYksiLaji {
    
    
    private int populaatio;
    private double lisaantymistahti;
    private double tarttuvuus;
    private double tiheys;
    


    
 public PopulaatioYksiLaji(int koko1,double lisaantymistahti1, double tarttuvuus1, double tiheys1 ) {
       this.populaatio=koko1;
       this.lisaantymistahti = lisaantymistahti1;
       this.tarttuvuus = tarttuvuus1;
       this.tiheys = tiheys1;
        
    }
 
 
    public void AsetaPopulaatio(int a) {
        this.populaatio= a;

    }

    public void AsetaTarttuvuus(double a) {
        this.tarttuvuus = a;

    }

    public void AsetaLisaantymistahti(double a) {
        this.lisaantymistahti = a;

    }

    public void Asetatiheys(double a) {
        this.tiheys = a;

    }

    
    
    
    
    
    
    

   
     @Override
    public String toString() {
        return "Koko: "+ populaatio + "Lisääntymistahti: " + lisaantymistahti + "Tarttuvuus: " + tarttuvuus +  "Tiheys: " + tiheys;
    }
}


