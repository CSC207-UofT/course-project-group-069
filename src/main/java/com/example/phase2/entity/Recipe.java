package com.example.phase2.entity;
import java.util.List;

/**
 * Represents a recipe in the system
 */

public class Recipe {
    private String recipeName;
    private List<String> ingredients;
    private Integer preparationDuration;
    private String directions;
    private String difficultyScale;
    private String cuisineType;
    // private User inventor; (maybe for later as the project progresses)


    // TODO: implement this class
    public Recipe(String recipeName, List<String> ingredients, String directions){
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getDirections() {
        return directions;
    }

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
