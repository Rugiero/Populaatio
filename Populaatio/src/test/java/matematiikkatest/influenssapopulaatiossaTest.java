package matematiikkatest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class influenssapopulaatiossaTest {

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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void KokeillaanLaskeaEriArvoilla() {
        matematiikka.influenssapopulaatiossa test = new matematiikka.influenssapopulaatiossa();
        test.laske(50, 5, 0.01, 0.3);
        assertEquals("Tauti on endeeminen (syntyy epidemia). I-->50", test.TulostaRajaArvo());

        test.laske(10000, 1, 0.004, 0.7);
        assertEquals("Tauti on endeeminen (syntyy epidemia). I-->9825", test.TulostaRajaArvo());

        test.laske(0, 0, 0.004, 0.7);

        assertEquals("Ei sairastuneita alussa, tauti ei puhkea.", test.TulostaRajaArvo());

        test.laske(1000, 0, 0.004, 0.7);
        assertEquals("Ei sairastuneita alussa, tauti ei puhkea.", test.TulostaRajaArvo());
        
        
        

    }
}
