package com.example.newyorker.model;

import java.util.ArrayList;

public class Specifications {
    private String chosenStore;
    private ArrayList<String> listOfStores;
    private double totalPrice;

    public void setChosenStore(String chosenStore) {
        this.chosenStore = chosenStore;
    }

    public ArrayList<String> getStores() {
        return listOfStores;
    }

    private double calculateTotalPrice(){
        return 0;
    }
}