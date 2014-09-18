import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PopulaatioTest {

    public PopulaatioTest() {
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
    public void TestataanVirheellisisaKokonaislukusyotteita() {
        Populaatiot.SyotteidenTestaus test = new Populaatiot.SyotteidenTestaus();
        assertFalse(test.KokonaisluvunSyotto("0"));
        assertFalse(test.KokonaisluvunSyotto("124124"));
        assertFalse(test.KokonaisluvunSyotto("-2300"));
        assertFalse(test.KokonaisluvunSyotto("100000"));
        assertFalse(test.KokonaisluvunSyotto("-1"));
        assertFalse(test.KokonaisluvunSyotto("0"));
        assertFalse(test.KokonaisluvunSyotto("1"));
        assertFalse(test.KokonaisluvunSyotto("-1234"));

    }

    @Test
    public void TestataanSyotteitaKirjaimillaJaErikoismerkeilla() {
        Populaatiot.SyotteidenTestaus test = new Populaatiot.SyotteidenTestaus();
        assertFalse(test.KokonaisluvunSyotto("-"));
        assertFalse(test.KokonaisluvunSyotto("a"));
        assertFalse(test.KokonaisluvunSyotto("b"));
        assertFalse(test.KokonaisluvunSyotto("19/"));
        assertFalse(test.KokonaisluvunSyotto("24+"));
        assertFalse(test.KokonaisluvunSyotto("+-/"));
        assertFalse(test.KokonaisluvunSyotto("."));
        assertFalse(test.KokonaisluvunSyotto(""));

    }

    @Test
    public void TestataanVirheellisillaDesimaaleilla() {
        Populaatiot.SyotteidenTestaus test = new Populaatiot.SyotteidenTestaus();
        assertFalse(test.DesimaalinSyotto("2"));
        assertFalse(test.DesimaalinSyotto("0"));
        assertFalse(test.DesimaalinSyotto("1"));
        assertFalse(test.DesimaalinSyotto("3234.3"));
        assertFalse(test.DesimaalinSyotto("2.334"));
        assertFalse(test.DesimaalinSyotto("1.1"));
        assertFalse(test.DesimaalinSyotto("-0.9"));
        assertFalse(test.DesimaalinSyotto("-32"));

    }

    @Test
    public void TestataanDesimaalisyotettaKirjaimillajaErikoismerkeilla() {
        Populaatiot.SyotteidenTestaus test = new Populaatiot.SyotteidenTestaus();
        assertFalse(test.DesimaalinSyotto("-"));
        assertFalse(test.DesimaalinSyotto("d"));
        assertFalse(test.DesimaalinSyotto("ff.dd"));
        assertFalse(test.DesimaalinSyotto("a.a"));
        assertFalse(test.DesimaalinSyotto("-="));
        assertFalse(test.DesimaalinSyotto(""));
        assertFalse(test.DesimaalinSyotto("O."));
        assertFalse(test.DesimaalinSyotto("f"));

    }

    @Test
    public void TestataanHyvaksyttaviaKokonaislukusyotteita() {
        Populaatiot.SyotteidenTestaus test = new Populaatiot.SyotteidenTestaus();
        assertTrue(test.KokonaisluvunSyotto("14"));
        assertTrue(test.KokonaisluvunSyotto("2"));
        assertTrue(test.KokonaisluvunSyotto("1000"));
        assertTrue(test.KokonaisluvunSyotto("3"));
        assertTrue(test.KokonaisluvunSyotto("999"));
        assertTrue(test.KokonaisluvunSyotto("25"));
        assertTrue(test.KokonaisluvunSyotto("63"));
        assertTrue(test.KokonaisluvunSyotto("666"));
        assertTrue(test.KokonaisluvunSyotto("10001332"));

    }

    @Test
    public void TestataanHyvaksyttavillaDesimaaleilla() {
        Populaatiot.SyotteidenTestaus test = new Populaatiot.SyotteidenTestaus();
        assertTrue(test.DesimaalinSyotto("0.01"));
        assertTrue(test.DesimaalinSyotto("0.999"));
        assertTrue(test.DesimaalinSyotto("0.5"));
        assertTrue(test.DesimaalinSyotto("0.74"));
        assertTrue(test.DesimaalinSyotto("0.000001"));
        assertTrue(test.DesimaalinSyotto("0.74"));
        assertTrue(test.DesimaalinSyotto("0.3"));

    }

}
