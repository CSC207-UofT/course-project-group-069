package use_case;

import entity.Ingredient;
import entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent the entire system of User
 */

public class UserManager {

    private static List<User> userList = new ArrayList<>();
    private User currentUser;


    public UserManager() {
        User user = new User("default","123");
        userList.add(user);
        currentUser = user;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void removeUser() {}

    public boolean login(String userName, String passcode) {

        for (User u: userList) {
            if (u.userName.equals(userName)) {
                currentUser = u;
            }
        }

        if (currentUser.getPasscode().equals(passcode)){
            return true;
        }
        return false;
    }

    public void uploadRecipe() {}

    public void addIngredient(String ingredientName, String foodType, String storingDuration) {
        Ingredient newIngredient = new Ingredient(ingredientName, foodType, storingDuration);
        currentUser.fridge.add(newIngredient);
    }
}
