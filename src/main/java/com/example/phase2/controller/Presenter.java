package com.example.phase2.controller;

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
    private boolean removeStatus = false;
    private String availableRecipes = "";
    private String recipeDirection = "";

    /**
     * get the login status
     * @return true if a user is successfully logged in and false otherwise.
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
        StringBuilder fi = new StringBuilder(fridgeItems);
        for (String ing: fridge) {
            fi.append(ing).append(" | ");
        }
        fridgeItems = fi.toString();
    }

    /**
     * Returns a string containing all the ingredients present in the user's shopping list.
     * If it contains no ingredients, another String is returned, which tells the user their
     * shopping list is empty.
     * @return String of all ingredients in the user's shopping list. If the user's shopping list
     * is empty, another String is returned which tells the user this.
     */
    public String getShoppingList(){
        if (shoppingListItems.isEmpty()){
            return "Empty Shopping List. Click Add Ingredient!";
        }
        return shoppingListItems;
    }

    /**
     * Saves the ingredients present in the user's shopping list in a string which can later be printed
     * in order to display the user's shopping list.
     * @param shoppingList List of ingredients present in the user's shopping list.
     */
    public void updateShoppingList(List<String> shoppingList){
        shoppingListItems = "";
        StringBuilder sli = new StringBuilder(shoppingListItems);
        for (String ingredient: shoppingList){
            sli.append(ingredient).append(" | ");
        }
        shoppingListItems = sli.toString();
    }

    /**
     * Returns a boolean value signifying the success of the action of removing an item from the
     * user's shopping list.
     * @return true if an ingredient present in the user's shopping list is successfully removed,
     * false if the ingredient is not present in the user's shopping list.
     */
    public boolean getRemoveStatus() {
        return removeStatus;
    }

    /**
     * Updates removeStatus to be either true or false.
     * @param status boolean value provided
     */
    public void updateRemoveStatus(boolean status){
        removeStatus = status;
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
            return "No available recipes to make, please enter a recipe name to look up details for that recipe";
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
