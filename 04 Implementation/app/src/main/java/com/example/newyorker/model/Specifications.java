package com.example.newyorker.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Specifications implements Serializable {

    private String chosenStore;
    private ArrayList<String> listOfStores;
    private double totalPrice;
    private ArrayList<Wall> listOfWalls = new ArrayList<>();

    public void setChosenStore(String chosenStore) {
        this.chosenStore = chosenStore;
    }

    public ArrayList<String> getStores() {
        return listOfStores;
    }

    private void calculateTotalPrice() {
        for (Wall wall : listOfWalls) {
            totalPrice += wall.getWallPrice();
        }
    }

    public void addWall(Wall wall) {
        listOfWalls.add(wall);
    }

    public Wall getWall(int index) {
        return listOfWalls.get(index);
    }

}