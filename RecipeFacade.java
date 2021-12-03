package com.example.phase2.use_case;
import com.example.phase2.entity.Recipe;
import com.example.phase2.gateways.GetSaveUserList;
import com.example.phase2.gateways.RW;
import com.example.phase2.gateways.ReadWriter;
import com.example.phase2.gateways.RecipeCSV;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class RecipeFacade {
    private List<Recipe> recipes;
    private final RecipeFinder recipefinder;
    private final RecipePrinter recipeprinter;
    private final RecipeBook recipebook;
    private RW gateWay = new RecipeCSV();

    public RecipeFacade() {
        this.recipefinder = new RecipeFinder();
        this.recipeprinter = new RecipePrinter();
        this.recipebook = new RecipeBook();
        try {
            this.recipes = gateWay.getRecipes();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
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

    public List<Recipe> findRecipe(String ingredient){
        return recipefinder.Find(recipes, ingredient);
    }
    public String printRecipes() {
        return recipeprinter.print(recipes);
    }
}
