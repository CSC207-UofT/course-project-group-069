package com.example.phase2.use_case;
import com.example.phase2.entity.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeFacade {
    private List<Recipe> recipes;
    private final RecipeFinder recipefinder;
    private final RecipePrinter recipeprinter;
    private final RecipeBook recipebook;

    public RecipeFacade() {
        this.recipefinder = new RecipeFinder();
        this.recipeprinter = new RecipePrinter();
        this.recipebook = new RecipeBook();
        this.recipes = new ArrayList<Recipe>();
    }

    public void setRecipe(List<Recipe> recipes2){
        recipebook.setRecipes(recipes, recipes2);
    }
    public void addRecipe(Recipe recipe){
        recipebook.addRecipe(recipes,recipe);
    }

    public void removeRecipe(Recipe recipe){
        recipebook.removeRecipe(recipes,recipe);
    }

    public List<Recipe> findRecipe(List<String> fridge){
        return recipefinder.Find(recipes, fridge);
    }
    public String printRecipes() {
        return recipeprinter.print(recipes);
    }
}
