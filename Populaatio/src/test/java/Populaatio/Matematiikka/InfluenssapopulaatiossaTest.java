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
//Haluamme pituutta 3 olevan arraylistin

    @Test
    public void KokeillaanLaskeaEriArvoillaSIS() {

        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIS(50, 5, 0.007, 0.1, 200).size());
        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIS(1, 0, 0.01, 0.01, 0).size());
        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIS(1, 0, 0.99, 0.99, 400).size());
        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIS(5000, 4999, 0.5, 0.5, 2).size());
        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIS(0, 0, 0, 0, 0).size());

    }
//Halueamme palautukseen pituutta 3 olevan arraylistin:

    @Test
    public void KokeillaanLaskeaEriArvoillaSIR() {

        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIR(50, 5, 0.007, 0.1, 0).size());
        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIR(50, 5, 0.007, 0.1, 50).size());
        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIR(1, 0, 0.01, 0.001, 200).size());
        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIR(1, 0, 0.99, 0.99, 100).size());
        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIR(5000, 4999, 0.5, 0.5, 1).size());
        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIR(0, 0, 0, 0, 0).size());

    }

    @Test
    public void KokeillaanEtteipalautusNullSIR() {
        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIR(50, 5, 0.007, 0.1, 0) == null);
        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIR(50, 5, 0.007, 0.1, 200) == null);
        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIR(1, 0, 0.01, 0.001, 100) == null);
        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIR(1, 0, 0.99, 0.99, 0.1) == null);
        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIR(5000, 4999, 0.5, 0.5, 20) == null);
        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIR(0, 0, 0, 0, 0).size());

    }

    @Test
    public void TestataanetteiPalautusnullSIS() {

        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIS(50, 5, 0.007, 0.1, 0) == null);

        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIS(1, 0, 0.01, 0.001, 100) == null);
        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIS(1, 0, 0.99, 0.99, 1000) == null);
        assertFalse(new Matematiikka.Influenssapopulaatiossa().laskeSIS(5000, 4999, 0.5, 0.5, 1) == null);
        assertEquals(3, new Matematiikka.Influenssapopulaatiossa().laskeSIS(0, 0, 0, 0, 0).size());

    }

    @Test
    public void TestataanPalauttaaSuurimmanSIS() {

        Influenssapopulaatiossa laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIS(50, 5, 0.007, 0.1, 200);
        assertEquals(35.714, laskin.PalautaSairaitaMax(), 0.1);

        laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIS(1, 0, 0.01, 0.001, 200);
        assertEquals(0, laskin.PalautaSairaitaMax(), 0.1);

        laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIS(1, 0, 0.99, 0.99, 200);
        assertEquals(0, laskin.PalautaSairaitaMax(), 0.1);

        laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIS(5000, 4999, 0.5, 0.5, 200);
        assertEquals(4999, laskin.PalautaSairaitaMax(), 0.1);

    }

    @Test
    public void TestataanRajaArvoaSIS() {
        Influenssapopulaatiossa laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIS(50, 5, 0.007, 0.1, 200);
        assertEquals(35.714, laskin.TulostaRajaArvoSIS(), 0.1);
        laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIS(1, 0, 0.01, 0.001, 200);
        assertEquals(0, laskin.TulostaRajaArvoSIS(), 0.1);
        laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIS(1, 0, 0.99, 0.99, 200);
        assertEquals(0, laskin.TulostaRajaArvoSIS(), 0.1);
        laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIS(5000, 4999, 0.5, 0.5, 200);
        assertEquals(4999, laskin.PalautaSairaitaMax(), 0.1);
        laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIS(0, 0, 0, 0, 0);
        assertEquals(0, laskin.TulostaRajaArvoSIR(), 0.1);

    }

    @Test
    public void TestataanPalauttaaSuurimmanSIR() {
//Testataan että metodi palauttaa asianmukaisen arvon pyöristettynä alaspäin kokonaislukuun.

        Influenssapopulaatiossa laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIR(50, 5, 0.007, 0.1, 200);
        assertEquals(19.3227, laskin.PalautaSairaitaMax(), 0.1);
        laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIR(1, 0, 0.01, 0.001, 200);
        assertEquals(0, laskin.PalautaSairaitaMax(), 0.1);
        laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIR(1, 0, 0.99, 0.99, 200);
        assertEquals(0, laskin.PalautaSairaitaMax(), 0.1);
        laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIR(500, 1, 0.001, 0.1, 200);
        assertEquals(239.256, laskin.PalautaSairaitaMax(), 0.1);
        laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIR(50, 1, 0.99, 0, 200);
        assertEquals(50, laskin.TulostaRajaArvoSIS(), 0.1);

    }

    @Test
    public void TestataanRajaArvoaSIR() {
        Influenssapopulaatiossa laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIR(50, 5, 0.007, 0.1, 200);
        assertEquals(48.4895, laskin.TulostaRajaArvoSIR(), 0.1);
        laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIR(1, 0, 0.01, 0.001, 200);
        assertEquals(0, laskin.TulostaRajaArvoSIR(), 0.1);
        laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIR(1, 0, 0.99, 0.99, 200);
        assertEquals(0, laskin.TulostaRajaArvoSIR(), 0.1);
        laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIR(50, 1, 0, 0.99, 200);
        assertEquals(1, laskin.TulostaRajaArvoSIR(), 0.1);
        laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIR(500, 1, 0.001, 0.1, 200);
        assertEquals(496.5, laskin.TulostaRajaArvoSIR(), 0.1);
        laskin = new Matematiikka.Influenssapopulaatiossa();
        laskin.laskeSIR(0, 0, 0, 0, 0);
        assertEquals(0, laskin.TulostaRajaArvoSIR(), 0.1);

    }

}
