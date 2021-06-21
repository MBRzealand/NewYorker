package com.example.newyorker.model;


import android.util.Log;

import com.example.newyorker.R;

import junit.framework.TestSuite;
import org.junit.Test;

import java.util.ArrayList;

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


    /**
     * Test of wall class calculateWindowPanelsHeight method.
     * @author Mikkel Boye Rasmussen
     */

    @Test
    public void testCalculateWindowHeight(){
        Wall wall = new Wall();
        wall.setWallHeight(30);

        wall.calculateWindowPanelsHeight(30);
        assertEquals(2,wall.getFinalListOfPanelSizesHeight().size());
        ArrayList<Double> expectedArray = new ArrayList<>();
        expectedArray.add(29.2);
        expectedArray.add(14.2);

        assertEquals(expectedArray,wall.getFinalListOfPanelSizesHeight());

    }

    /**
     * Test of wall class calculateWindowPanelsWidth method.
     * @author Mikkel Boye Rasmussen
     */

    @Test
    public void testCalculateWindowWidth(){
        Wall wall = new Wall();
        wall.setWallWidth(30);

        wall.calculateWindowPanelsWidth(30);
        assertEquals(2,wall.getFinalListOfPanelSizesWidth().size());
        ArrayList<Double> expectedArray = new ArrayList<>();
        expectedArray.add(29.2);
        expectedArray.add(14.2);

        assertEquals(expectedArray,wall.getFinalListOfPanelSizesWidth());

    }

    /**
     * Test of wall class totalPanels method.
     * @author Mikkel Boye Rasmussen
     */

    @Test
    public void testCalculateTotalPanels(){
        Wall wall = new Wall();
        wall.setWallWidth(100);
        wall.setWallHeight(100);
        wall.totalPanels(3,4);

        // price per panel 985kr
        // delivery fee 800kr
        assertEquals(12.0,wall.getNumberOfPanels());
        assertEquals(12620.0,wall.getWallPrice());

    }

    /**
     * Test af calculateWallPrice with door and handle.
     * @author Fredrik Bille
     */

    @Test
    public void testCalculateWallPriceWithDoor(){
        Wall wall = new Wall();
        wall.setWallHeight(100.0);
        wall.setWallWidth(100.0);
        wall.totalPanels(2, 8);
        wall.setHasDoor(true);
        wall.setHasHandle(true);
        wall.setHasSpecialGlass(false);



        wall.calculateWallPrice(0,0,0);
        assertEquals(18560.0, wall.getWallPrice());


    }

    /**
     * Test af calculateWallPrice with specialglasss price increase.
     * @author Fredrik Bille
     */

    @Test
    public void testCalculateWallPriceWithSpecialGlass(){
        Wall wall = new Wall();
        wall.setWallHeight(100.0);
        wall.setWallWidth(100.0);
        wall.totalPanels(2, 8);
        wall.setHasDoor(false);
        wall.setHasHandle(false);
        wall.setHasSpecialGlass(true);



        wall.calculateWallPrice(0,0,0);
        assertEquals(21648.0, wall.getWallPrice());
    }

    /**
     * Test af calculateWallPrice with wetroom price increase.
     * @author Fredrik Bille
     */

    @Test
    public void testCalculateWallPriceWithWetroom(){
        Wall wall = new Wall();
        wall.setWallHeight(100.0);
        wall.setWallWidth(100.0);
        wall.totalPanels(2, 8);
        wall.setHasDoor(false);
        wall.setHasHandle(false);
        wall.setHasSpecialGlass(false);
        wall.setHasWetroom(true);


        wall.calculateWallPrice(0,0,0);
        assertEquals(24240.0, wall.getWallPrice());

    }




    /**
     *Test of get door details method with single door.
     * @author Anders Hjordrup.
     *
     */
    @Test
    public void testGetDoorDetailsSingleDoor(){

        Wall wall = new Wall();
        wall.setWallWidth(100);
        wall.setWallHeight(100);
        String[] doorNames = {"Enkeltdør",
        "Enkeltdør m. lås",
        "Dobbeltdør",
        "Dobbeltdør m. lås",
        "Skydedør (enkelt)",
        "Skydedør (enkelt) m. lås",
       " Skydedør (dobbelt)",
        "Skydedør (dobbelt) m. lås"
        };
        assertEquals("Enkeltdør 2000.0", wall.getDoorDetail(doorNames));

    }

    /**
     *Test of get door details method with Double door.
     * @author Anders Hjordrup.
     *
     */
    @Test
    public void testGetDoorDetailsDoubleDoor(){
        Wall wall = new Wall();
        wall.setWallWidth(100);
        wall.setWallHeight(100);
        wall.calculateWallPrice(2,0,0);
        String[] doorNames = {"Enkeltdør",
                "Enkeltdør m. lås",
                "Dobbeltdør",
                "Dobbeltdør m. lås",
                "Skydedør (enkelt)",
                "Skydedør (enkelt) m. lås",
                " Skydedør (dobbelt)",
                "Skydedør (dobbelt) m. lås"
        };
        assertEquals("Dobbeltdør 4000.0", wall.getDoorDetail(doorNames));

    }
    /**
     *Test of get door details method with Sliding door.
     * @author Anders Hjordrup.
     *
     */
    @Test
    public void testGetDoorDetailsSlidingDoor(){

        Wall wall = new Wall();
        wall.setWallWidth(100);
        wall.setWallHeight(100);
        wall.calculateWallPrice(4,0,0);
        String[] doorNames = {"Enkeltdør",
                "Enkeltdør m. lås",
                "Dobbeltdør",
                "Dobbeltdør m. lås",
                "Skydedør (enkelt)",
                "Skydedør (enkelt) m. lås",
                " Skydedør (dobbelt)",
                "Skydedør (dobbelt) m. lås"
        };
        assertEquals("Skydedør (enkelt) 2480.0", wall.getDoorDetail(doorNames));

    }
    /**
     *Test of get door details method with DoubleDoor with a lockbox.
     * @author Anders Hjordrup.
     *
     */
    @Test
    public void testGetDoorDetailsDoubleDoorWithLockbox(){

        Wall wall = new Wall();
        wall.setWallWidth(100);
        wall.setWallHeight(100);
        wall.calculateWallPrice(3,0,0);
        String[] doorNames = {"Enkeltdør",
                "Enkeltdør m. lås",
                "Dobbeltdør",
                "Dobbeltdør m. lås",
                "Skydedør (enkelt)",
                "Skydedør (enkelt) m. lås",
                " Skydedør (dobbelt)",
                "Skydedør (dobbelt) m. lås"
        };
        assertEquals("Dobbeltdør m. lås 5000.0", wall.getDoorDetail(doorNames));

    }

    /**
     *Test of get door details method with Sliding door with a lockbox.
     * @author Anders Hjordrup.
     *
     */
    @Test
    public void testGetDoorDetailsSlidingDoorWithLockbox(){
        Wall wall = new Wall();
        wall.setWallWidth(100);
        wall.setWallHeight(100);
        wall.calculateWallPrice(5,0,0);
        String[] doorNames = {"Enkeltdør",
                "Enkeltdør m. lås",
                "Dobbeltdør",
                "Dobbeltdør m. lås",
                "Skydedør (enkelt)",
                "Skydedør (enkelt) m. lås",
                " Skydedør (dobbelt)",
                "Skydedør (dobbelt) m. lås"
        };
        assertEquals("Skydedør (enkelt) m. lås 2980.0", wall.getDoorDetail(doorNames));

    }

    /**
     *Test of get door details method with Single door with lockbox.
     * @author Anders Hjordrup.
     *
     */
    @Test
    public void testGetDoorDetailsSingleDoorWithLockbox(){

        Wall wall = new Wall();
        wall.setWallWidth(100);
        wall.setWallHeight(100);
        wall.calculateWallPrice(1,0,0);
        String[] doorNames = {"Enkeltdør",
                "Enkeltdør m. lås",
                "Dobbeltdør",
                "Dobbeltdør m. lås",
                "Skydedør (enkelt)",
                "Skydedør (enkelt) m. lås",
                " Skydedør (dobbelt)",
                "Skydedør (dobbelt) m. lås"
        };
        assertEquals("Enkeltdør m. lås 2500.0", wall.getDoorDetail(doorNames));

    }

    /**
     *Test of get door details method with DoubleSliding door.
     * @author Anders Hjordrup.
     *
     */
    @Test
    public void testGetDoorDetailsDoubleSlidingDoor(){

        Wall wall = new Wall();
        wall.setWallWidth(100);
        wall.setWallHeight(100);
        wall.calculateWallPrice(6,0,0);
        String[] doorNames = {"Enkeltdør",
                "Enkeltdør m. lås",
                "Dobbeltdør",
                "Dobbeltdør m. lås",
                "Skydedør (enkelt)",
                "Skydedør (enkelt) m. lås",
                "Skydedør (dobbelt)",
                "Skydedør (dobbelt) m. lås"
        };
        assertEquals("Skydedør (dobbelt) 4960.0", wall.getDoorDetail(doorNames));

    }

    /**
     *Test of get door details method with DoubleSliding door with lockbox.
     * @author Anders Hjordrup.
     *
     */
    @Test
    public void testGetDoorDetailsDoubleSlidingDoorWithLockbox(){

        Wall wall = new Wall();
        wall.setWallWidth(100);
        wall.setWallHeight(100);
        wall.calculateWallPrice(7,0,0);
        String[] doorNames = {"Enkeltdør",
                "Enkeltdør m. lås",
                "Dobbeltdør",
                "Dobbeltdør m. lås",
                "Skydedør (enkelt)",
                "Skydedør (enkelt) m. lås",
                " Skydedør (dobbelt)",
                "Skydedør (dobbelt) m. lås"
        };
        assertEquals("Skydedør (dobbelt) m. lås 5460.0", wall.getDoorDetail(doorNames));

    }

}