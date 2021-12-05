package com.example.phase2.gateways;

import com.example.phase2.entity.Recipe;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeCSV implements RW {

    @Override
    public List<Recipe> getRecipes() throws IOException {
        List<Recipe> recipes = new ArrayList<Recipe>();
        BufferedReader br = null;
        String l = "";

        try {
            br = new BufferedReader(new FileReader("recipes.csv"));
            while((l = br.readLine()) != null) {
                String[] row = l.split(",");
                String name = row[0];
                String ingred = row[1];
                String prep = row[2];
                String dir = row[3];
                String difficulty = row[4];
                String cuisine = row[5];

                List<String> ingredients = new ArrayList<String>(Arrays.asList(ingred.split("|")));
                recipes.add(new Recipe(name, ingredients, prep, dir, difficulty, cuisine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert br != null;
                br.close();
            } catch (IOException ignored) {

            }
        }
        return recipes;
    }

    @Override
    public void saveRecipe(Recipe recipe) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("recipes.csv", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        String ingred = String.join("|", recipe.getIngredients());
        pw.println(recipe.getRecipeName() + "," + ingred + "," + recipe.getDuration() + "," + recipe.getDirections() + ","
                + recipe.getDifficulty() + "," + recipe.getCuisineType());
        pw.flush();
        pw.close();
    }
}
