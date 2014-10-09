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

        assertEquals(3, new Matematiikka.Petoelainsaaliselain().laske(1, 0, 0, 0, 0, 0).size());
        assertEquals(3, new Matematiikka.Petoelainsaaliselain().laske(2, 1, 1, 1, 1, 1).size());
        assertEquals(3, new Matematiikka.Petoelainsaaliselain().laske(0, 0, 0, 0, 0, 0).size());
        assertEquals(3, new Matematiikka.Petoelainsaaliselain().laske(0.3, 0.3, 0.3, 0.3, 0.3, 0.3).size());
    }

    @Test
    public void TestataanetteiPalautusnull() {

        assertFalse(new Matematiikka.Petoelainsaaliselain().laske(1, 0, 0, 0, 0, 0) == null);
        assertFalse(new Matematiikka.Petoelainsaaliselain().laske(2, 1, 1, 1, 1, 1) == null);
        assertFalse(new Matematiikka.Petoelainsaaliselain().laske(0, 0, 0, 0, 0, 0) == null);
        assertFalse(new Matematiikka.Petoelainsaaliselain().laske(0.3, 0.3, 0.3, 0.3, 0.3, 0.3) == null);

    }

    @Test
    public void TestataanMaxArvoOikeaPedot() {

        Petoelainsaaliselain laskin = new Petoelainsaaliselain();
        laskin.laske(1, 0, 0, 0, 0, 0);
        assertEquals((int) 1.0, (int) laskin.PalautaMaxPetoja());

        laskin.laske(2, 1, 1, 1, 1, 1);
        assertEquals((int) 2.00001, (int) laskin.PalautaMaxPetoja());

        laskin.laske(0, 0, 0, 0, 0, 0);
        assertEquals((int) 0, (int) laskin.PalautaMaxPetoja());

        laskin.laske(0.3, 0.3, 0.3, 0.3, 0.3, 0.3);
        assertEquals((int) 3.157, (int) laskin.PalautaMaxPetoja());

        laskin.laske(4, 3, 0.2, 0.5, 0.2, 0.5);
        assertEquals((int) 4.019, (int) laskin.PalautaMaxPetoja());

    }

    @Test
    public void TestataanMaxArvoOikeaSaaliit() {

        Petoelainsaaliselain laskin = new Petoelainsaaliselain();
        laskin.laske(1, 0, 0, 0, 0, 0);
        assertEquals((int) 0.0, (int) laskin.PalautaMaxsaaliita());

        laskin.laske(2, 1, 1, 1, 1, 1);
        assertEquals((int) 2.00001, (int) laskin.PalautaMaxsaaliita());

        laskin.laske(0, 0, 0, 0, 0, 0);
        assertEquals((int) 0, (int) laskin.PalautaMaxsaaliita());

        laskin.laske(0.3, 0.3, 0.3, 0.3, 0.3, 0.3);
        assertEquals((int) 3.15, (int) laskin.PalautaMaxsaaliita());

        laskin.laske(4, 3, 0.2, 0.5, 0.2, 0.5);
        assertEquals((int) 13.447, (int) laskin.PalautaMaxsaaliita());

    }

    @Test
    public void TestataanMinArvoOikeaPedot() {

        Petoelainsaaliselain laskin = new Petoelainsaaliselain();
        laskin.laske(1, 0, 0, 0, 0, 0);
        assertEquals((int) 1.0, (int) laskin.PalautaMinpetoja());

        laskin.laske(2, 1, 1, 1, 1, 1);
        assertEquals((int) 0.406, (int) laskin.PalautaMinpetoja());

        laskin.laske(0, 0, 0, 0, 0, 0);
        assertEquals((int) 0, (int) laskin.PalautaMinpetoja());

        laskin.laske(0.3, 0.3, 0.3, 0.3, 0.3, 0.3);
        assertEquals((int) 0.157106, (int) laskin.PalautaMinpetoja());

        laskin.laske(4, 3, 0.2, 0.5, 0.2, 0.5);
        assertEquals((int) 1.7384, (int) laskin.PalautaMinpetoja());

    }

    @Test
    public void TestataanMinArvoOikeaSaaliit() {

        Petoelainsaaliselain laskin = new Petoelainsaaliselain();
        laskin.laske(1, 0, 0, 0, 0, 0);
        assertEquals((int) 0.0, (int) laskin.PalautaMinsaaliita());

        laskin.laske(2, 1, 1, 1, 1, 1);
        assertEquals((int) 0.4063, (int) laskin.PalautaMinsaaliita());

        laskin.laske(0, 0, 0, 0, 0, 0);
        assertEquals((int) 0, (int) laskin.PalautaMinsaaliita());

        laskin.laske(0.3, 0.3, 0.3, 0.3, 0.3, 0.3);
        assertEquals((int) 0.1571, (int) laskin.PalautaMinsaaliita());

        laskin.laske(4, 3, 0.2, 0.5, 0.2, 0.5);
        assertEquals((int) 1.8440, (int) laskin.PalautaMinsaaliita());

    }

}
