package use_case;

import entity.Ingredient;
import entity.User;

public class UserFridgeManager implements CurrentUserObserver {

    User currentUser;

    public UserFridgeManager(){
    }

    public void addIngredient(String ingredientName, String foodType, String storingDuration) {
        Ingredient newIngredient = new Ingredient(ingredientName, foodType, storingDuration);
        currentUser.fridge.add(newIngredient);
    }

    public void update(User user) {
        currentUser = user;
    }

    public User getCurrentUser(){
        return currentUser;
    }

}
