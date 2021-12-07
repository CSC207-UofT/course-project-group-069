package com.example.phase2.entity;

import java.io.Serializable;

/**
 * Represents an ingredient in the system
 */

public class Ingredient implements Serializable {

    private String ingredientName;
    private String foodType;

    /**
     * Constructs an instance of Ingredient based on Strings of information
     * @param IngredientName name of the ingredient
     * @param FoodType type of the food
     */
    public Ingredient(String IngredientName, String FoodType) {
        ingredientName = IngredientName;
        foodType = FoodType;
    }

    /**
     * ingredientName getter
     * @return ingredientName String
     */
    public String getIngredientName() {
        return ingredientName;
    }

    /**
     * foodType getter
     * @return foodType String
     */
    public String getFoodType() {
        return foodType;
    }

    /**
     * storingDuration getter
     * @return ingredientName String
     */

    public String toString() {
        return ingredientName + ", " + foodType;

    }

}
