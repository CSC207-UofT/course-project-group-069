package com.example.phase2.controller;

import com.example.phase2.use_case.RecipeFacade;
import com.example.phase2.use_case.UserFridgeManager;
import com.example.phase2.use_case.UserLoginManager;
import com.example.phase2.use_case.UserShoppingListManager;

/**
 * The controller class
 * Takes over immediately after the user interacts with the GUI and manipulates the use case classes to
 * perform logic and tasks.
 *
 * === Representation Invariants ===
 * The addIngAction, viewFridgeAction, and Cook method should only be called
 * after a user logged in
 */

public class Controller {

    private final RecipeFacade recipeManager;
    private final UserLoginManager userManager;
    private final UserFridgeManager fridge;
    private final UserShoppingListManager shoppingList;

    /**
     * Creates an instance of Controller.
     */
    public Controller(Presenter p) {
        recipeManager = new RecipeFacade(p);
        fridge = new UserFridgeManager(p);
        shoppingList = new UserShoppingListManager(p);
        userManager = new UserLoginManager(fridge, recipeManager, shoppingList, p);
    }

    /**
     * Performs the loginAction given the username and the passcode
     * Ask UserLoginManager to log a user in given the username and passcode
     * @param userName username of a user
     * @param passcode passcode of a user
     */
    public void loginAction(String userName, String passcode) {
        userManager.login(userName, passcode);

    }

    /**
     * performs the logout action, ask UserLoginManager to log a user out
     */
    public void logoutAction(){
        userManager.logOut();
    }

    /**
     * Performs creating a new user action given a new username and a new passcode.
     * ask userLoginManager to create a new user with username and passcode given
     * @param userName a new username of a user
     * @param passcode a new passcode of a user
     */
    public void createUserAction(String userName, String passcode) {
        userManager.createUser(userName, passcode);
    }

    /**
     * Performs an add ingredient action which adds the ingredient to the current user's fridge
     * given the name of the ingredient and the type of the ingredient.
     * ask UserFridgeManager to add ingredient
     * @param ingName name of the ingredient
     * @param ingType type of the ingredient (vegetable, meat, ...)
     */
    public void addIngAction(String ingName, String ingType) {
        fridge.addIngredient(ingName, ingType);
    }

    /**
     * Perform view fridge action which calls getUsersIngredientsName to view all the
     * ingredients in the current user's fridge
     * ask UserFridgeManager to get Users Ingredients Name
     */
    public void viewFridgeAction() {
        fridge.getUsersIngredientsName();
    }

    /**
     * Asks UserShoppingListManager to add the ingredient with the name itemName to the user's
     * shopping list.
     * @param itemName The name of the ingredient to be added to the shopping list.
     */
    public void addItemAction(String itemName) {
        this.shoppingList.addItem(itemName, "Undeclared");
    }

    /**
     * Asks UserShoppingListManager to remove the ingredient with the name itemName from the user's
     * shopping list.
     * @param itemName The name of the ingredient to be removed from the shopping list.
     */
    public void removeItemAction(String itemName) {
        this.shoppingList.removeItem(itemName);
    }

    /**
     * Asks UserShoppingListManager to save all ingredients in the shopping list in a string
     * which can be printed in order to view the items in the shopping list.
     */
    public void viewShoppingListAction() {
        this.shoppingList.getAllIngredients();
    }

    /**
     * Ask RecipeFacade use case to look up for the direction of this specific recipe.
     * @param recipeName The name of the recipe
     */
    public void getDirectionAction(String recipeName){
        recipeManager.findDetail(recipeName);
    }

    /**
     * Ask RecipeFacade to find the recipes that is available for the user to make
     */
    public void getAvailableRecipe(){
        recipeManager.findRecipe();
    }

    /**
     * Ask FridgeManger to remove the ingredients from the fridge that involved making the dish.
     * @param recipeName Name of the recipe
     */
    public void cook(String recipeName){
        fridge.Cooked(recipeName, recipeManager);
    }

}
