/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Populaatio.Matematiikka;

import Matematiikka.Petoelainsaaliselain;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ilari
 */
public class PetoelainsaaliselainTest {

    public PetoelainsaaliselainTest() {
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
    public void TestataanPalautusOikeanMuotoinen() {
        //Testataan että palautettu arraylist sisältää kolme taulukkoa:

        assertEquals(3, new Matematiikka.Petoelainsaaliselain().laske(1, 0, 0, 0, 0, 0, 0).size());
        assertEquals(3, new Matematiikka.Petoelainsaaliselain().laske(2, 1, 1, 1, 1, 1, 1).size());
        assertEquals(3, new Matematiikka.Petoelainsaaliselain().laske(0, 0, 0, 0, 0, 0, 100).size());
        assertEquals(3, new Matematiikka.Petoelainsaaliselain().laske(0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 50).size());
    }

    @Test
    public void TestataanetteiPalautusnull() {

        assertFalse(new Matematiikka.Petoelainsaaliselain().laske(1, 0, 0, 0, 0, 0, 0) == null);
        assertFalse(new Matematiikka.Petoelainsaaliselain().laske(2, 1, 1, 1, 1, 1, 1000) == null);
        assertFalse(new Matematiikka.Petoelainsaaliselain().laske(0, 0, 0, 0, 0, 0, 20) == null);
        assertFalse(new Matematiikka.Petoelainsaaliselain().laske(0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 1) == null);

    }

    @Test
    public void TestataanMaxArvoOikeaPedot() {

        Petoelainsaaliselain laskin = new Petoelainsaaliselain();
        laskin.laske(0, 1, 0, 0, 0, 0, 200);
        assertEquals(1.0, laskin.PalautaMaxPetoja(), 0.1);
        laskin = new Petoelainsaaliselain();
        laskin.laske(2, 1, 1, 1, 1, 1, 200);
        assertEquals(2.00001, laskin.PalautaMaxPetoja(), 0.1);
        laskin = new Petoelainsaaliselain();
        laskin.laske(0, 0, 0, 0, 0, 0, 200);
        assertEquals(0, laskin.PalautaMaxPetoja(), 0.1);
        laskin = new Petoelainsaaliselain();
        laskin.laske(0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 200);
        assertEquals(3.157, laskin.PalautaMaxPetoja(), 0.1);
        laskin = new Petoelainsaaliselain();
        laskin.laske(3, 4, 0.2, 0.5, 0.2, 0.5, 200);
        assertEquals(4.019, laskin.PalautaMaxPetoja(), 0.1);

    }

    @Test
    public void TestataanMaxArvoOikeaSaaliit() {

        Petoelainsaaliselain laskin = new Petoelainsaaliselain();
        laskin.laske(0, 1, 0, 0, 0, 0, 200);
        assertEquals(0.0, laskin.PalautaMaxsaaliita(), 0.1);
        laskin = new Petoelainsaaliselain();
        laskin.laske(2, 1, 1, 1, 1, 1, 200);
        assertEquals(2.00001, laskin.PalautaMaxsaaliita(), 0.1);
        laskin = new Petoelainsaaliselain();
        laskin.laske(0, 0, 0, 0, 0, 0, 200);
        assertEquals(0, laskin.PalautaMaxsaaliita(), 0.1);
        laskin = new Petoelainsaaliselain();
        laskin.laske(0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 200);
        assertEquals(3.15, laskin.PalautaMaxsaaliita(), 0.1);
        laskin = new Petoelainsaaliselain();
        laskin.laske(3, 4, 0.2, 0.5, 0.2, 0.5, 200);
        assertEquals(13.447, laskin.PalautaMaxsaaliita(), 0.1);

    }

    @Test
    public void TestataanMinArvoOikeaPedot() {

        Petoelainsaaliselain laskin = new Petoelainsaaliselain();
        laskin.laske(0, 1, 0, 0, 0, 0, 200);
        assertEquals(1.0, laskin.PalautaMinpetoja(), 0.1);
        laskin = new Petoelainsaaliselain();
        laskin.laske(2, 1, 1, 1, 1, 1, 200);
        assertEquals(0.406, laskin.PalautaMinpetoja(), 0.1);
        laskin = new Petoelainsaaliselain();
        laskin.laske(0, 0, 0, 0, 0, 0, 200);
        assertEquals(0, laskin.PalautaMinpetoja(), 0.1);
        laskin = new Petoelainsaaliselain();
        laskin.laske(0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 200);
        assertEquals(0.157106, laskin.PalautaMinpetoja(), 0.1);
        laskin = new Petoelainsaaliselain();
        laskin.laske(3, 4, 0.2, 0.5, 0.2, 0.5, 200);
        assertEquals(0.001, laskin.PalautaMinpetoja(), 0.1);

    }

    @Test
    public void TestataanMinArvoOikeaSaaliit() {

        Petoelainsaaliselain laskin = new Petoelainsaaliselain();
        laskin.laske(0, 1, 0, 0, 0, 0, 200);
        assertEquals(0.0, laskin.PalautaMinsaaliita(), 0.1);
        laskin = new Petoelainsaaliselain();
        laskin.laske(2, 1, 1, 1, 1, 1, 200);
        assertEquals(0.4063, laskin.PalautaMinsaaliita(), 0.1);
        laskin = new Petoelainsaaliselain();
        laskin.laske(0, 0, 0, 0, 0, 0, 200);
        assertEquals(0, laskin.PalautaMinsaaliita(), 0.1);
        laskin = new Petoelainsaaliselain();
        laskin.laske(0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 200);
        assertEquals(0.1571, laskin.PalautaMinsaaliita(), 0.1);
        laskin = new Petoelainsaaliselain();
        laskin.laske(3, 4, 0.2, 0.5, 0.2, 0.5, 200);
        assertEquals(0.124, laskin.PalautaMinsaaliita(), 0.1);

    }

}
