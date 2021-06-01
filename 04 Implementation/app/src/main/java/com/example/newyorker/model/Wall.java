package com.example.newyorker.model;



import java.io.Serializable;
import java.util.ArrayList;

public class Wall  implements Serializable{

    //<editor-folddesc="Static variables">
    transient private static final double STANDARD_GLASS_HEIGHT = 60;
    transient private static final double STANDARD_GLASS_WIDTH = 45;
    transient private static final double DELIVERY_FEE = 800;
    transient private static final double GLASS_PANEL_PRICE = 985;
    //</editor-fold>

    private double wallHeight;
    private double wallWidth;
    private double wallPrice;

    //<editor-folddesc="Customize variables">
    private boolean hasDoor;
    private boolean hasLockbox;
    private boolean hasHandle;
    private boolean hasWetroom;
    private boolean hasSpecialGlass;
    private boolean hasShowerWall;
    //</editor-fold>

    public void calculateWallPrice() {
        if (wallHeight > 0 && wallWidth > 0) {
            wallPrice = ((wallHeight / STANDARD_GLASS_HEIGHT) * (wallWidth / STANDARD_GLASS_WIDTH)) * GLASS_PANEL_PRICE + DELIVERY_FEE;
            notifyObservers();
        }
    }

    //<editor-folddesc="Getters">
    public double getWallPrice() {
        return wallPrice;
    }


    public double getWallHeight() {
        return wallHeight;
    }

    public double getWallWidth() {
        return wallWidth;
    }
    //</editor-fold>

    //<editor-folddesc="Setters">
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
    //</editor-fold>

    //<editor-folddesc="Observer implementation">
    //Observer implementation
    private final ArrayList<Observer> COLLECTIONOFWALLOBSERVERS = new ArrayList<>();

    private void notifyObservers() {
        for (Observer observer : COLLECTIONOFWALLOBSERVERS) {
            observer.update();
        }
    }

    public void addDataObserver(Observer observer) {
        if (!COLLECTIONOFWALLOBSERVERS.contains(observer)) {
            COLLECTIONOFWALLOBSERVERS.add(observer);
        }
    }

    public void removeAllObservers(){
        COLLECTIONOFWALLOBSERVERS.removeAll(COLLECTIONOFWALLOBSERVERS);
    }
    //</editor-fold>

}



