package meals.use_case;

import meals.controller.OutputBoundary;
import meals.entity.Ingredient;
import meals.entity.User;

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

    public void update(User user) {
        currentUser = user;
    }

    public User getCurrentUser(){
        return currentUser;
    }

}
