package Populaatio.Matematiikka;

import Matematiikka.Influenssapopulaatiossa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InfluenssapopulaatiossaTest {

    Matematiikka.Influenssapopulaatiossa test;

    public InfluenssapopulaatiossaTest() {

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

        assertEquals(2, new Matematiikka.Influenssapopulaatiossa().laskeSIS(50, 5, 0.007, 0.1).size());
        assertEquals(2, new Matematiikka.Influenssapopulaatiossa().laskeSIS(1, 0, 0.01, 0.01).size());
        assertEquals(2, new Matematiikka.Influenssapopulaatiossa().laskeSIS(1, 0, 0.99, 0.99).size());
        assertEquals(2, new Matematiikka.Influenssapopulaatiossa().laskeSIS(5000, 4999, 0.5, 0.5).size());

    }
//Halueamme palautukseen pituutta 3 olevan arraylistin:

    @Test
    public void KokeillaanLaskeaEriArvoillaSIR() {

        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIR(50, 5, 0.007, 0.1).size());
        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIR(50, 5, 0.007, 0.1).size());
        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIR(1, 0, 0.01, 0.001).size());
        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIR(1, 0, 0.99, 0.99).size());
        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIR(5000, 4999, 0.5, 0.5).size());

    }

    @Test
    public void KokeillaanEtteipalautusNullSIR() {
        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIR(50, 5, 0.007, 0.1) == null);
        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIR(50, 5, 0.007, 0.1) == null);
        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIR(1, 0, 0.01, 0.001) == null);
        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIR(1, 0, 0.99, 0.99) == null);
        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIR(5000, 4999, 0.5, 0.5) == null);

    }

    @Test
    public void TestataanetteiPalautusnullSIS() {

        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIS(50, 5, 0.007, 0.1) == null);

        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIS(1, 0, 0.01, 0.001) == null);
        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIS(1, 0, 0.99, 0.99) == null);
        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIS(5000, 4999, 0.5, 0.5) == null);

    }

    @Test
    public void TestataanPalauttaaSuurimmanSIS() {
//Testataan että metodi palauttaa asianmukaisen arvon pyöristettynä alaspäin kokonaislukuun.

        Influenssapopulaatiossa laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIS(50, 5, 0.007, 0.1);
        assertEquals((int) 35.714, (int) laskin.PalautaSairaitaMax());

        laskin.laskeSIS(1, 0, 0.01, 0.001);
        assertEquals((int) 0, (int) laskin.PalautaSairaitaMax());

        laskin.laskeSIS(1, 0, 0.99, 0.99);
        assertEquals((int) 0, (int) laskin.PalautaSairaitaMax());

        laskin.laskeSIS(5000, 4999, 0.5, 0.5);
        assertEquals((int) 4999, (int) laskin.PalautaSairaitaMax());
        
       

    }

    @Test
    public void TestataanRajaArvoaSIS() {
        Influenssapopulaatiossa laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIS(50, 5, 0.007, 0.1);
        assertEquals((int) 36.0, (int) laskin.TulostaRajaArvoSIS());

        laskin.laskeSIS(1, 0, 0.01, 0.001);
        assertEquals((int) 0, (int) laskin.TulostaRajaArvoSIS());

        laskin.laskeSIS(1, 0, 0.99, 0.99);
        assertEquals((int) 0, (int) laskin.TulostaRajaArvoSIS());

        laskin.laskeSIS(5000, 4999, 0.5, 0.5);
        assertEquals((int) 4999, (int) laskin.PalautaSairaitaMax());
        

    }

    @Test
    public void TestataanPalauttaaSuurimmanSIR() {
//Testataan että metodi palauttaa asianmukaisen arvon pyöristettynä alaspäin kokonaislukuun.

        Influenssapopulaatiossa laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIR(50, 5, 0.007, 0.1);
        assertEquals((int) 19.49, (int) laskin.PalautaSairaitaMax());

        laskin.laskeSIR(1, 0, 0.01, 0.001);
        assertEquals((int) 0, (int) laskin.PalautaSairaitaMax());

        laskin.laskeSIR(1, 0, 0.99, 0.99);
        assertEquals((int) 0, (int) laskin.PalautaSairaitaMax());

        laskin.laskeSIR(500, 1, 0.001, 0.1);
        assertEquals((int) 242.036, (int) laskin.PalautaSairaitaMax());

        laskin.laskeSIR(50, 1, 0, 0.99);
        assertEquals((int) 1, (int) laskin.TulostaRajaArvoSIS());

    }

    @Test
    public void TestataanRajaArvoaSIR() {
        Influenssapopulaatiossa laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIR(50, 5, 0.007, 0.1);
        assertEquals((int) 48.29, (int) laskin.TulostaRajaArvoSIS());

        laskin.laskeSIR(1, 0, 0.01, 0.001);
        assertEquals((int) 0, (int) laskin.TulostaRajaArvoSIS());

        laskin.laskeSIR(1, 0, 0.99, 0.99);
        assertEquals((int) 0, (int) laskin.TulostaRajaArvoSIS());

        laskin.laskeSIR(50, 1, 0, 0.99);
        assertEquals((int) 1, (int) laskin.TulostaRajaArvoSIS());

        laskin.laskeSIR(500, 1, 0.001, 0.1);
        assertEquals((int) 500, (int) laskin.PalautaSairaitaMax());

    }

}
