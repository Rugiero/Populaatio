package pop_ohjelma.matematiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pop_ohjelma.matematiikka.Influenssapopulaatiossa;
import static org.junit.Assert.*;

public class InfluenssapopulaatiossaTest {

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

    }

    @After
    public void tearDown() {
    }
//Haluamme pituutta 3 olevan arraylistin

    @Test
    public void KokeillaanLaskeaEriArvoillaSIS() {

        ArrayList<double[]> tulokset = new Influenssapopulaatiossa().laskeSIS(50, 5, 0.007, 0.1, 0);
        assertEquals(3, tulokset.size());

        tulokset = new Influenssapopulaatiossa().laskeSIS(50, 5, 0.007, 0.1, 50);
        assertEquals(3, tulokset.size());

        tulokset = new Influenssapopulaatiossa().laskeSIS(1, 0, 0.01, 0.001, 200);
        assertEquals(3, tulokset.size());

        tulokset = new Influenssapopulaatiossa().laskeSIS(1, 0, 0.99, 0.99, 100);
        assertEquals(3, tulokset.size());

        tulokset = new Influenssapopulaatiossa().laskeSIS(5000, 4999, 0.5, 0.5, 1);
        assertEquals(3, tulokset.size());

        tulokset = new Influenssapopulaatiossa().laskeSIS(0, 0, 0, 0, 0);
        assertEquals(3, tulokset.size());

    }
