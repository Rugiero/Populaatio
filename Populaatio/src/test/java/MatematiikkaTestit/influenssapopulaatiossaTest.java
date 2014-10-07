package MatematiikkaTestit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class influenssapopulaatiossaTest {

    Matematiikka.Influenssapopulaatiossa test;

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
        this.test = new Matematiikka.Influenssapopulaatiossa();
    }

    @After
    public void tearDown() {
    }
//Haluamme pituutta 2 olevan arraylistin

    @Test
    public void KokeillaanLaskeaEriArvoillaSIS() {
        assertEquals(2, test.laskeSIS(50, 5, 0.007, 0.1).size());
        assertEquals(2, test.laskeSIS(1, 0, 0.01, 0.01).size());
        assertEquals(2, test.laskeSIS(1, 0, 0.99, 0.99).size());
        assertEquals(2, test.laskeSIS(5000, 4999, 0.5, 0.5).size());

    }
//Halueamme palautukseen pituutta 3 olevan arraylistin:

    @Test
    public void KokeillaanLaskeaEriArvoillaSIR() {

        assertEquals(3, test.laskeSIR(50, 5, 0.007, 0.1).size());
        assertEquals(3, test.laskeSIR(50, 5, 0.007, 0.1).size());
        assertEquals(3, test.laskeSIR(1, 0, 0.01, 0.001).size());
        assertEquals(3, test.laskeSIR(1, 0, 0.99, 0.99).size());
        assertEquals(3, test.laskeSIR(5000, 4999, 0.5, 0.5).size());

    }

}
