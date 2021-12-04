package com.example.phase2.controller;

import com.example.phase2.use_case.RecipeFacade;
import com.example.phase2.use_case.UserFridgeManager;
import com.example.phase2.use_case.UserManageLoginAndNewUser;
import com.example.phase2.use_case.UserManagerFacade;

public class Controller {

    private final RecipeFacade recipeManager;
    private UserManageLoginAndNewUser userManager;
    private UserFridgeManager fridge;

    /**
     * Creates an instance of MealsSystem.
     */
    public Controller(Presenter p) {
        recipeManager = new RecipeFacade();
        fridge = new UserFridgeManager(p);
        userManager = new UserManageLoginAndNewUser(fridge, p);
    }

    public void loginAction(String userName, String passcode) {
        userManager.login(userName, passcode);

    }

    public void logoutAction(){
        userManager.logOut();
    }

    public void createUserAction(String userName, String passcode) {
        userManager.createUser(userName, passcode);
    }

    public void addIngAction(String ingName, String ingType) {
        fridge.addIngredient(ingName, ingType, "1 day");
    }

    public void viewFridgeAction() {
        fridge.getUsersIngredientsName();
    }


    // TODO implement this method
    /**
     * Ask RecipeFacade use case to look up for the direction of this specific recipe.
     * @param recipeName The name of the recipe
     */
    public void getDirectionAction(String recipeName){}

    // TODO implement this method
    /**
     * Ask RecipeFacade to find the recipes that is available for the user to make
     */
    public void getAvailableRecipe(){}

    // TODO implement this method, I think FridgeManger is responsible for this, but it can be RecipeFacade too
    //  depending on the implementation

    /**
     * Ask FridgeManger to remove the ingredients from the fridge that involved making the dish.
     * @param recipeName Name of the recipe
     */
    public void cook(String recipeName){}

}
