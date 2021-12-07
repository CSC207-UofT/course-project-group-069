package com.example.phase2.controller;

import com.example.phase2.use_case.RecipeFacade;
import com.example.phase2.use_case.UserFridgeManager;
import com.example.phase2.use_case.UserManageLoginAndNewUser;
import com.example.phase2.use_case.UserShoppingListManager;

public class Controller {

    private final RecipeFacade recipeManager;
    private UserManageLoginAndNewUser userManager;
    private UserFridgeManager fridge;
    private UserShoppingListManager shoppingList;

    /**
     * Creates an instance of Controller.
     */
    public Controller(Presenter p) {
        recipeManager = new RecipeFacade(p);
        fridge = new UserFridgeManager(p);
        shoppingList = new UserShoppingListManager(p);
        userManager = new UserManageLoginAndNewUser(fridge, recipeManager, shoppingList, p);
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
        fridge.addIngredient(ingName, ingType);
    }

    public void viewFridgeAction() {
        fridge.getUsersIngredientsName();
    }

    public void addItemAction(String itemName) {
        this.shoppingList.addIngredient(itemName, "Undeclared");
    }

    public void removeItemAction(String itemName) {
        this.shoppingList.removeIngredient(itemName);
    }

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
