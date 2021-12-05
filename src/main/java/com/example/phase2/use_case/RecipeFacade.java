package com.example.phase2.use_case;
import com.example.phase2.entity.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * RecipeFacade contains basically all methods for Recipes
 */

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

    public String findDetail(String name){
        return recipefinder.FindDetail(recipes,name);
    }

    public String printSimple(){
        return recipeprinter.printSimple(recipes);
    }
    public String printDetail() {
        return recipeprinter.printDetail(recipes);
    }
}
