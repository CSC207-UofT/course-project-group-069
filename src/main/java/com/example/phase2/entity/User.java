package com.example.phase2.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * represent a user in the system
 */

public class User implements Serializable {

    public String userName;
    private final String passcode;
    public List<Ingredient> fridge;
    public List<Ingredient> shoppingList;

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
}
