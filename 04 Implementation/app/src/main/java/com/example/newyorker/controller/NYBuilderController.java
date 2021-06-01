package com.example.newyorker.controller;

import com.example.newyorker.exceptions.*;
import com.example.newyorker.model.Customer;
import com.example.newyorker.model.Observer;
import com.example.newyorker.model.Specifications;
import com.example.newyorker.model.Wall;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class NYBuilderController implements Serializable {

    Wall wall;
    Customer customer = new Customer();
    Specifications specifications = new Specifications();
    ArrayList<Observer> observerList = new ArrayList<>();

    public void newWall() {

        if (wall == null) {
            wall = new Wall();
        } else {
            specifications.addWall(wall);
            wall = new Wall();
        }

    }

    public Wall getWall(int index) {
       // return specifications.getWall(index);
        return this.wall;
    }

    public Customer getCustomer() {
        return customer;
    }

    //<editor-folddesc="Setters">
    public void setWallHeight(String strHeight) {

        double height = Double.parseDouble(strHeight);
        try {
            if (strHeight.isEmpty()) {
                throw new MissingWallHeightException("Mangler højde");
            } else if (!isNumeric(String.valueOf(height))) {
                throw new WallHeightNotNumericException("Der kan ikke stå bogstaver i højden");
            } else if (height < 10.8) {
                throw new WallHeightTooSmallException("Højden er for lille, min: 10.8 max: 250");
            } else if (height > 250) {
                throw new WallHeightTooHighException("Højden er for stor, min: 10.8 max: 250");
            } else {
                wall.setWallHeight(height);
            }
        } catch (MissingWallHeightException mwhe) {

        } catch (WallHeightNotNumericException whne) {

        } catch (WallHeightTooSmallException whtse) {

        } catch (WallHeightTooHighException whthe) {

        }

    }

    public void setWallWidth(String strWidth) {

        double width = Double.parseDouble(strWidth);
        try {
            if (strWidth.isEmpty()) {
                throw new MissingWallWidthException("Mangler bredde");
            } else if (!isNumeric(String.valueOf(width))) {
                throw new WallWidthNotNumericException("Der kan ikke stå bogstaver i bredden");
            } else if (width < 10.8) {
                throw new WallWidthTooSmallException("Bredden er for lille, min: 10.8 max: 250");
            } else {
                wall.setWallWidth(width);
            }
        } catch (MissingWallWidthException mwwe) {

        } catch (WallWidthNotNumericException wwnne) {

        } catch (WallWidthTooSmallException wwtse) {

        }

    }

    public void setCustomerName(String customerName) {

        try {
            if (customerName.isEmpty()) {
                throw new MissingCustomerNameException("Kunde navn er tom");
            } else if (customerName.matches(".*\\d.*")) {
                throw new CustomerNameNumericException("Kunde navn indeholder tal");
            } else {
                customer.setCustomerName(customerName);
            }
        } catch (MissingCustomerNameException mcne) {

        } catch (CustomerNameNumericException cnne) {

        }

    }

    public void setCustomerEmailAddress(String customerEmailAddress) {

        try {
            if (customerEmailAddress.isEmpty()) {
                throw new MissingCustomerEmailAddressException("Kunde E-mail er tom");
            } else if (!customerEmailAddress.contains("@")) {
                throw new CustomerEmailAddressWithoutAtSignException("Kunde E-mail indeholder ikke '@'");
            } else if (!customerEmailAddress.contains(".")) {
                throw new CustomerEmailAddressWithoutPeriodException("Kunde E-mail indeholder ikke '.'");
            } else {
                customer.setCustomerEmailAddress(customerEmailAddress);
            }
        } catch (MissingCustomerEmailAddressException mceae) {

        } catch (CustomerEmailAddressWithoutAtSignException ceawase) {

        } catch (CustomerEmailAddressWithoutPeriodException ceawpe) {

        }

    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {

        try {
            if (customerPhoneNumber.isEmpty()) {
                throw new MissingCustomerPhoneNumberException("Kunde tlf. er tom");
            } else if (!isNumeric(customerPhoneNumber)) {
                throw new CustomerPhoneNumberNotNumericException("Kunde tlf. indeholder bogstaver");
            } else {
                customer.setCustomerPhoneNumber(customerPhoneNumber);
            }
        } catch (MissingCustomerPhoneNumberException mcpne) {

        } catch (CustomerPhoneNumberNotNumericException cpnnne) {

        }

    }

    public void setCustomerZIPCode(String customerZIPCode) {

        try {
            if (customerZIPCode.isEmpty()) {
                throw new MissingCustomerZIPCodeException("Kunde post nr. er tom");
            } else if (!isNumeric(customerZIPCode)) {
                throw new CustomerZIPCodeNotNumericException("Kunde post nr. indeholder bogstaver");
            } else if (customerZIPCode.length() != 4) {
                throw new CustomerZIPCodeNotFourDigitsException("Kunde post nr. eksisterer ikke");
            } else {
                customer.setCustomerZIPCode(customerZIPCode);
            }
        } catch (MissingCustomerZIPCodeException mczipce) {

        } catch (CustomerZIPCodeNotNumericException czipcnne) {

        } catch (CustomerZIPCodeNotFourDigitsException czipcnfde) {

        }

    }

    public void setCustomerAddress(String customerAddress) {

        try {
            if (customerAddress.isEmpty()) {
                throw new MissingCustomerAddressException("Kunde adresse er tom");
            } else if (!doesNotContainSpecialCharacters(customerAddress)) {
                throw new CustomerAddressContainsSpecialCharacterException("Kunde adresse indeholder specielle tegn");
            } else {
                customer.setCustomerAddress(customerAddress);
            }
        } catch (MissingCustomerAddressException mcae) {

        } catch (CustomerAddressContainsSpecialCharacterException cacsce) {

        }

    }
    //</editor-fold>

    public void calculateWallPrice() {
        wall.calculateWallPrice();
    }

    public double getWallPrice() {
        return Math.round(wall.getWallPrice() * 100.0) / 100.0;
    }

    //<editor-folddesc="Regex">
    private final Pattern NUMPATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return NUMPATTERN.matcher(strNum).matches();
    }

    private final Pattern SPECIALCHARACTERPATTERN = Pattern.compile("[^a-zA-Z0-9ÆØÅæøå]");

    public boolean doesNotContainSpecialCharacters(String str) {
        if (str == null) {
            return false;
        }
        return SPECIALCHARACTERPATTERN.matcher(str).matches();
    }
    //</editor-fold>

    public void customizeWall(byte option, boolean checked) {
        switch (option) {
            case 1: wall.setHasDoor(checked);
            case 2: wall.setHasLockbox(checked);
            case 3: wall.setHasHandle(checked);
            case 4: wall.setHasWetroom(checked);
            case 5: wall.setHasSpecialGlass(checked);
            case 6: wall.setHasShowerWall(checked);
        }
    }

    public void addWallDataObserver(Observer observer) {
        wall.addDataObserver(observer);
    }

    public void removeWallObservers() {
        wall.removeAllObservers();
    }

    public void removeObservers() {
        observerList.remove(0);
    }
}
