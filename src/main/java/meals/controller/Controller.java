package meals.controller;

import meals.use_case.RecipeFacade;
import meals.use_case.UserFridgeManager;
import meals.use_case.UserManageLoginAndNewUser;

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

}
