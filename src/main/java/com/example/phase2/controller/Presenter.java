package com.example.phase2.controller;

import com.example.phase2.use_case.UserFridgeManager;

import java.util.List;

public class Presenter implements OutputBoundary {

    private boolean loginStatus = false;

    private String fridgeItems;

    // TODO delete what's in the demonstration after you implemented updateAvailableRecipes
    private String availableRecipes = "Steak | Burger | Pizza | Pasta | Taco | Burrito | Hot Pot | Beef Stir Fry";

    // TODO delete what's in the demonstration after you implemented updateRecipeDirection
    private String recipeDirection = "Put patty, tomato and lettuce between the burger bun. Enjoy!";

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

    // TODO it takes a list of String for now (and this is an example implementation)
    //  but you can change this to your need if its necessary
    public void updateAvailableRecipes(List<String> Recipes){
        availableRecipes = "";
        for (String rec: Recipes) {
            availableRecipes = availableRecipes + rec + " | ";
        }
    }

    public String getAvailableRecipes(){
        if (availableRecipes.length() == 0){
            return "No available recipes";
        }
        else {return availableRecipes;}
    }

    // TODO it takes a String for now (and this is an example implementation)
    //  but you can change this to your need if its necessary
    public void updateRecipeDirection(String direction){
        recipeDirection = direction;
    }

    public String getRecipeDirection(){
        return recipeDirection;
    }

}
