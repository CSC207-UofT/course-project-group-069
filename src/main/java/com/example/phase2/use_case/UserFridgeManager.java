package com.example.phase2.use_case;

import com.example.phase2.controller.OutputBoundary;
import com.example.phase2.entity.Ingredient;
import com.example.phase2.entity.User;
import com.example.phase2.entity.Recipe;

import java.util.ArrayList;
import java.util.List;


public class UserFridgeManager implements CurrentUserObserver {

    private User currentUser;
    private OutputBoundary outputBoundary;

    public UserFridgeManager(OutputBoundary p){
        outputBoundary = p;
    }

    public void addIngredient(String ingredientName, String foodType) {
        String ingredientNL = ingredientName.toLowerCase();
        Ingredient newIngredient = new Ingredient(ingredientNL, foodType);
        currentUser.fridge.add(newIngredient);

        //Removes the new ingredient from user's shopping list when added to their fridge
        //If the ingredient is not in their shopping list, the list remains unchanged.
        for (Ingredient ingredient : currentUser.shoppingList) {
            if (ingredient.getIngredientName().equalsIgnoreCase(ingredientNL)) {
                currentUser.shoppingList.remove(ingredient);
                break;
            }
        }
    }
    public void getUsersIngredientsName(){
        List<String> res = new ArrayList<>();
        for (Ingredient ingredient:currentUser.fridge){
            res.add(ingredient.getIngredientName());
        }
        outputBoundary.updateFridge(res);
    }

    public List<String> getIngredients(){
        List<String> res = new ArrayList<>();
        for (Ingredient ingredient:currentUser.fridge){
            res.add(ingredient.getIngredientName());
        }
        return res;
    }

    public void update(User user) {
        currentUser = user;
    }

    public void Cooked(String recipeName, RecipesGetter recipeFacade){

        Recipe recipe = recipeFacade.getRecipes(recipeName);
        List<String> ingredients = recipe.getIngredients();
        for(String ingredient:ingredients){
            removeIngredient(ingredient);
        }
    }

    public User getCurrentUser(){
        return currentUser;
    }


    public void removeIngredient(String ingName){
        for (Ingredient ing: currentUser.fridge){
            if(ing.getIngredientName().equalsIgnoreCase(ingName)) {
                currentUser.fridge.remove(ing);
                break;
            }
        }
    }

}
