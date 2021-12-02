package com.example.phase2.use_case;

import com.example.phase2.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeFinder {
    public List<Recipe> Find(List<Recipe> recipes, String ingredient){
        List<Recipe> results = new ArrayList<Recipe>();
        for(Recipe recipe : recipes) {
            if (recipe.containsIngredient(ingredient)) {
                results.add(recipe);
            }
        }
        return results;
    }

}
