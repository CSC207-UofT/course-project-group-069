package com.example.phase2.entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a recipe in the system
 */

public class Recipe {
    private String recipeName;
    private List<String> ingredients;
    private String preparationDuration;
    private String directions;
    private String difficultyScale;
    private String cuisineType;
    // private User inventor; (maybe for later as the project progresses)

    /**
     * the constructor of a recipe based on 6 parameters
     * @param recipeName the name of the recipe which is a string
     * @param ingredients the ingredients which is a list of string
     * @param prep the preparation time of a recipe which is a string
     * @param directions the direction of a recipe which a string
     * @param diff the difficulty scale of a recipe which a string
     * @param cuisine the cuisine type of recipe which a string
     */
    public Recipe(String recipeName, List<String> ingredients, String prep, String directions, String diff, String cuisine){
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.preparationDuration = prep;
        this.directions = directions;
        this.difficultyScale = diff;
        this.cuisineType = cuisine;
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
     * get the preparation time of a recipe
     * @return a string represent preparation
     */
    public String getDuration() { return preparationDuration; }

    /**
     * get the difficulty scale of a recipe
     * @return a string represent difficulty scale
     */
    public String getDifficulty() { return difficultyScale; }

    /**
     * get the cuisine type of recipe
     * @return a string represent cuisine type
     */
    public String getCuisineType() { return cuisineType; }

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