//Halueamme palautukseen pituutta 3 olevan arraylistin:

    @Test
    public void KokeillaanLaskeaEriArvoillaSIR() {

        ArrayList<double[]> tulokset = new Influenssapopulaatiossa().laskeSIR(50, 5, 0.007, 0.1, 0);
        assertEquals(3, tulokset.size());

        tulokset = new Influenssapopulaatiossa().laskeSIR(50, 5, 0.007, 0.1, 50);
        assertEquals(3, tulokset.size());

        tulokset = new Influenssapopulaatiossa().laskeSIR(1, 0, 0.01, 0.001, 200);
        assertEquals(3, tulokset.size());

        tulokset = new Influenssapopulaatiossa().laskeSIR(1, 0, 0.99, 0.99, 100);
        assertEquals(3, tulokset.size());

        tulokset = new Influenssapopulaatiossa().laskeSIR(5000, 4999, 0.5, 0.5, 1);
        assertEquals(3, tulokset.size());

        tulokset = new Influenssapopulaatiossa().laskeSIR(0, 0, 0, 0, 0);
        assertEquals(3, tulokset.size());

    }

    @Test
    public void KokeillaanEtteipalautusNullSIR() {
        ArrayList<double[]> tulokset = new Influenssapopulaatiossa().laskeSIR(50, 5, 0.007, 0.1, 0);
        assertFalse(tulokset == null);
        tulokset = new Influenssapopulaatiossa().laskeSIR(1, 0, 0.01, 0.001, 100);
        assertFalse(tulokset == null);
        tulokset = new Influenssapopulaatiossa().laskeSIR(1, 0, 0.99, 0.99, 1000);
        assertFalse(tulokset == null);
        tulokset = new Influenssapopulaatiossa().laskeSIR(5000, 4999, 0.5, 0.5, 1);
        assertFalse(tulokset == null);
        tulokset = new Influenssapopulaatiossa().laskeSIR(0, 0, 0, 0, 0);
        assertFalse(tulokset == null);

    }

    @Test
    public void TestataanetteiPalautusnullSIS() {

        ArrayList<double[]> tulokset = new Influenssapopulaatiossa().laskeSIS(50, 5, 0.007, 0.1, 0);
        assertFalse(tulokset == null);
        tulokset = new Influenssapopulaatiossa().laskeSIS(1, 0, 0.01, 0.001, 100);
        assertFalse(tulokset == null);
        tulokset = new Influenssapopulaatiossa().laskeSIS(1, 0, 0.99, 0.99, 1000);
        assertFalse(tulokset == null);
        tulokset = new Influenssapopulaatiossa().laskeSIS(5000, 4999, 0.5, 0.5, 1);
        assertFalse(tulokset == null);
        tulokset = new Influenssapopulaatiossa().laskeSIS(0, 0, 0, 0, 0);
        assertFalse(tulokset == null);

    }

    @Test
    public void TestataanPalauttaaSuurimmanSIS() {

        Influenssapopulaatiossa laskin = new Influenssapopulaatiossa();
        laskin.laskeSIS(50, 5, 0.007, 0.1, 200);
        assertEquals(35.714, laskin.PalautaSairaitaMax(), 0.1);

        laskin = new Influenssapopulaatiossa();
        laskin.laskeSIS(1, 0, 0.01, 0.001, 200);
        assertEquals(0, laskin.PalautaSairaitaMax(), 0.1);

        laskin = new Influenssapopulaatiossa();
        laskin.laskeSIS(1, 0, 0.99, 0.99, 200);
        assertEquals(0, laskin.PalautaSairaitaMax(), 0.1);

        laskin = new Influenssapopulaatiossa();
        laskin.laskeSIS(5000, 4999, 0.5, 0.5, 200);
        assertEquals(4999, laskin.PalautaSairaitaMax(), 0.1);

    }

    @Test
    public void TestataanRajaArvoaSIS() {
        Influenssapopulaatiossa laskin = new Influenssapopulaatiossa();
        laskin.laskeSIS(50, 5, 0.007, 0.1, 200);
        assertEquals(35.714, laskin.TulostaRajaArvoSIS(), 0.1);
        laskin = new Influenssapopulaatiossa();
        laskin.laskeSIS(1, 0, 0.01, 0.001, 200);
        assertEquals(0, laskin.TulostaRajaArvoSIS(), 0.1);
        laskin = new Influenssapopulaatiossa();
        laskin.laskeSIS(1, 0, 0.99, 0.99, 200);
        assertEquals(0, laskin.TulostaRajaArvoSIS(), 0.1);
        laskin = new Influenssapopulaatiossa();
        laskin.laskeSIS(5000, 4999, 0.5, 0.5, 200);
        assertEquals(4999, laskin.PalautaSairaitaMax(), 0.1);
        laskin = new Influenssapopulaatiossa();
        laskin.laskeSIS(0, 0, 0, 0, 0);
        assertEquals(0, laskin.TulostaRajaArvoSIR(), 0.1);

    }

    @Test
    public void TestataanPalauttaaSuurimmanSIR() {
//Testataan että metodi palauttaa asianmukaisen arvon pyöristettynä alaspäin kokonaislukuun.

        Influenssapopulaatiossa laskin = new Influenssapopulaatiossa();
        laskin.laskeSIR(50, 5, 0.007, 0.1, 200);
        assertEquals(19.3227, laskin.PalautaSairaitaMax(), 0.1);
        laskin = new Influenssapopulaatiossa();
        laskin.laskeSIR(1, 0, 0.01, 0.001, 200);
        assertEquals(0, laskin.PalautaSairaitaMax(), 0.1);
        laskin = new Influenssapopulaatiossa();
        laskin.laskeSIR(1, 0, 0.99, 0.99, 200);
        assertEquals(0, laskin.PalautaSairaitaMax(), 0.1);
        laskin = new Influenssapopulaatiossa();
        laskin.laskeSIR(500, 1, 0.001, 0.1, 200);
        assertEquals(239.256, laskin.PalautaSairaitaMax(), 0.1);
        laskin = new Influenssapopulaatiossa();
        laskin.laskeSIR(50, 1, 0.99, 0, 200);
        assertEquals(50, laskin.TulostaRajaArvoSIS(), 0.1);

    }

    @Test
    public void TestataanRajaArvoaSIR() {
        Influenssapopulaatiossa laskin = new Influenssapopulaatiossa();
        laskin.laskeSIR(50, 5, 0.007, 0.1, 200);
        assertEquals(48.4895, laskin.TulostaRajaArvoSIR(), 0.1);
        laskin = new Influenssapopulaatiossa();
        laskin.laskeSIR(1, 0, 0.01, 0.001, 200);
        assertEquals(0, laskin.TulostaRajaArvoSIR(), 0.1);
        laskin = new Influenssapopulaatiossa();
        laskin.laskeSIR(1, 0, 0.99, 0.99, 200);
        assertEquals(0, laskin.TulostaRajaArvoSIR(), 0.1);
        laskin = new Influenssapopulaatiossa();
        laskin.laskeSIR(50, 1, 0, 0.99, 200);
        assertEquals(1, laskin.TulostaRajaArvoSIR(), 0.1);
        laskin = new Influenssapopulaatiossa();
        laskin.laskeSIR(500, 1, 0.001, 0.1, 200);
        assertEquals(496.5, laskin.TulostaRajaArvoSIR(), 0.1);
        laskin = new Influenssapopulaatiossa();
        laskin.laskeSIR(0, 0, 0, 0, 0);
        assertEquals(0, laskin.TulostaRajaArvoSIR(), 0.1);

    }

}
