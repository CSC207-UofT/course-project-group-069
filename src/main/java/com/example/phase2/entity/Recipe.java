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


    // TODO: implement this class
    public Recipe(String recipeName, List<String> ingredients, String prep, String directions, String diff, String cuisine){
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.preparationDuration = prep;
        this.directions = directions;
        this.difficultyScale = diff;
        this.cuisineType = cuisine;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public List<String> getIngredients() {
        List<String> ret_list = new ArrayList<>();
        for(String ing: ingredients) {
            ret_list.add(ing.toLowerCase());
        }
        return ret_list;
    }

    public String getDirections() {
        return directions;
    }

    public String getDuration() { return preparationDuration; }

    public String getDifficulty() { return difficultyScale; }

    public String getCuisineType() { return cuisineType; }


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

    public String showDetail(){
        return showSimple() + "\nDirection: "+ getDirections();

    }

}