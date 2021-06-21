package com.example.newyorker.model;


import junit.framework.TestSuite;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
public class WallUnitTest extends TestSuite {


    /**
     * Test af wall klasse calculateWallPrice metode, med valide tal.
     * @author Anders Hjordrup.
     */
    @Test
    public void testCalculateWallPrice() {
        Wall wall = new Wall();
        wall.setWallWidth(100);
        wall.setWallHeight(100);
        wall.totalPanels(5,5);
        wall.calculateWallPrice();
        assertEquals(25425.0,wall.getWallPrice());
    }


    /**
     * Test af wall klasse calculateWallPrice metode med minimums tal.
     * @author Anders Hjordrup.
     */
    @Test
    public void calculateMinimalWallPrice() {
        Wall wall = new Wall();
        wall.setWallWidth(0.1);
        wall.setWallHeight(0.1);
        wall.totalPanels(1,1);
        wall.calculateWallPrice();
        assertEquals(1785.0,wall.getWallPrice());
    }


    /**
     * Test af wall klasse calculateWallPrice metode laver den rigtige udregning med forskellige størrelser .
     * @author Anders Hjordrup.
     */
    @Test
    public void calculatWallPriceMakesCorrectCalculationBasedOnPanelsAndNotWallSize() {
        Wall wall = new Wall();
        wall.setWallWidth(100);
        wall.setWallHeight(200);
        wall.totalPanels(1,1);
        wall.calculateWallPrice();

        Wall wall2 = new Wall();
        wall2.setWallWidth(50);
        wall2.setWallHeight(100);
        wall2.totalPanels(1,1);
        wall2.calculateWallPrice();
        assertEquals(wall.getWallPrice(),wall2.getWallPrice());
    }









}