package com.example.newyorker.model;

import java.util.ArrayList;

public class NYBuilderController {

    Wall wall;
    Customer customer;
    Specifications specifications;
    ArrayList<Observer> observerList = new ArrayList<>();




    public void setWallHeight(double height){
        wall.setWallHeight(height);

    }


    public void setWallWidth(double width){
        wall.setWallWidth(width);

    }
    public void setCustomerName(String customerName) {
        customer.setCustomerName(customerName);
    }
    public void setCustomerEmailAddress(String customerEmailAddress) {
        customer.setCustomerEmailAdress(customerEmailAddress);
    }
    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        customer.setCustomerPhoneNumber(customerPhoneNumber);
    }
    public void setCustomerZIPCode(String customerZIPCode) {
        customer.setCustomerZIPCode(customerZIPCode);
    }
    public void setCustomerAddress(String customerAddress) {
        customer.setCustomerAddress(customerAddress);
    }


    public void calculateWallPrice(){
        //wall.getWallPrice();
    }














}
