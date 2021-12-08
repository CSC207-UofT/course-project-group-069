package com.example.phase2.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * represent a user in the system
 */

public class User implements Serializable {

    private final String userName;
    private final String passcode;
    public List<Ingredient> fridge;
    private final List<Ingredient> shoppingList;

    public User(String username, String password){
        userName = username;
        passcode = password;
        fridge = new ArrayList<>();
        shoppingList = new ArrayList<>();
    }

    /**
     * Get a user's passcode
     * @return returns a string representing the user's passcode
     */
    public String getPasscode(){
        return passcode;
    }

    /**
     * Get a user's username
     * @return returns a string representing the user's username
     */
    public String getUserName() { return userName; }

    /**
     * Get a user's fridge
     * @return returns a list of string representing the list of ingredient's in a user's fridge
     */
    public List<String> getFridge(){
        List<String> ingredients = new ArrayList<>();
        for (Ingredient ing: fridge) {
            ingredients.add(ing.getIngredientName());
        }
        return ingredients;
    }

    /**
     * Get the user's shopping list. Returns a list containing all the items in the user's shopping list.
     * @return List of ingredients present in the user's shopping list.
     */
    public List<Ingredient> getShoppingList() {
        return new ArrayList<>(shoppingList);
    }

    /**
     * Updates the user's shopping list by adding the given ingredients.
     * @param items ingredients to be added to the user's shopping list.
     */
    public void addToShoppingList(List<Ingredient> items) {
        shoppingList.addAll(items);
    }

    /**
     * Updates the user's shopping list by adding the given ingredient.
     * @param item ingredient to be added to the user's shopping list.
     */
    public void addToShoppingList(Ingredient item){
        shoppingList.add(item);
    }

    /**
     * Updates the user's shopping list by removing the given ingredient.
     * @param item ingredient to be removed from the user's shopping list.
     */
    public void removeFromShoppingList(Ingredient item){
        shoppingList.remove(item);
    }
}
