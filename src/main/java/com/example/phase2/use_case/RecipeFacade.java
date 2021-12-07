package com.example.phase2.use_case;
import com.example.phase2.controller.OutputBoundary;
import com.example.phase2.entity.Recipe;
import com.example.phase2.entity.User;
import com.example.phase2.gateways.RW;
import com.example.phase2.gateways.RecipeCSV;

import java.io.IOException;
import java.util.List;

/**
 * RecipeFacade contains basically all methods for Recipes
 */

public class RecipeFacade implements CurrentUserObserver, RecipesGetter{
    public List<Recipe> recipes;
    public User currentUser;
    private final RecipeFinder recipefinder;
    private final RecipePrinter recipeprinter;
    private final RecipeBook recipebook;
    private final RW gateway = new RecipeCSV();
    private OutputBoundary outputBoundary;

    public RecipeFacade(OutputBoundary p) {
        this.outputBoundary = p;
        this.recipefinder = new RecipeFinder();
        this.recipeprinter = new RecipePrinter();
        this.recipebook = new RecipeBook();
        try {
            this.recipes = gateway.getRecipes();
        } catch (IOException | ClassNotFoundException e) {
            return;
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

    public void findRecipe(){
        List<String> fridge = currentUser.getFridge();
        String ret = recipefinder.Find(recipes, fridge);
        outputBoundary.updateAvailableRecipes(ret);
    }

    public void findDetail(String name){
         String direction = recipefinder.FindDetail(recipes,name);
         outputBoundary.updateRecipeDirection(direction);
    }

    public String printSimple(){
        return recipeprinter.printSimple(recipes);
    }
    public String printDetail() {
        return recipeprinter.printDetail(recipes);
    }

    @Override
    public void update(User user) {
        currentUser = user;
    }

    @Override
    public Recipe getRecipes(String recipeName) {
        return recipefinder.getRecipes(recipes, recipeName);
    }

}
