package com.example.phase2.use_case;

public interface IngredientSetter {

    void addItem(String ingredientName, String foodType);

    void removeItem(String ingredientName);
}
