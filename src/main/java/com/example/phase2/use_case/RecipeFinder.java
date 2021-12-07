package com.example.phase2.use_case;

import com.example.phase2.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * RecipeFinder includes all the methods that turn a list of recipe into a string to present in our GUI
 */
public class RecipeFinder {
    /**
     * Find method is build for pick recipes according to what user's fridge has, project will search for
     * recipes that user can cook right now
     * @param recipes the recipe list, we want to iterate all recipes inside it
     * @param fridge a list of string, we want to find recipes according to fridge
     * @return a string represents all the recipes we find according to the fridge and recipes
     */
    public String Find(List<Recipe> recipes, List<String> fridge){
        List<Recipe> res = new ArrayList<Recipe>();
        for (Recipe recipe:recipes){
            if (fridge.containsAll(recipe.getIngredients())){
                res.add(recipe);
            }
        }
        String recipeItems = "";
        for (Recipe recipe: res) {
            String recipeName = recipe.getRecipeName();
            recipeItems = recipeItems + recipeName + " | ";
        }
        return recipeItems;
    }

    /**
     * FindDetail used for find detailed information of a recipe through a list recipes, for user to cook;
     * @param recipes the recipe list, we want to iterate all recipes inside it
     * @param recipeName a string, we want to find a recipe has the same recipe name as it
     * @return a string that present the recipe we find according to recipes and recipeName
     */
    public String FindDetail(List<Recipe> recipes, String recipeName){
        StringBuilder res = new StringBuilder();
        for(Recipe recipe: recipes){
            if (recipe.getRecipeName().equalsIgnoreCase(recipeName)){
                res.append(recipe.showDetail());
            }
        }
        String result = res.toString();
        return result;
    }

    /**
     * getRecipe used for find a recipe in recipe format, which is pretty similar with FindDetail
     * @param recipes
     * @param recipeName
     * @return a recipe we find according to recipes and recipeName
     */
    public Recipe getRecipes(List<Recipe> recipes, String recipeName) {
        for(Recipe recipe: recipes){
            if (recipe.getRecipeName().equalsIgnoreCase(recipeName)){
                return recipe;
            }
        }
        return null;
    }

}
