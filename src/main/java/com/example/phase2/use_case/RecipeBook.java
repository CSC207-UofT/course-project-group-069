package com.example.phase2.use_case;

import com.example.phase2.entity.Recipe;

import java.util.List;

public class RecipeBook {
    public void setRecipes(List<Recipe> recipe1, List<Recipe> recipe2){
        recipe1.clear();
        for(Recipe recipe:recipe2) {
            recipe1.add(recipe);
        }
    }

    public void addRecipe(List<Recipe> recipes, Recipe recipe) {
        recipes.add(recipe);
    }

    public void removeRecipe(List<Recipe> recipes, Recipe recipe) {
        recipes.remove(recipe);
    }
}
