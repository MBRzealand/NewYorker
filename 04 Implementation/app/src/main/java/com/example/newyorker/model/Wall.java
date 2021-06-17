package com.example.newyorker.model;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Wall  implements Serializable{

    //<editor-folddesc="Static variables">
    transient private static final double DELIVERY_FEE = 800;
    transient private static final double GLASS_PANEL_PRICE = 985;
    transient private static final double WETROOM_PRICE = 480;
    transient private static final double SINGLE_SLIDING_DOOR_PRICE = 2480;
    transient private static final double DOUBLE_SLIDING_DOOR_PRICE = 4960;
    transient private static final double SINGLE_SLIDING_DOOR_WITH_LOCKBOX_PRICE = 2980;
    transient private static final double DOUBLE_SLIDING_DOOR_WITH_LOCKBOX_PRICE = 5460;
    transient private static final double SINGLE_DOOR_PRICE = 2000;
    transient private static final double DOUBLE_DOOR_PRICE = 4000;
    transient private static final double SINGLE_DOOR_WITH_LOCKBOX_PRICE = 2500;
    transient private static final double DOUBLE_DOOR_WITH_LOCKBOX_PRICE = 5000;
    transient private static final double BRASS_HANDLE_PRICE = 500;
    transient private static final double BLACK_HANDLE_PRICE = 250;
    transient private static final double SATIN_GLASS_PRICE = 70;
    transient private static final double SOUNDPROOF_GLASS_PRICE = 95;
    transient private static final double ACOUSTIC_PANEL_PRICE = 318;
    transient private static final double[] DOOR_TYPE = {SINGLE_DOOR_PRICE
                                                            ,SINGLE_DOOR_WITH_LOCKBOX_PRICE
                                                            , DOUBLE_DOOR_PRICE
                                                            ,DOUBLE_DOOR_WITH_LOCKBOX_PRICE
                                                            , SINGLE_SLIDING_DOOR_PRICE
                                                            ,SINGLE_SLIDING_DOOR_WITH_LOCKBOX_PRICE
                                                            , DOUBLE_SLIDING_DOOR_PRICE
                                                            ,DOUBLE_SLIDING_DOOR_WITH_LOCKBOX_PRICE};

    transient private static final double[] HANDLE_TYPE = {BRASS_HANDLE_PRICE, BLACK_HANDLE_PRICE};

    transient private static final double[] GLASS_TYPE = {ACOUSTIC_PANEL_PRICE
                                                            ,SATIN_GLASS_PRICE
                                                            ,SOUNDPROOF_GLASS_PRICE};


    //</editor-fold

    ArrayList<Double> listOfPanelSizesHeight = new ArrayList<>();
    ArrayList<Double> finalListOfPanelSizesHeight = new ArrayList<>();
    ArrayList<Double> listOfPanelCountHeight = new ArrayList<>();
    double actualHeight;
    ArrayList<Double> listOfPanelSizesWidth = new ArrayList<>();
    ArrayList<Double> finalListOfPanelSizesWidth = new ArrayList<>();
    ArrayList<Double> listOfPanelCountWidth = new ArrayList<>();
    double actualWidth;


    private String wallName;
    private double wallHeight;
    private double wallWidth;
    private double wallPrice;
    private double[] panelsInWidthHeight = new double[2];
    private double numberOfPanels;
    private String wallColour = "Sort Struktur";

    private String doorType;

    //<editor-folddesc="Customize variables">
    private boolean hasDoor = false;
    private int doorIndex;
    private boolean hasHandle = false;
    private int handleIndex;
    private boolean hasWetroom = false;
    private boolean hasSpecialGlass = false;
    private int glassIndex;
    //</editor-fold>

    public void calculateWallPrice() {
        if (wallHeight > 0 && wallWidth > 0) {
            wallPrice = numberOfPanels * GLASS_PANEL_PRICE + DELIVERY_FEE;
            notifyObservers();
        }
    }

    public void calculateWallPrice(int doorIndex, int handleIndex, int glassIndex) {

        this.doorIndex = doorIndex;
        this.handleIndex = handleIndex;
        this.glassIndex = glassIndex;

        if (wallHeight > 0 && wallWidth > 0) {
            wallPrice = numberOfPanels * GLASS_PANEL_PRICE + DELIVERY_FEE;
        }

        if (hasDoor) {

            wallPrice += DOOR_TYPE[doorIndex];

            if (hasHandle) {
                if (doorIndex == 1 ||doorIndex == 3 ||doorIndex == 5) {
                    wallPrice += (HANDLE_TYPE[handleIndex] * 2);
                }
                else {
                    wallPrice += HANDLE_TYPE[handleIndex];
                }
            }
        }

        if (hasSpecialGlass) {
            wallPrice += (GLASS_TYPE[glassIndex] * numberOfPanels);
        }

        if (hasWetroom) {
            wallPrice += (WETROOM_PRICE * numberOfPanels);

        }
        notifyObservers();
    }

    public void totalPanels(int panelsInHeight, int panelsInWidth){

        panelsInWidthHeight[0] = panelsInWidth;
        panelsInWidthHeight[1] = panelsInHeight;
        numberOfPanels = panelsInHeight * panelsInWidth;
        calculateWallPrice();

    }

    public void calculateWindowPanelsHeight(double wallHeight){

        listOfPanelCountHeight.clear();
        listOfPanelSizesHeight.clear();
        finalListOfPanelSizesHeight.clear();

        for (int i = 10; i <= wallHeight ; i ++) {

            if (wallHeight % i == 0){

                listOfPanelSizesHeight.add((double) i);

            }

        }

        for (int i = 0; i < listOfPanelSizesHeight.size(); i++) {

            listOfPanelCountHeight.add( wallHeight/ listOfPanelSizesHeight.get(i));

        }


        for (int i = 0; i < listOfPanelSizesHeight.size(); i++) {

            actualHeight = wallHeight - ((listOfPanelCountHeight.get(i)) * 0.8);

            finalListOfPanelSizesHeight.add(actualHeight / listOfPanelCountHeight.get(i));

        }

        for (int i = 0; i < finalListOfPanelSizesHeight.size(); i++) {
            if (finalListOfPanelSizesHeight.get(i)< 10 ){
                finalListOfPanelSizesHeight.remove(i);
                listOfPanelCountHeight.remove(i);
            }
        }

        Collections.reverse(finalListOfPanelSizesHeight);
        Collections.reverse(listOfPanelCountHeight);

    }


    public void calculateWindowPanelsWidth(double wallWidth){

        listOfPanelCountWidth.clear();
        listOfPanelSizesWidth.clear();
        finalListOfPanelSizesWidth.clear();

        for (int i = 10; i <= wallWidth ; i ++) {

            if (wallWidth % i == 0){

                listOfPanelSizesWidth.add((double) i);

            }

        }

        for (int i = 0; i < listOfPanelSizesWidth.size(); i++) {

            listOfPanelCountWidth.add( wallWidth/ listOfPanelSizesWidth.get(i));

        }


        for (int i = 0; i < listOfPanelSizesWidth.size(); i++) {

            actualWidth = wallWidth - ((listOfPanelCountWidth.get(i)) * 0.8);

            finalListOfPanelSizesWidth.add(actualWidth / listOfPanelCountWidth.get(i));

        }

        for (int i = 0; i < finalListOfPanelSizesWidth.size(); i++) {
            if (finalListOfPanelSizesWidth.get(i)< 10 ){
                finalListOfPanelSizesWidth.remove(i);
                listOfPanelCountWidth.remove(i);
            }
        }

        Collections.reverse(finalListOfPanelSizesWidth);
        Collections.reverse(listOfPanelCountWidth);

    }


    //<editor-folddesc="Getters">


    public String getWallName() {
        return wallName;
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

    public String getWallColour() { return wallColour; }

    public double[] getPanelsInWidthHeight() {
        return panelsInWidthHeight;
    }

    public String getDoorType(){
        return doorType;
    }

    public ArrayList<Double> getFinalListOfPanelSizesHeight() {
        return finalListOfPanelSizesHeight;
    }

    public ArrayList<Double> getListOfPanelCountHeight() {
        return listOfPanelCountHeight;
    }

    public ArrayList<Double> getFinalListOfPanelSizesWidth() {
        return finalListOfPanelSizesWidth;
    }

    public ArrayList<Double> getListOfPanelCountWidth() {
        return listOfPanelCountWidth;
    }

    //</editor-fold>

    //<editor-folddesc="Setters">


    public void setWallName(String wallName) {
        this.wallName = wallName;
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


    public void setWallColour(String wallColour) { this.wallColour = wallColour; }

    public void setDoorType(String doorType) {
        this.doorType = doorType;
    }

// booleans

    public void setHasDoor(boolean hasDoor) {
        this.hasDoor = hasDoor;
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


    public boolean getHasDoor() {
        return hasDoor;
    }

    public boolean getHasHandle() {
        return hasHandle;
    }

    public boolean getHasWetroom() {
        return hasWetroom;
    }

    public boolean getHasSpecialGlass() {
        return hasSpecialGlass;
    }

    public void setFinalListOfPanelSizesHeight(ArrayList<Double> finalListOfPanelSizesHeight) {
        this.finalListOfPanelSizesHeight = finalListOfPanelSizesHeight;
    }

    public void setListOfPanelCountHeight(ArrayList<Double> listOfPanelCountHeight) {
        this.listOfPanelCountHeight = listOfPanelCountHeight;
    }

    public void setFinalListOfPanelSizesWidth(ArrayList<Double> finalListOfPanelSizesWidth) {
        this.finalListOfPanelSizesWidth = finalListOfPanelSizesWidth;
    }

    public void setListOfPanelCountWidth(ArrayList<Double> listOfPanelCountWidth) {
        this.listOfPanelCountWidth = listOfPanelCountWidth;
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
        if(!COLLECTIONOFWALLOBSERVERS.isEmpty()){
            COLLECTIONOFWALLOBSERVERS.removeAll(COLLECTIONOFWALLOBSERVERS);
        }
        return;
    }


    //</editor-fold>

    //<editor-folddesc="Detail getters">
    public double getPriceDetail() {
        return (numberOfPanels * GLASS_PANEL_PRICE);
    }

    public boolean hasDoor() {
        return hasDoor;
    }

    public String getDoorDetail(String[] doorNames) {
        String door = "";
        switch (doorIndex) {
            case 0: door = doorNames[0] + DOOR_TYPE[0]; break;
            case 1: door = doorNames[1] + DOOR_TYPE[1]; break;
            case 2: door = doorNames[2] + DOOR_TYPE[2]; break;
            case 3: door = doorNames[3] + DOOR_TYPE[3]; break;
            case 4: door = doorNames[4] + DOOR_TYPE[4]; break;
            case 5: door = doorNames[5] + DOOR_TYPE[5]; break;
            case 6: door = doorNames[6] + DOOR_TYPE[6]; break;
            case 7: door = doorNames[7] + DOOR_TYPE[7]; break;
        }
        return door;
    }

    public boolean hasHandle() {
        return hasHandle;
    }

    public String getHandleDetail() {
        String handle = "";
        switch (doorIndex) {
            case 0: handle = "Messing langgreb " + HANDLE_TYPE[0]; break;
            case 1: handle = "Sort langgreb " + HANDLE_TYPE[1]; break;
        }
        return handle;
    }

    public boolean hasSpecialGlass() {
        return hasSpecialGlass;
    }

    public String getSpecialGlassDetail() {
        String specialGlass = "";
        switch (doorIndex) {
            case 0: specialGlass = "Akustikpanel " + GLASS_TYPE[0]; break;
            case 1: specialGlass = "Satin glas " + GLASS_TYPE[1]; break;
            case 2: specialGlass = "Lydglas " + GLASS_TYPE[2]; break;
        }
        return specialGlass;
    }

    public boolean hasWetRoom() {
        return hasWetroom;
    }

    public double getWetRoomDetail() {
        return (WETROOM_PRICE * numberOfPanels);
    }

    public double getDeliveryFeeDetail() {
        return DELIVERY_FEE;
    }
    //</editor-fold>

}



