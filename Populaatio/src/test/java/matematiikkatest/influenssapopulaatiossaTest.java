package matematiikkatest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class influenssapopulaatiossaTest {

    matematiikka.Influenssapopulaatiossa test;

    public influenssapopulaatiossaTest() {

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.test = new matematiikka.Influenssapopulaatiossa();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void KokeillaanLaskeaEriArvoillaSIS() {

        test.laskeSIS(50, 5, 0.01, 0.3);
        assertEquals("Tauti on endeeminen (syntyy epidemia). I-->20", test.TulostaRajaArvoSIS());

        test.laskeSIS(10000, 1, 0.004, 0.7);
        assertEquals("Tauti on endeeminen (syntyy epidemia). I-->9825", test.TulostaRajaArvoSIS());

        test.laskeSIS(1, 1, 0.004, 0.7);
        assertEquals("I-->0, Tauti on ohimenevä", test.TulostaRajaArvoSIS());

        test.laskeSIS(5000, 1, 0.004, 0.7);
        assertEquals("Tauti on endeeminen (syntyy epidemia). I-->4825", test.TulostaRajaArvoSIS());

        test.laskeSIS(2, 1, 0.001, 0.7);
        assertEquals("I-->0, Tauti on ohimenevä", test.TulostaRajaArvoSIS());

        test.laskeSIS(0, 0, 0.004, 0.7);

        assertEquals("Ei sairastuneita alussa, tauti ei puhkea.", test.TulostaRajaArvoSIS());

        test.laskeSIS(1000, 0, 0.004, 0.7);
        assertEquals("Ei sairastuneita alussa, tauti ei puhkea.", test.TulostaRajaArvoSIS());

         test.laskeSIS(4, 4, 0.2, 0.2);
         assertEquals("Tauti on endeeminen (syntyy epidemia). I-->3", test.TulostaRajaArvoSIS());
        
    }

//    @Test
//
//    public void KokeillaanLaskeaEriArvoillaSIR() {
//
//        test.laskeSIR(50, 5, 0.007, 0.1);
//        assertEquals("Epidemiaa ei synny. ", test.TulostaRajaArvoSIR());
//
////           test.laskeSIS(1000, 1, 0.004, 0.7);
//    }

}
