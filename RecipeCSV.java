package com.example.phase2.gateways;

import com.example.phase2.entity.Recipe;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RecipeCSV implements RW {

    private Scanner scanner;
    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<Recipe>();
        try {
            scanner = new Scanner(new File("recipes - Sheet1.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.useDelimiter("[,\n]");

        while(scanner.hasNext()) {
            String name = scanner.next();
            String ingred = scanner.next();
            String prep = scanner.next();
            String dir = scanner.next();
            String difficulty = scanner.next();
            String  cuisine = scanner.next();

            List<String> ingredients = new ArrayList<String>(Arrays.asList(ingred.split("|")));


            Recipe recipe = new Recipe(name, ingredients, prep, dir, difficulty, cuisine);
            recipes.add(recipe);
        }
        return recipes;
    }

    @Override
    public void saveRecipe(Recipe recipe) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("recipes - Sheet1.csv", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        String ingred = String.join("|", recipe.getRecipeIngredients());
        pw.println(recipe.getRecipeName() + "," + ingred + "," + recipe.getRecipeDuration() + "," + recipe.getRecipeDirections() + "," + recipe.getRecipeDifficulty() + "," + recipe.getRecipeCuisine());
        pw.flush();
        pw.close();
    }
}
