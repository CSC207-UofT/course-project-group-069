package com.example.phase2.use_case;

import com.example.phase2.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeFinder {
    public List<Recipe> Find(List<Recipe> recipes, List<String> fridge){
        List<Recipe> res = new ArrayList<Recipe>();
        for (Recipe recipe:recipes){
            if (fridge.containsAll(recipe.getIngredients())){
                res.add(recipe);
            }
        }
        return res;
    }

}
