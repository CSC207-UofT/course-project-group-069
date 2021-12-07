package com.example.phase2.controller;

import com.example.phase2.use_case.UserFridgeManager;

import java.util.List;

/**
 * Presenter class
 * Use case classes updates this class when actions are performed.
 * The GUI will see the updates when actions are performed
 */

public class Presenter implements OutputBoundary {

    private boolean loginStatus = false;
    private String fridgeItems;
    private String shoppingListItems;
    private boolean containStatus = false;
    private String availableRecipes = "";
    private String recipeDirection = "";

    /**
     * get the login status
     * @return returns tru if a user successfully logged in and false other wise
     */
    public boolean getLoginStatus(){
        return loginStatus;
    }

    /**
     * Update the login status of a user
     */
    public void updateLoginStatus() {loginStatus = true;}

    /**
     * get all the ingredients in a user's fridge
     * @return returns a string of all ingredients in user's fridge
     */
    public String getFridge(){
        if (fridgeItems.length() == 0){
            return "Empty Fridge";
        }
        else {return fridgeItems;}
    }

    /**
     * update the items in a user's fridge
     * @param fridge a list of string representing all the items in a user's fridge
     */
    public void updateFridge(List<String> fridge){
        fridgeItems = "";
        for (String ing: fridge) {
            fridgeItems = fridgeItems + ing + " | ";
        }
    }

    /**
     *
     * @return
     */
    public String getShoppingList(){
        if (shoppingListItems.isEmpty()){
            return "Empty Shopping List. Click Add Ingredient!";
        }
        return shoppingListItems;
    }

    /**
     *
     * @param shoppingList
     */
    public void updateShoppingList(List<String> shoppingList){
        shoppingListItems = "";
        for (String ingredient: shoppingList){
            shoppingListItems += ingredient + " | ";
        }
    }

    /**
     *
     * @return
     */
    public boolean getContainStatus() {
        return containStatus;
    }

    /**
     *
     */
    public void updateContainStatus(){
        containStatus = !containStatus;
    }

    /**
     * update the available recipes a user can make
     * @param recipes a string of all the recipes a user can make given the ingredients the user has
     */
    public void updateAvailableRecipes(String recipes){
        availableRecipes = recipes;
    }

    /**
     * Get all the available recipes a user can make
     * @return returns a string of available recipe names a user can make
     */
    public String getAvailableRecipes(){
        if (availableRecipes.length() == 0){
            return "No available recipes";
        }
        else {return availableRecipes;}
    }

    /**
     * update the direction/details of a recipe
     * @param direction a string that represents the direction/details of a recipe
     */
    public void updateRecipeDirection(String direction){
        recipeDirection = direction;
    }

    /**
     * Get the direction/detail of a recipe
     * @return returns a string of that represents the direction/details of a recipe
     */
    public String getRecipeDirection(){
        if (recipeDirection.length() == 0){
            return "No directions available";
        }
        else {return recipeDirection;}
    }

}
