package com.example.phase2.use_case;

import com.example.phase2.entity.Recipe;

import java.util.List;

/**
 * RecipeBook contains some basic methods used for operations of list of Recipe
 */
public class RecipeBook {
    /**
     * set a list of recipe to a different recipe list
     * @param recipe1 the recipe list want to be changed
     * @param recipe2 the recipe list can to copy
     */
    public void setRecipes(List<Recipe> recipe1, List<Recipe> recipe2){
        recipe1.clear();
        for(Recipe recipe:recipe2) {
            recipe1.add(recipe);
        }
    }

    /**
     * add a recipe to a recipe list
     * @param recipes the recipe list
     * @param recipe the recipe want to add to the recipes
     */
    public void addRecipe(List<Recipe> recipes, Recipe recipe) {
        recipes.add(recipe);
    }
    /**
     * remove a recipe from a recipe list
     * @param recipes the recipe list
     * @param recipe the recipe want to remove from the recipes
     */
    public void removeRecipe(List<Recipe> recipes, Recipe recipe) {
        recipes.remove(recipe);
    }
}
