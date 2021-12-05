package com.example.phase2.use_case;
import com.example.phase2.entity.Recipe;

import java.util.List;

public class RecipePrinter {
    /**
     * printSimple is used for user see a list of recipes, and so they can pick one
     */
    public String printSimple(List<Recipe> recipes){
        StringBuilder res = new StringBuilder();
        for(Recipe recipe:recipes){
            res.append(recipe.showSimple());
        }
        String str = res.toString();
        return str;
    }
    /**
     * printDetail is used for user see the detail of a recipe, and so they can know how to cook a meal
     */
    public String printDetail(List<Recipe> recipes){
        StringBuilder res = new StringBuilder();
        for(Recipe recipe:recipes){
            res.append(recipe.showDetail());
        }
        String str = res.toString();
        return str;
    }
}
