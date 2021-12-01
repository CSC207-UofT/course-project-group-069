package meals.entity;

import java.io.Serializable;

/**
 * Represents an ingredient in the system
 */

public class Ingredient implements Serializable {

    private String ingredientName;
    private String foodType;
    private String storingDuration;

    /**
     * Constructs an instance of Ingredient based on Strings of information
     * @param IngredientName name of the ingredient
     * @param FoodType type of the food
     * @param StoringDuration the duration the ingredient can be stored
     */
    public Ingredient(String IngredientName, String FoodType, String StoringDuration) {
        ingredientName = IngredientName;
        foodType = FoodType;
        storingDuration = StoringDuration;
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
    public String getStoringDuration() {
        return storingDuration;
    }

    /** String representation of the ingredient
     * @return the ingredient name, food type, and storing duration
     * separated by a comma
     */
    public String toString() {
        return ingredientName + ", " + foodType + " ," + storingDuration;

    }

}
