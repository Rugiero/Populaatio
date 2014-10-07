/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatematiikkaTestit;

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
public class PetoElainSaalisElainTest {

    Matematiikka.Petoelainsaaliselain test;

    public PetoElainSaalisElainTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        this.test = new Matematiikka.Petoelainsaaliselain();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
        //Testataan että palautettu arraylist sisältää kolme taulukkoa:

        assertEquals(3, test.laske(1, 0, 0, 0, 0, 0).size());
        assertEquals(3, test.laske(2, 1, 1, 1, 1, 1).size());
        assertEquals(3, test.laske(1000, 999, 1000, 1000, 1000, 1000).size());
        assertEquals(3, test.laske(0.3, 0.3, 0.3, 0.3, 0.3, 0.3).size());
    }
}
