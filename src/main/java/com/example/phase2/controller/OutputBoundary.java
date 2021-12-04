package com.example.phase2.controller;

import java.util.List;

public interface OutputBoundary {

    void updateLoginStatus();

    void updateFridge(List<String> fridge);

    void updateAvailableRecipes(List<String> Recipes);

    void updateRecipeDirection(String direction);

}
