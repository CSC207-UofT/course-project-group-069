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
            br = new BufferedReader(new FileReader("recipes - Sheet1.csv"));
            while((l = br.readLine()) != null) {
                String[] row = l.split(",");
                String name = row[0];
                String ingred = row[1];
                String dir = row[2];

                String vertBar = "\\|";
                List<String> ingredients = new ArrayList<String>(Arrays.asList(ingred.split(vertBar)));
                recipes.add(new Recipe(name, ingredients, dir));
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

}
