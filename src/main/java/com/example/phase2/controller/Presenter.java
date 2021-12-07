package com.example.phase2.controller;

import com.example.phase2.use_case.UserFridgeManager;

import java.util.List;

public class Presenter implements OutputBoundary {

    private boolean loginStatus = false;

    private String fridgeItems;

    private String shoppingListItems;

    private boolean containStatus = false;

    private String availableRecipes = "";

    private String recipeDirection = "";

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

    public String getShoppingList(){
        if (shoppingListItems.isEmpty()){
            return "Empty Shopping List. Click Add Ingredient!";
        }
        return shoppingListItems;
    }

    public void updateShoppingList(List<String> shoppingList){
        shoppingListItems = "";
        for (String ingredient: shoppingList){
            shoppingListItems += ingredient + " | ";
        }
    }

    public boolean getContainStatus() {
        return containStatus;
    }

    public void updateContainStatus(){
        containStatus = !containStatus;
    }

    public void updateAvailableRecipes(String recipes){
        availableRecipes = recipes;
    }

    public String getAvailableRecipes(){
        if (availableRecipes.length() == 0){
            return "No available recipes";
        }
        else {return availableRecipes;}
    }

    public void updateRecipeDirection(String direction){
        recipeDirection = direction;
    }

    public String getRecipeDirection(){
        if (recipeDirection.length() == 0){
            return "No directions available";
        }
        else {return recipeDirection;}
    }

}
