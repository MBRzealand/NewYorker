package com.example.newyorker.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Wall implements Serializable {


    private final ArrayList<Observer> COLLECTIONOFWALLOBSERVERS = new ArrayList<>();

    private void notifyObservers() {
        for (Observer observer : COLLECTIONOFWALLOBSERVERS) {
            observer.update();
        }
    }

    public void addDataObserver(Observer observer) {
        if (!COLLECTIONOFWALLOBSERVERS.contains(observer))
            COLLECTIONOFWALLOBSERVERS.add(observer);
    }



    private static transient final double STANDARD_GLASS_HEIGHT = 60;
    private static transient final double STANDARD_GLASS_WIDTH = 45;
    private static transient final double DELIVERY_FEE = 800;
    private static transient final double GLASS_PANEL_PRICE = 985;



    private double wallHeight;
    private double wallWidth;

    private double wallPrice;

    private boolean hasDoor;
    private boolean hasLockbox;
    private boolean hasHandle;
    private boolean hasWetroom;
    private boolean hasSpecialGlass;
    private boolean hasShowerWall;





    public void calculateWallPrice(double height, double width){
        wallPrice = ((height/ STANDARD_GLASS_HEIGHT) * (width/ STANDARD_GLASS_WIDTH)) * GLASS_PANEL_PRICE + DELIVERY_FEE;

        notifyObservers();
    }

    public double getWallPrice() {
        return wallPrice;
    }



    public double getWallHeight() {
        return wallHeight;
    }

    public double getWallWidth() {
        return wallWidth;
    }





    public void setWallHeight(double wallHeight) {
        this.wallHeight = wallHeight;
    }

    public void setWallWidth(double wallWidth) {
        this.wallWidth = wallWidth;
    }

    public void setWallPrice(double wallPrice) {
        this.wallPrice = wallPrice;
    }



    // booleans

    public void setHasDoor(boolean hasDoor) {
        this.hasDoor = hasDoor;
    }

    public void setHasLockbox(boolean hasLockbox) {
        this.hasLockbox = hasLockbox;
    }

    public void setHasHandle(boolean hasHandle) {
        this.hasHandle = hasHandle;
    }

    public void setHasWetroom(boolean hasWetroom) {
        this.hasWetroom = hasWetroom;
    }

    public void setHasSpecialGlass(boolean hasSpecialGlass) {
        this.hasSpecialGlass = hasSpecialGlass;
    }

    public void setHasShowerWall(boolean hasShowerWall) {
        this.hasShowerWall = hasShowerWall;
    }


}