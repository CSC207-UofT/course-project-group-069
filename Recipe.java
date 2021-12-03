package com.example.phase2.entity;
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
    public Recipe(String recipeName, List<String> ingredients, String prep, String dir, String difficulty, String cuisine){
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.preparationDuration = prep;
        this.directions = dir;
        this.difficultyScale = difficulty;
        this.cuisineType = cuisine;
    }

    public String getRecipeName() { return recipeName; }
    public List<String> getRecipeIngredients() {
        return ingredients;
    }
    public String getRecipeDuration() {
        return preparationDuration;
    }
    public String getRecipeDirections() {
        return directions;
    }
    public String getRecipeDifficulty() {
        return difficultyScale;
    }
    public String getRecipeCuisine() {
        return cuisineType;
    }

    public boolean containsIngredient(String ingredient){
        return ingredients.contains(ingredient);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(String str : ingredients)
        {
            res.append(str);
            res.append(", ");
        }
        res.deleteCharAt(res.length()-1);
        res.deleteCharAt(res.length()-1);
        String str = res.toString();
        return "Recipe name = " + recipeName+
                ", ingredients = " + str +"\n";
    }
}
