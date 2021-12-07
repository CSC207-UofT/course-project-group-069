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
    private final RW gateway = new RecipeCSV();
    private OutputBoundary outputBoundary;

    /**
     * Constructor of RecipeFacade
     * @param p p is the OutputBoundary that help this method access to gateway, so it can read from database
     */
    public RecipeFacade(OutputBoundary p) {
        this.outputBoundary = p;
        this.recipefinder = new RecipeFinder();
        this.recipeprinter = new RecipePrinter();
        try {
            this.recipes = gateway.getRecipes();
        } catch (IOException | ClassNotFoundException e) {
            return;
        }
    }

//    /**
//     * set recipes to a list of recipes
//     * @param recipes2 the recipe want to be copied to our recipes
//     */
//    public void setRecipe(List<Recipe> recipes2){
//        recipebook.setRecipes(recipes, recipes2);
//    }

//    /**
//     * add a recipe to our recipes
//     * @param recipe the recipe want to be added
//     */
//    public void addRecipe(Recipe recipe){
//        recipebook.addRecipe(recipes,recipe);
//    }
//
//    /**
//     * remove a recipe from our recipes
//     * @param recipe the recipe want to be removed
//     */
//    public void removeRecipe(Recipe recipe){
//        recipebook.removeRecipe(recipes,recipe);
//    }
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

//    public String printSimple(){
//        return recipeprinter.printSimple(recipes);
//    }
//    public String printDetail() {
//        return recipeprinter.printDetail(recipes);
//    }

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
