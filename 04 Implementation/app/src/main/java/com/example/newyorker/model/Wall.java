package com.example.newyorker.model;

public class Wall {
    private double wallHeight;
    private double wallWidth;
    private double wallPrice;
    private double glassPanelPrice;
    private static double standardGlassHeight;
    private static double standardGlassWidth;
    private static double deliveryFee;

    private double calculateWallPrice(double height, double width){
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
}