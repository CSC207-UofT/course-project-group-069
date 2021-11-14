package controller;

//import com.sun.tools.javac.comp.Todo;
import ui.SystemInOut;
import use_case.RecipeFacade;
import use_case.UserFridgeManager;
import use_case.UserManagerFacade;


import java.io.IOException;
import java.util.ArrayList;
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
        boolean logOut = true;
        while (checker) {
            inOut.sendOutput("Please type \"Create Account\" if you are new, " +
                    "\"Login\" if you already have an account, or \"Quit\"");

            try {
                switch (inOut.getInput()) {
                    case "Create Account": { //Create a helper to make this look better
                        String[] details = getDetails(inOut);
                        userManager.createUser(details[0], details[1]);
                        checker = false;
                        break;
                    }
                    case "Login": {
                        String[] details2 = getDetails(inOut);
                        checker = !(userManager.login(details2[0], details2[1]));
                        if (checker) {
                            inOut.sendOutput("Incorrect Username or Password");
                        }
                        break;
                    }
                    case "Quit": {
                        inOut.sendOutput("Quit Successfully");
                        logOut = false;
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
        while (logOut) {
            inOut.sendOutput("If you'd like to add an ingredient to your fridge, please type \"Add\" \n" +
                    "If you would like to get a recipe, please type \"Recipe\" \nOr if wish to view your" +
                    " fridge, please type \"Fridge\" \nTo logout, please type \"Logout\"" );
            try {
                switch (inOut.getInput()) {
                    case "Add":{
                        inOut.sendOutput("What ingredient would you like to add?");
                        String name = inOut.getInput();
                        inOut.sendOutput("What food type is it?");
                        String foodType = inOut.getInput();
                        inOut.sendOutput("What is it's estimated storing time?");
                        String duration = inOut.getInput();
                        userManager.addIngredient(name, foodType, duration);
                        inOut.sendOutput("Successfully stored!\n\n");
                        break;
                    }
                    case "Fridge":{
                        inOut.sendOutput(userManager.getUsersIngredientsName());
                        break;
                    }
                    case "Recipe":{
                        inOut.sendOutput("If you'd like to get a recipe for a specific ingredient, " +
                                "please type your ingredient.\nOr if you'd like to get a list of ingredients that " +
                                "you can cook from your fridge, please type \"List\"");
                        String recipeInput = inOut.getInput();
                        switch (recipeInput) {
                            case "List":{
                                List<String> ingredients = userManager.getUsersIngredientsName();
                                for (String ingredient : ingredients) {
                                    inOut.sendOutput(recipeManager.findRecipe(ingredient));
                                }
                                break;
                            }
                            default: {
                                inOut.sendOutput("Here is the list from specifided: " + recipeInput);
                                if (userManager.getUsersIngredientsName().contains(recipeInput)){
                                    inOut.sendOutput(recipeManager.findRecipe(recipeInput));
                                }else{
                                    inOut.sendOutput(recipeInput + " doesn't exist in your fridge.");
                                }
                                break;
                            }
                        }
                        break;
                    }
                    case "Logout":{
                        System.out.print("Successfully logged out.");
                        logOut = false;
                        break;
                    }
                }

            } catch (IOException io) {
                inOut.sendOutput("Something went wrong, please try again."); //exception for bad login
            }
        }


        //Continue here
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
//        try {
//            String input = inOut.getInput();
//            if (input.equals("login")) {
//                inOut.sendOutput("Please enter user name");
//                String inputUserName = inOut.getInput();
//                inOut.sendOutput("Please enter passcode");
//                String inputPassCode = inOut.getInput();
//
//                if (userManager.login(inputUserName, inputPassCode)) {
//                    inOut.sendOutput("Type 'groceries' to input groceries or type 'recipe' to find a recipe");
//                    String inputGroceries = inOut.getInput();
//                    if (inputGroceries.equals("groceries")) {
//                        inOut.sendOutput("Please input ingredient name");
//                        String ingredientName = inOut.getInput();
//                        inOut.sendOutput("Please input ingredient type");
//                        String ingredientType = inOut.getInput();
//                        inOut.sendOutput("Please input ingredient storing duration");
//                        String ingredientDuration = inOut.getInput();
//                        userManager.addIngredient(ingredientName, ingredientType, ingredientDuration);
//                        inOut.sendOutput("Item stored");
//                    }
//                }
//            }
//
//        } catch (IOException e) {
//            inOut.sendOutput("Something went wrong");
//        }
