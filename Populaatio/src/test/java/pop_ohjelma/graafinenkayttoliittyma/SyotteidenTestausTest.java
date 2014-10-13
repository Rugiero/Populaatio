/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pop_ohjelma.graafinenkayttoliittyma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author iangervu
 */
public class SyotteidenTestausTest {

    public SyotteidenTestausTest() {
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

//    @Test
//    public void TestataanVirheellisisaKokonaislukusyotteita() {
//        SyotteidenTestaus test = new SyotteidenTestaus();
//
//        assertFalse(test.KokonaisluvunSyotto("-2300"));
//
//        assertFalse(test.KokonaisluvunSyotto("-1"));
//        assertFalse(test.KokonaisluvunSyotto("4.5"));
//        assertFalse(test.KokonaisluvunSyotto("-1.8"));
//        assertFalse(test.KokonaisluvunSyotto("-0.1"));
//        assertFalse(test.KokonaisluvunSyotto("-1234"));
//        assertFalse(test.KokonaisluvunSyotto("-gg"));
//        assertFalse(test.KokonaisluvunSyotto("-%%"));
//        assertFalse(test.KokonaisluvunSyotto("-/"));
//        assertFalse(test.KokonaisluvunSyotto("-abc"));
//        assertFalse(test.KokonaisluvunSyotto("-a"));
//        assertFalse(test.KokonaisluvunSyotto("?"));
//    }
//
//    @Test
//    public void TestataanSyotteitaKirjaimillaJaErikoismerkeilla() {
//        SyotteidenTestaus test = new SyotteidenTestaus();
//        assertFalse(test.KokonaisluvunSyotto("-"));
//        assertFalse(test.KokonaisluvunSyotto("a"));
//        assertFalse(test.KokonaisluvunSyotto("b"));
//        assertFalse(test.KokonaisluvunSyotto("19/"));
//        assertFalse(test.KokonaisluvunSyotto("24+"));
//        assertFalse(test.KokonaisluvunSyotto("+-/"));
//        assertFalse(test.KokonaisluvunSyotto("."));
//        assertFalse(test.KokonaisluvunSyotto(""));
//
//    }
//
//    @Test
//    public void TestataanVirheellisillaDesimaaleillaValillaNollaJaYksi() {
//        SyotteidenTestaus test = new SyotteidenTestaus();
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("2"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("3234.3"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("2.334"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("1.1"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("-0.9"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("-32"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("-1000000"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("-f.ff.ggr.f332"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("-\\"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("-=)"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("0."));
//        assertFalse(test.DesimaalinSyotto("0."));
//        assertFalse(test.DesimaalinSyotto("0.."));
//        assertFalse(test.DesimaalinSyotto(".0."));
//        assertFalse(test.DesimaalinSyotto("..0"));
//        assertFalse(test.DesimaalinSyotto(".0"));
//        assertFalse(test.DesimaalinSyotto(".234."));
//
//    }
//
//    @Test
//    public void TestataanDesimaalisyotettaKirjaimillajaErikoismerkeilla() {
//        SyotteidenTestaus test = new SyotteidenTestaus();
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("-"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("d"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("ff.dd"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("a.a"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("-="));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1(""));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("O."));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("f"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("fatraafaf"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("-1421"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("-333232"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("€€¥¥$£"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("æœ"));
//        assertFalse(test.DesimaalinSyottoValilla0Ja1("f"));
//    }
//
//    @Test
//    public void TestataanHyvaksyttaviaKokonaislukusyotteita() {
//        SyotteidenTestaus test = new SyotteidenTestaus();
//        assertTrue(test.KokonaisluvunSyotto("0"));
//        assertTrue(test.KokonaisluvunSyotto("14"));
//        assertTrue(test.KokonaisluvunSyotto("2"));
//        assertTrue(test.KokonaisluvunSyotto("1000"));
//        assertTrue(test.KokonaisluvunSyotto("3"));
//        assertTrue(test.KokonaisluvunSyotto("999"));
//        assertTrue(test.KokonaisluvunSyotto("25"));
//        assertTrue(test.KokonaisluvunSyotto("63"));
//        assertTrue(test.KokonaisluvunSyotto("666"));
//        assertTrue(test.KokonaisluvunSyotto("10001332"));
//        assertTrue(test.DesimaalinSyottoValilla0Ja1("1"));
//
//    }
//
//    @Test
//    public void TestataanHyvaksyttavillaDesimaaleillaValillaNollaJaYksi() {
//        SyotteidenTestaus test = new SyotteidenTestaus();
//        assertTrue(test.DesimaalinSyottoValilla0Ja1("0.01"));
//        assertTrue(test.DesimaalinSyottoValilla0Ja1("0.999"));
//        assertTrue(test.DesimaalinSyottoValilla0Ja1("0.5"));
//        assertTrue(test.DesimaalinSyottoValilla0Ja1("0.74"));
//        assertTrue(test.DesimaalinSyottoValilla0Ja1("0.000001"));
//        assertTrue(test.DesimaalinSyottoValilla0Ja1("0.74"));
//        assertTrue(test.DesimaalinSyottoValilla0Ja1("0.3"));
//        assertTrue(test.DesimaalinSyottoValilla0Ja1("0.999999"));
//        assertTrue(test.DesimaalinSyottoValilla0Ja1("0"));
//
//    }
    @Test
    public void TestataanVirheellisillaDesimaaleilla() {
        SyotteidenTestaus test = new SyotteidenTestaus();
        assertFalse(test.DesimaalinSyotto("2.5.75"));
        assertFalse(test.DesimaalinSyotto("3234..3"));
        assertFalse(test.DesimaalinSyotto("2334."));
        assertFalse(test.DesimaalinSyotto("..11"));
        assertFalse(test.DesimaalinSyotto("-0.9"));
        assertFalse(test.DesimaalinSyotto("-32"));
        assertFalse(test.DesimaalinSyotto("-1000000"));
        assertFalse(test.DesimaalinSyotto("-f.ff.ggr.f332"));
        assertFalse(test.DesimaalinSyotto("-\\"));
        assertFalse(test.DesimaalinSyotto("-=)"));
        assertFalse(test.DesimaalinSyotto("0."));
        assertFalse(test.DesimaalinSyotto("0.."));
        assertFalse(test.DesimaalinSyotto(".0."));
        assertFalse(test.DesimaalinSyotto("..0"));
        assertFalse(test.DesimaalinSyotto(".0"));
        assertFalse(test.DesimaalinSyotto(".34"));
        assertFalse(test.DesimaalinSyotto(""));
   
    }

    @Test
    public void TestataanHyvaksyttavillaDesimaaleilla() {
        SyotteidenTestaus test = new SyotteidenTestaus();
        assertTrue(test.DesimaalinSyotto("0.01"));
        assertTrue(test.DesimaalinSyotto("2.999"));
        assertTrue(test.DesimaalinSyotto("46.5"));
        assertTrue(test.DesimaalinSyotto("3.74"));
        assertTrue(test.DesimaalinSyotto("0.000001"));
        assertTrue(test.DesimaalinSyotto("4.74"));
        assertTrue(test.DesimaalinSyotto("4"));
        assertTrue(test.DesimaalinSyotto("0"));
        assertTrue(test.DesimaalinSyotto("1"));
        assertTrue(test.DesimaalinSyotto("4000"));
        assertTrue(test.DesimaalinSyotto("2"));
        assertTrue(test.DesimaalinSyotto("23526"));
        assertTrue(test.DesimaalinSyotto("474"));

    }
}
