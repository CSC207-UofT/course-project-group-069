package com.example.phase2.use_case;

import com.example.phase2.controller.OutputBoundary;
import com.example.phase2.entity.Ingredient;
import com.example.phase2.entity.User;
import com.example.phase2.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * This class manage the fridge of the user that logged in
 *
 * === Representation Invariants ===
 * The addIngredient, getUsersIngredientsName, removeIngredient and logout method may only be called
 * after a user has logged in.
 */

public class UserFridgeManager implements CurrentUserObserver {

    private User currentUser;
    private final OutputBoundary outputBoundary;

    /**
     * Constructor
     * @param p An OutputBoundary Object
     */
    public UserFridgeManager(OutputBoundary p){
        outputBoundary = p;
    }

    /**
     * This method add an ingredient to a user's fridge who logged in
     * given the name of the ingredient and the food type the user provided.
     * If the ingredient is in that user's shopping list, it removes the
     * new ingredient from user's shopping list when added to their fridge
     * @param ingredientName name of the ingredient
     * @param foodType foot type of that ingredient (vegetable, meat,...)
     */
    public void addIngredient(String ingredientName, String foodType) {
        String ingredientNL = ingredientName.toLowerCase();
        Ingredient newIngredient = new Ingredient(ingredientNL, foodType);
        currentUser.addToFridge(newIngredient);

        //Removes the new ingredient from user's shopping list when added to their fridge
        //If the ingredient is not in their shopping list, the list remains unchanged.
        for (Ingredient ingredient : currentUser.getShoppingList()) {
            if (ingredient.getIngredientName().equalsIgnoreCase(ingredientNL)) {
                currentUser.removeFromShoppingList(ingredient);
                break;
            }
        }
    }

    /**
     * This method gets the name of all the ingredient from a user's fridge who logged in
     * and updates the fridge in the outputBoundary.
     */
    public void getUsersIngredientsName(){
        List<String> res = new ArrayList<>();
        for (Ingredient ingredient: currentUser.fridgeGetter()){
            res.add(ingredient.getIngredientName());
        }
        outputBoundary.updateFridge(res);
    }

    /**
     * Update the current user with the user who logged in
     * @param user A user object which represent a user of the program
     */
    public void update(User user) {
        currentUser = user;
    }

    /**
     * Removes all the ingredients in the fridge that's associated with making the recipe
     * given the name of the recipe.
     * @param recipeName The name of the recipe
     * @param recipeFacade RecipesGetter object which is able to get details of a specific recipe
     */
    public void Cooked(String recipeName, RecipesGetter recipeFacade){

        Recipe recipe = recipeFacade.getRecipes(recipeName);
        List<String> ingredients = recipe.getIngredients();
        for(String ingredient:ingredients){
            removeIngredient(ingredient);
        }
    }

    /**
     * Get the current user who logged in
     * @return A user object that represent a user of the program
     */
    public User getCurrentUser(){
        return currentUser;
    }

    /**
     * Removes an ingredient in the current user's fridge given the name of the ingredient
     * @param ingName Name of the ingredient
     */
    public void removeIngredient(String ingName){
        for (Ingredient ing: currentUser.fridgeGetter()){
            if(ing.getIngredientName().equalsIgnoreCase(ingName)) {
                currentUser.removeIng(ing);
                break;
            }
        }
    }

}
