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
    private final OutputBoundary outputBoundary;

    /**
     * Constructor of RecipeFacade
     * @param p p is the OutputBoundary that help this method access to gateway, so it can read from database
     */
    public RecipeFacade(OutputBoundary p) {
        this.outputBoundary = p;
        this.recipefinder = new RecipeFinder();
        RecipePrinter recipeprinter = new RecipePrinter();
        try {
            RW gateway = new RecipeCSV();
            this.recipes = gateway.getRecipes();
        } catch (IOException | ClassNotFoundException ignored) {
        }
    }

    /**
     * Find all the recipes available to users, all in string format
     */
    public void findRecipe(){
        List<String> fridge = currentUser.getFridge();
        String ret = recipefinder.Find(recipes, fridge);
        outputBoundary.updateAvailableRecipes(ret);
    }

    /**
     * get the detailed information of a recipe in string format
     * @param name the recipe name we want to search
     */
    public void findDetail(String name){
         String direction = recipefinder.FindDetail(recipes,name);
         outputBoundary.updateRecipeDirection(direction);
    }

    /**
     * make the current user be the user
     * @param user a user
     */
    @Override
    public void update(User user) {
        currentUser = user;
    }

    /**
     * get the recipe
     * @param recipeName a string we want to search among the recipes
     * @return a recipe which has the same recipe name as recipeName
     */
    @Override
    public Recipe getRecipes(String recipeName) {
        return recipefinder.getRecipes(recipes, recipeName);
    }

}
