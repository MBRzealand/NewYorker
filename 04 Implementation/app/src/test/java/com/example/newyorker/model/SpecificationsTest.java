package com.example.newyorker.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SpecificationsTest {

    /**
     * Test of addWall method, while using/testing getSizeOfListOfWalls and getWall.
     * @author Lasse J. Kongsdal
     */
    @Test
    public void addWall() {

        Specifications specifications = new Specifications();
        Wall wall = new Wall();
        specifications.addWall(wall);
        assertEquals(1, specifications.getSizeOfListOfWalls());
        assertEquals(wall, specifications.getWall(0));

    }

    /**
     * Test of getTotalPrice method, with one wall.
     * @author Lasse J. Kongsdal
     */
    @Test
    public void getTotalPriceWithOneWall() {

        Specifications specifications = new Specifications();
        Wall wall = new Wall();
        specifications.addWall(wall);
        assertEquals(1000, specifications.getTotalPrice(), 0.0);

    }

    /**
     * Test of getTotalPrice method, with more walls.
     * @author Lasse J. Kongsdal
     */
    @Test
    public void getTotalPriceWithMoreWalls() {

        Specifications specifications = new Specifications();
        Wall wall1 = new Wall();
        Wall wall2 = new Wall();
        Wall wall3 = new Wall();
        specifications.addWall(wall1);
        specifications.addWall(wall2);
        specifications.addWall(wall3);
        assertEquals(3000, specifications.getTotalPrice(), 0.0);

    }

    /**
     * Test of destroyWall method.
     * @author Lasse J. Kongsdal
     */
    @Test
    public void destroyWall() {

        Specifications specifications = new Specifications();
        Wall wall1 = new Wall();
        Wall wall2 = new Wall();
        specifications.addWall(wall1);
        specifications.addWall(wall2);
        assertEquals(2, specifications.getSizeOfListOfWalls());
        specifications.destroyWall(0);
        assertEquals(1, specifications.getSizeOfListOfWalls());
        assertEquals(wall2, specifications.getWall(0));

    }

    /**
     * Test of setChosenStore method, while using/testing getChosenStore.
     * @author Lasse J. Kongsdal
     */
    @Test
    public void setChosenStore() {

        Specifications specifications = new Specifications();
        specifications.setChosenStore("XL-BYG");
        assertEquals("XL-BYG", specifications.getChosenStore());

    }

    /**
     * Test of getStores method.
     * @author Lasse J. Kongsdal
     */
    @Test
    public void getStores() {

        Specifications specifications = new Specifications();
        assertNull(specifications.getStores());

    }


}