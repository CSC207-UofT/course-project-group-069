package com.example.phase2.use_case;

/**
 * Represent the entire system of User. It is a facade for UserFridgeManager and UserManageLoginAndNewUser
 * hence all functionalities from those two classes are accessible from this facade.
 *
 * === Representation Invariants ===
 *  addIngredient and logout method may only be called after a user has logged in.
 */

public class UserManagerFacade {

    private UserManageLoginAndNewUser userManageLoginAndNewUser;
    private UserFridgeManager userFridgeManager;

    public UserManagerFacade() {
//        userFridgeManager = new UserFridgeManager();
//        userManageLoginAndNewUser = new UserManageLoginAndNewUser(userFridgeManager);
    }

//    /**
//     * Run the login method
//     * @param userName username of the user
//     * @param passcode passcode of the user
//     * @return true if the user successfully logged in
//     * @throws Exception
//     */
//    public void login(String userName, String passcode) throws Exception {
//        return userManageLoginAndNewUser.login(userName, passcode);
//    }

    /**
     * Run the logout method
     * @throws Exception
     */
    public void logout() throws Exception {
        userManageLoginAndNewUser.logOut();
    }


    // public void uploadRecipe() {}

    /**
     * Stores the ingredient into a User's fridge
     * @param ingredientName name of the ingredient
     * @param foodType type of the ingredient
     * @param storingDuration how long the ingredient can store
     */
    public void addIngredient(String ingredientName, String foodType, String storingDuration) {
        userFridgeManager.addIngredient(ingredientName, foodType);
    }

    /**
     * Returns a list of ingredient names that the current user possesses in the fridge.
     * @return List of string of ingredients
     */
//    public List<String> getUsersIngredientsName(){
//        return userFridgeManager.getUsersIngredientsName();
//    }

    /**
     * Create a new user given his/her new username and passcode.
     * @param username a user's new username
     * @param passcode a user's new password
     * @throws Exception
     */
    public void createUser(String username, String passcode) throws Exception {
        userManageLoginAndNewUser.createUser(username, passcode);
    }


}


