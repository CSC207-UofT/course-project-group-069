package com.example.phase2.controller;

import com.example.phase2.use_case.UserFridgeManager;

import java.util.List;

public class Presenter implements OutputBoundary {

    private boolean loginStatus = false;

    private String fridgeItems;

    public boolean getLoginStatus(){
        return loginStatus;
    }

    public void updateLoginStatus() {loginStatus = true;}

    public String getFridge(){

        if (fridgeItems.length() == 0){
            return "Empty Fridge";
        }
        else {return fridgeItems;}
    }

    public void updateFridge(List<String> fridge){
        fridgeItems = "";
        for (String ing: fridge) {
            fridgeItems = fridgeItems + ing + " | ";
        }
    }


}
