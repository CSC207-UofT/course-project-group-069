package use_case;

import entity.Ingredient;
import entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent the entire system of User. It is a facade for UserFridgeManager and UserManageLoginAndNewUser
 * hence all functionalities from those two classes are accessible from this facade.
 *
 * === Representation Invariants ===
 *  addIngredient method may only be called after a user has logged in.
 */

public class UserManagerFacade {

    private UserManageLoginAndNewUser userManageLoginAndNewUser;
    private UserFridgeManager userFridgeManager;

    public UserManagerFacade() {
        userFridgeManager = new UserFridgeManager();
        userManageLoginAndNewUser = new UserManageLoginAndNewUser(userFridgeManager);
    }

    /**
     * Run the login method
     * @param userName username of the user
     * @param passcode passcode of the user
     * @return true if the user successfully logged in
     * @throws Exception
     */
    public boolean login(String userName, String passcode) throws Exception{
        return userManageLoginAndNewUser.login(userName, passcode);
    }


    public void uploadRecipe() {}

    /**
     * Stores the ingredient into a User's fridge
     * @param ingredientName name of the ingredient
     * @param foodType type of the ingredient
     * @param storingDuration how long the ingredient can store
     */
    public void addIngredient(String ingredientName, String foodType, String storingDuration) {
        userFridgeManager.addIngredient(ingredientName, foodType, storingDuration);
    }

    public void getIngredientsname(){
        userFridgeManager.getIngredient();
    }
}


