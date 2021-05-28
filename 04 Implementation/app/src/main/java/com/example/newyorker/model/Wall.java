package com.example.newyorker.model;

public class Wall {
    private double wallHeight;
    private double wallWidth;
    private double wallPrice;
    private double glassPanelPrice = 985;
    private static double standardGlassHeight = 60;
    private static double standardGlassWidth = 45;
    private static double deliveryFee = 800;

    // change to private on actual implementation
    public double calculateWallPrice(double height, double width){
        wallPrice = ((height/standardGlassHeight) * (width/ standardGlassWidth)) * glassPanelPrice + deliveryFee;
        return wallPrice;
    }

    public double getWallPrice() {
        return wallPrice;
    }

    public void setWallHeight(double wallHeight) {
        this.wallHeight = wallHeight;
    }

    public void setWallWidth(double wallWidth) {
        this.wallWidth = wallWidth;
    }



    // delete these on implementation

    public double getWallHeight() {
        return wallHeight;
    }

    public double getWallWidth() {
        return wallWidth;
    }

    public void setWallPrice(double wallPrice) {
        this.wallPrice = wallPrice;
    }
}