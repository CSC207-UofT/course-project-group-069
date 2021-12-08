package com.example.phase2.use_case;
import com.example.phase2.entity.Recipe;

import java.util.List;

public class RecipePrinter {
    /**
     * printSimple is used for user see a list of recipes, and so they can pick one
     * * @param recipes the recipe list want to be showed in string format
     */
    public String printSimple(List<Recipe> recipes){
        StringBuilder recipeItems = new StringBuilder();
        for (Recipe recipe: recipes) {
            String recipeName = recipe.getRecipeName();
            recipeItems.append(recipeName).append(" | ");
        }
        return recipeItems.toString();
    }
    /**
     * printDetail is used for user see the detail of a recipe, and so they can know how to cook a meal
     * @param recipes the recipe list want to be showed in string format
     */
    public String printDetail(List<Recipe> recipes){
        StringBuilder res = new StringBuilder();
        for(Recipe recipe:recipes){
            res.append(recipe.showDetail());
        }
        return res.toString();
    }
}
