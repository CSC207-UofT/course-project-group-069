package com.example.phase2.use_case;
import com.example.phase2.controller.OutputBoundary;
import com.example.phase2.entity.Ingredient;
import com.example.phase2.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserShoppingListManager implements CurrentUserObserver, IngredientSetter {

    private User currentUser;
    private OutputBoundary outputBoundary;

    public UserShoppingListManager(OutputBoundary p) {
        outputBoundary = p;
    }

    public void addIngredient(String ingredientName, String foodType) {
        String ingredient_LL = ingredientName.toLowerCase();
        Ingredient ingredient = new Ingredient(ingredient_LL, foodType);
        currentUser.shoppingList.add(ingredient);
    }

    public void removeIngredient(String ingredientName) {

        for (Ingredient ingredient : currentUser.shoppingList) {
            if (ingredient.getIngredientName().equalsIgnoreCase(ingredientName)) {
                currentUser.shoppingList.remove(ingredient);
                outputBoundary.updateContainStatus();
                break;
            }
        }
    }

    public void getAllIngredients(){
        List<String> items = new ArrayList<>();

        for (Ingredient ingredient : currentUser.shoppingList) {
            items.add(ingredient.getIngredientName());
        }


        outputBoundary.updateShoppingList(items);
    }

    public void update(User user) {
        currentUser = user;
    }
}
