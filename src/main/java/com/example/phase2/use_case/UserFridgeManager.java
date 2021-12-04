package com.example.phase2.use_case;

import com.example.phase2.controller.OutputBoundary;
import com.example.phase2.entity.Ingredient;
import com.example.phase2.entity.User;

import java.util.ArrayList;
import java.util.List;


public class UserFridgeManager implements CurrentUserObserver {

    User currentUser;
    private OutputBoundary outputBoundary;

    public UserFridgeManager(OutputBoundary p){
        outputBoundary = p;
    }

    public void addIngredient(String ingredientName, String foodType, String storingDuration) {
        Ingredient newIngredient = new Ingredient(ingredientName, foodType, storingDuration);
        currentUser.fridge.add(newIngredient);
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

    public void removeIngredients(List<String> ingredients){
        for(String ingredient:ingredients){
            currentUser.fridge.remove(ingredient);
        }
    }

    public User getCurrentUser(){
        return currentUser;
    }

}
