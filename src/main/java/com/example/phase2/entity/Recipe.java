package com.example.phase2.entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a recipe in the system
 */

public class Recipe {
    private final String recipeName;
    private final List<String> ingredients;
    private final String directions;

    /**
     * the constructor of a recipe based on 6 parameters
     * @param recipeName the name of the recipe which is a string
     * @param ingredients the ingredients which is a list of string
     * @param directions the direction of a recipe which a string
     */
    public Recipe(String recipeName, List<String> ingredients, String directions){
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    /**
     * get the recipe name of a recipe
     * @return a string represent recipe's name
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * get the ingredients of a recipe
     * @return a list of string represent ingredients
     */
    public List<String> getIngredients() {
        List<String> ret_list = new ArrayList<>();
        for(String ing: ingredients) {
            ret_list.add(ing.toLowerCase());
        }
        return ret_list;
    }

    /**
     * get the direction of a recipe
     * @return a string represent direction
     */
    public String getDirections() {
        return directions;
    }

    /**
     * get the string format of a recipe which only have recipe name and its ingreident
     * @return a string represent recipe in simple format
     */
    public String showSimple() {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i <= ingredients.size()-1; i++) {
            res.append(ingredients.get(i));
            if (i != ingredients.size()-1){
                res.append(", ");
            }
        }
        String str = res.toString();
        return "\nRecipe: " + recipeName+
                "\nIngredients: " + str;
    }

    /**
     * get the string format of a recipe
     * @return a string represent recipe in detailed format
     */
    public String showDetail(){
        return showSimple() + "\nDirection: "+ getDirections();

    }

}