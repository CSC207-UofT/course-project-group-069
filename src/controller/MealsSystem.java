package controller;

import entity.Recipe;
import ui.SystemInOut;
import use_case.RecipeFacade;
import use_case.UserManagerFacade;
import java.io.IOException;
import java.util.List;

public class MealsSystem {

    private final RecipeFacade recipeManager;
    private final UserManagerFacade userManager;

    /**
     * Creates an instance of MealsSystem.
     */
    public MealsSystem() {
        recipeManager = new RecipeFacade();
        userManager = new UserManagerFacade();
    }

    /**
     * Allows the user to perform function including logging in, creating an account,
     * finding recipes, and adding ingredients to their fridge.
     * @param inOut allows communication with the user through receiving inputs and sending outputs
     */
    public void run(SystemInOut inOut) {

        //while the checker is true, keep running the loop. the checker only becomes false
        //when the user creates an account or logs in successfully.
        boolean checker = true;
        while (checker) {
            inOut.sendOutput("Please type \"Create Account\" if you are new, " +
                    "\"Login\" if you already have an account, or \"Quit\"");

            try {
                switch (inOut.getInput()) {
                    case "Create Account": {
                        String[] details = getDetails(inOut);
                        userManager.createUser(details[0], details[1]);
                        checker = false;
                        inOut.sendOutput("Account Created!");
                        break;
                    }
                    case "Login": {
                        String[] details2 = getDetails(inOut);
                        checker = !(userManager.login(details2[0], details2[1]));
                        if (checker) {
                            inOut.sendOutput("Incorrect Username or Password");
                        }
                        else {
                            inOut.sendOutput("Login Successful! Welcome back!");
                        }
                        break;
                    }
                    case "Quit": {
                        inOut.sendOutput("Quit Successfully");
                        return;
                    }
                    default:
                        inOut.sendOutput("Input not recognized.");
                }
            } catch (IOException io) { //exception for inOut.getInput()
                inOut.sendOutput("Something went wrong. Please try again");
            } catch (Exception e) {
                inOut.sendOutput("Login Failed. Please try again"); //exception for bad login
            }
        }

        boolean logOut = true;
        while (logOut) {
            inOut.sendOutput("If you'd like to add an ingredient to your fridge, please type \"Add\" \n" +
                             "If you would like to find a recipe, please type \"Recipe\" \n" +
                             "If you wish to view the items in your fridge, please type \"Fridge\" \n" +
                             "To logout, please type \"Logout\"");
            try {
                switch (inOut.getInput()) {
                    case "Add":{
                        inOut.sendOutput("What ingredient would you like to add?");
                        String name = inOut.getInput();
                        inOut.sendOutput("What food type is it?");
                        String foodType = inOut.getInput();
                        userManager.addIngredient(name, foodType, "1 day");
                        inOut.sendOutput("Successfully stored!\n\n");
                        break;
                    }
                    case "Fridge":{
                        inOut.sendOutput(userManager.getUsersIngredientsName());
                        break;
                    }
                    case "Recipe":{
                        inOut.sendOutput("If you'd like to get a recipe for a specific ingredient, " +
                                "please type your ingredient.\nOr if you'd like to get a list of recipes that " +
                                "you can cook using items from your fridge, please type \"List\"");
                        String recipeInput = inOut.getInput();
                        if ("List".equals(recipeInput)) {
                            List<String> ingredients = userManager.getUsersIngredientsName();
                            if (ingredients.isEmpty()) {
                                inOut.sendOutput("There are no items in your fridge");
                                break;
                            }
                            for (String ingredient : ingredients) {
                                List<Recipe> recipes = recipeManager.findRecipe(ingredient);
                                if (recipes.isEmpty()) {
                                    inOut.sendOutput(ingredient + ": Could not find any recipes.");
                                }
                                else {
                                    inOut.sendOutput(ingredient + ": " + recipes);
                                }
                            }
                        }
                        else {
                                inOut.sendOutput(recipeManager.findRecipe(recipeInput));
                            }
                        }
                        break;
                    case "Logout":{
                        inOut.sendOutput("Successfully logged out.");
                        logOut = false;
                        break;
                    }
                }
            }
            catch (IOException io) {
                inOut.sendOutput("Something went wrong, please try again.");
            }
        }
    }
  
    /**
     * @param inOut Allows communication with the user through receiving inputs and sending outputs
     * @return Returns an ArrayList containing a Username and Password based on the user's input
     */
    private String[] getDetails(SystemInOut inOut) {

        try {
            inOut.sendOutput("Enter User Name:");
            String username = inOut.getInput();
            inOut.sendOutput("Enter Password:");
            String password = inOut.getInput();
            return new String[]{username, password};
        } catch (IOException io) {
            inOut.sendOutput("Something went wrong. Please try again");
            return new String[]{};
        }
    }
}
