package controller;

import ui.SystemInOut;
import use_case.RecipeManager;
import use_case.UserManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MealsSystem {

    private RecipeManager recipeManager =  new RecipeManager();
    private UserManager userManager = new UserManager();

    /**
     * Interacts with the user to prompt input of a ingredient, recipe, or user information.
     */
    public void run(SystemInOut inOut) {

        Map<String, List<String>> infoMap = new HashMap<>();

        inOut.sendOutput("Welcome! Type 'login' to continue.");

        try {
            String input = inOut.getInput();
            if (input.equals("login")) {
                inOut.sendOutput("Please enter user name");
                String inputUserName = inOut.getInput();
                inOut.sendOutput("Please enter passcode");
                String inputPassCode = inOut.getInput();

                if (userManager.login(inputUserName, inputPassCode)) {
                    inOut.sendOutput("Type 'groceries' to input groceries or type 'recipe' to find a recipe");
                    String inputGroceries = inOut.getInput();
                    if (inputGroceries.equals("groceries")) {
                        inOut.sendOutput("Please input ingredient name");
                        String ingredientName = inOut.getInput();
                        inOut.sendOutput("Please input ingredient type");
                        String ingredientType = inOut.getInput();
                        inOut.sendOutput("Please input ingredient storing duration");
                        String ingredientDuration = inOut.getInput();
                        userManager.addIngredient(ingredientName, ingredientType, ingredientDuration);
                        inOut.sendOutput("Item stored");
                    }
                }
            }

        } catch (IOException e) {
            inOut.sendOutput("Something went wrong");
        }
    }
}
