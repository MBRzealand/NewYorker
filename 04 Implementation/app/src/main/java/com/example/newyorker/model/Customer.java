package com.example.newyorker.model;

import java.io.Serializable;

public class Customer implements Serializable {
    private String customerName;
    private String customerEmailAddress;
    private String customerPhoneNumber;
    private String customerZIPCode;
    private String customerAddress;
    private String customerNotes;



    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerZIPCode() {
        return customerZIPCode;
    }

    public void setCustomerZIPCode(String customerZIPCode) {
        this.customerZIPCode = customerZIPCode;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }


    public void setCustomerNotes(String customerNotes){
        this.customerNotes = customerNotes;
    }

    public String getCustomerNotes(){
        return this.customerNotes;
    }



}
