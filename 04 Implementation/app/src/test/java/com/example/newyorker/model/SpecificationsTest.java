package com.example.newyorker.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpecificationsTest {

    /**
     * Test af addWall metode.
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
     * Test af getTotalPrice metode, med en væg.
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
     * Test af getTotalPrice metode, med flere vægge.
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
     * Test af destroyWall metode.
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


}