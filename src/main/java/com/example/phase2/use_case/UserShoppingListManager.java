package com.example.phase2.use_case;
import com.example.phase2.controller.OutputBoundary;
import com.example.phase2.entity.Ingredient;
import com.example.phase2.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that manages the shopping list of the user that is logged in.
 */
public class UserShoppingListManager implements CurrentUserObserver, IngredientSetter {

    private User currentUser;
    private final OutputBoundary outputBoundary;

    public UserShoppingListManager(OutputBoundary p) {
        outputBoundary = p;
    }

    /**
     * Adds ingredients to the user's shopping list when given their name and type.
     * @param ingredientName name of the ingredient to be added to the shopping list.
     * @param foodType type of the ingredient to be added to the shopping list.
     */
    public void addItem(String ingredientName, String foodType) {

        if (ingredientName.contains(",")){ //Checks if there are multiple ingredients to add
            String[] items = ingredientName.split(","); //Making an array of all ingredients

            //Add all ingredients to a temporary list
            List<Ingredient> ingTemp = new ArrayList<>();
            for (String s: items){
                String item = s.trim();
                if (!item.isEmpty()){ //Doesn't add empty ingredients to the shopping list
                    String itemLL = item.toLowerCase();
                    Ingredient ing = new Ingredient(itemLL, foodType);
                    ingTemp.add(ing);
                }
            }
            currentUser.addToShoppingList(ingTemp);
        }
        else {
            String ingredient_LL = ingredientName.toLowerCase();
            if (!ingredient_LL.isEmpty()) {
                Ingredient ingredient = new Ingredient(ingredient_LL, foodType);
                currentUser.addToShoppingList(ingredient);
            }
        }
    }

    /**
     * Removes an ingredient from the user's shopping list when given its name.
     * @param ingredientName name of the ingredient to be removed from the user's shopping list.
     */
    public void removeItem(String ingredientName) {

        outputBoundary.updateRemoveStatus(false);

        for (Ingredient ingredient : currentUser.getShoppingList()) {
            if (ingredient.getIngredientName().equalsIgnoreCase(ingredientName)) {
                currentUser.removeFromShoppingList(ingredient);

                //This makes removeStatus true, signifying that the ingredient with ingredientName
                //was in the user's shopping list and has been removed successfully.
                outputBoundary.updateRemoveStatus(true);
                break;
            }
        }
    }

    /**
     * Gets all the ingredients present in the user's shopping list and updates the shopping list
     * in the outputBoundary accordingly.
     */
    public void getAllIngredients(){
        List<String> items = new ArrayList<>();

        for (Ingredient ingredient : currentUser.getShoppingList()) {
            items.add(ingredient.getIngredientName());
        }
        outputBoundary.updateShoppingList(items);
    }

    /**
     * Sets the currentUser as the user who is currently logged in.
     * @param user User who is currently logged in.
     */
    public void update(User user) {
        currentUser = user;
    }
}
