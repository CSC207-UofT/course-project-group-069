package use_case;

import entity.Ingredient;
import entity.User;

import java.util.ArrayList;
import java.util.List;


public class UserFridgeManager implements CurrentUserObserver {

    User currentUser;

    public UserFridgeManager(){
    }

    public void addIngredient(String ingredientName, String foodType, String storingDuration) {
        Ingredient newIngredient = new Ingredient(ingredientName, foodType, storingDuration);
        currentUser.fridge.add(newIngredient);
    }
    public List<String> getUsersIngredientsName(){
        List<String> res = new ArrayList<>();
        for (Ingredient ingredient:currentUser.fridge){
            res.add(ingredient.getIngredientName());
        }
        return res;
    }

    public void update(User user) {
        currentUser = user;
    }

    public User getCurrentUser(){
        return currentUser;
    }

}
