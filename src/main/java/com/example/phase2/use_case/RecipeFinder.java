package com.example.phase2.use_case;

import com.example.phase2.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeFinder {
    /**
     * Find method is build for pick recipes according to what user's fridge has, project will search for
     * recipes that user can cook right now
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
     *FindDetail used for find detailed information of a recipe through a list recipes, for user to cook;
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

    public Recipe getRecipes(List<Recipe> recipes, String recipeName) {
        for(Recipe recipe: recipes){
            if (recipe.getRecipeName().equalsIgnoreCase(recipeName)){
                return recipe;
            }
        }
        return null;
    }

}
