
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
        assertFalse(test.TarkistaOnkoNumeroOikeallaValilla("0"));
        assertFalse(test.TarkistaOnkoNumeroOikeallaValilla("124124"));
        assertFalse(test.TarkistaOnkoNumeroOikeallaValilla("-2300"));
        assertFalse(test.TarkistaOnkoNumeroOikeallaValilla("10000000000000"));
        assertFalse(test.TarkistaOnkoNumeroOikeallaValilla("-1"));
        assertFalse(test.TarkistaOnkoNumeroOikeallaValilla("0"));
        assertFalse(test.TarkistaOnkoNumeroOikeallaValilla("1"));
        assertFalse(test.TarkistaOnkoNumeroOikeallaValilla("-1234"));

    }

    public void TestataanInfluenssaSyotteitaKirjaimillaJaErikoismerkeilla() {
        Populaatiot.SyotteidenTestaus test = new Populaatiot.SyotteidenTestaus();
        assertFalse(test.TarkistaOnkoNumeroOikeallaValilla("-"));
        assertFalse(test.TarkistaOnkoNumeroOikeallaValilla("a"));
        assertFalse(test.TarkistaOnkoNumeroOikeallaValilla("b"));
        assertFalse(test.TarkistaOnkoNumeroOikeallaValilla("19/"));
        assertFalse(test.TarkistaOnkoNumeroOikeallaValilla("24+"));
        assertFalse(test.TarkistaOnkoNumeroOikeallaValilla("+-/"));
        assertFalse(test.TarkistaOnkoNumeroOikeallaValilla("."));
        assertFalse(test.TarkistaOnkoNumeroOikeallaValilla(""));

    }

    public void TestataanInfluenssaVirheellisillaDesimaaleilla() {
        Populaatiot.SyotteidenTestaus test = new Populaatiot.SyotteidenTestaus();
        assertFalse(test.TarkistaOnkovalillaNollaJaYksi("2"));
        assertFalse(test.TarkistaOnkovalillaNollaJaYksi("0"));
        assertFalse(test.TarkistaOnkovalillaNollaJaYksi("1"));
        assertFalse(test.TarkistaOnkovalillaNollaJaYksi("3234.3"));
        assertFalse(test.TarkistaOnkovalillaNollaJaYksi("2.334"));
        assertFalse(test.TarkistaOnkovalillaNollaJaYksi("1.1"));
        assertFalse(test.TarkistaOnkovalillaNollaJaYksi("-0.9"));
        assertFalse(test.TarkistaOnkovalillaNollaJaYksi("-32"));

    }

    public void TestataanInfluenssaDesimaalisyotettaVirheellisillaKirjaimillajaErikoismerkeilla() {
        Populaatiot.SyotteidenTestaus test = new Populaatiot.SyotteidenTestaus();
        assertFalse(test.TarkistaOnkovalillaNollaJaYksi("-"));
        assertFalse(test.TarkistaOnkovalillaNollaJaYksi("d"));
        assertFalse(test.TarkistaOnkovalillaNollaJaYksi("ff.dd"));
        assertFalse(test.TarkistaOnkovalillaNollaJaYksi("a.a"));
        assertFalse(test.TarkistaOnkovalillaNollaJaYksi("-="));
        assertFalse(test.TarkistaOnkovalillaNollaJaYksi(""));
        assertFalse(test.TarkistaOnkovalillaNollaJaYksi("O.1"));
        assertFalse(test.TarkistaOnkovalillaNollaJaYksi("f"));

    }

   
    

}
