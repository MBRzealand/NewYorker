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
    int indexOfWallInList;
    Customer customer = new Customer();
    Specifications specifications = new Specifications();
    ArrayList<Observer> observerList = new ArrayList<>();

    public void newWall() {
        wall = new Wall();
    }

    public void addWallToList() {
        specifications.addWall(wall);
    }

    public void getWall(int index) {
        indexOfWallInList = index;
        wall = specifications.getWall(index);
    }

    public Wall getCurrentWall() {
        return this.wall;
    }

    public int getSizeOfListOfWalls() {
        return specifications.getSizeOfListOfWalls();
    }

    public String getWallDetails() {

        double[] panelsInWidthHeight = wall.getPanelsInWidthHeight();
        String details = "Navn: Væg" + indexOfWallInList +
                "\nBredde: " + wall.getWallWidth() +
                "\nHøjde: " + wall.getWallHeight() +
                "\nAntal Paneler i bredden: " + panelsInWidthHeight[0] +
                "\nAntal Paneler i højden: " + panelsInWidthHeight[1] +
                "\n     Pris: " + wall.getPriceDetail() + "kr.";
        if (wall.hasDoor()) details += "\nDør: " + wall.getDoorDetail() + "kr.";
        if (wall.hasHandle() && wall.hasDoor()) details += "\nHåndtag: " + wall.getHandleDetail() + "kr.";

        if (wall.hasSpecialGlass()) details += "\nSpecielglass: " + wall.getSpecialGlassDetail() + "kr.";
        if (wall.hasWetRoom()) details += "\nVådrum: " + wall.getWetRoomDetail() + "kr.";
        details += "\nFrag: " + wall.getDeliveryFeeDetail() + "kr." +
                "\n\n\nTotal pris: " + wall.getWallPrice() + "kr.";

        return details;
    }

    // public ImageView getCSVImage() {}

    public Customer getCustomer() {
        return customer;
    }

    //<editor-folddesc="Setters">
    public String setWallHeight(String strHeight) {

        try {
            if (strHeight.isEmpty()) {
                throw new MissingWallHeightException("Mangler højde");
            } else if (!isNumeric(strHeight)) {
                throw new WallHeightNotNumericException("Der kan ikke stå bogstaver i højden");
            } else if (Double.parseDouble(strHeight) < 10.8) {
                throw new WallHeightTooSmallException("Højden er for lille, min: 10.8 max: 250");
            } else if (Double.parseDouble(strHeight) > 250) {
                throw new WallHeightTooHighException("Højden er for stor, min: 10.8 max: 250");
            } else {
                wall.setWallHeight(Double.parseDouble(strHeight));
            }
        } catch (MissingWallHeightException mwhe) {
            return mwhe.getMessage();

        } catch (WallHeightNotNumericException whne) {
            return whne.getMessage();
        } catch (WallHeightTooSmallException whtse) {
            return whtse.getMessage();
        } catch (WallHeightTooHighException whthe) {
            return whthe.getMessage();
        }
        return "";
    }

    public String setWallWidth(String strWidth) {

        try {
            if (strWidth.isEmpty()) {
                throw new MissingWallWidthException("Mangler bredde");
            } else if (!isNumeric(strWidth)) {
                throw new WallWidthNotNumericException("Der kan ikke stå bogstaver i bredden");
            } else if (Double.parseDouble(strWidth) < 10.8) {
                throw new WallWidthTooSmallException("Bredden er for lille, min: 10.8 max: 250");
            } else {
                wall.setWallWidth(Double.parseDouble(strWidth));
            }
        } catch (MissingWallWidthException mwwe) {
            return mwwe.getMessage();
        } catch (WallWidthNotNumericException wwnne) {
            return wwnne.getMessage();
        } catch (WallWidthTooSmallException wwtse) {
            return wwtse.getMessage();
        }
        return "";
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

    public void setCustomerNotes(String  customerNotes){
        customer.setCustomerNotes(customerNotes);
    }



    public void setCustomerAddress(String customerAddress) {

        try {
            if (customerAddress.isEmpty()) {
                throw new MissingCustomerAddressException("Kunde adresse er tom");
            } else if (containsSpecialCharacters(customerAddress)) {
                throw new CustomerAddressContainsSpecialCharacterException("Kunde adresse indeholder specielle tegn");
            }else {
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

    public double getTotalPrice() {
        return Math.round(specifications.getTotalPrice() * 100.0) / 100.0;
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

    public boolean containsSpecialCharacters(String str) {
        if (str == null) {
            return false;
        }
        return SPECIALCHARACTERPATTERN.matcher(str).matches();
    }
    //</editor-fold>

    public void customizeWall(byte option, boolean checked) {
        switch (option) {
            case 1: wall.setHasDoor(checked);
            break;
            case 3: wall.setHasHandle(checked);
            break;
            case 4: wall.setHasWetroom(checked);
            break;
            case 5: wall.setHasSpecialGlass(checked);
            break;
        }
    }



    public void setWallColour(int index) {
        switch (index) {
            case 0: wall.setWallColour("Sort Struktur");
                break;
            case 1: wall.setWallColour("Sort");
                break;
            case 2: wall.setWallColour("Klar Lak");
                break;
            case 3: wall.setWallColour("Grå Struktur");
                break;
            case 4: wall.setWallColour("Lyse Grå");
                break;
            case 5: wall.setWallColour("Hvid Struktur");
                break;
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
