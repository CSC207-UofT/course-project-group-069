package com.example.phase2.use_case;
import com.example.phase2.entity.Recipe;

import java.util.Arrays;
import java.util.List;

public class RecipeFacade {
    private List<Recipe> recipes;
    private final RecipeFinder recipefinder;
    private final RecipePrinter recipeprinter;
    private final RecipeBook recipebook;

    public RecipeFacade() {
        this.recipefinder = new RecipeFinder();
        this.recipeprinter = new RecipePrinter();
        this.recipebook = new RecipeBook();

        String[] lst1 = {"Basmati rice", "Onion", "Tomato", "Black Peppercorn", "Garlic", "Green Chilly",
                "Cumin Powder", "Red Chilli powder"};
        Recipe r1 = new Recipe("Mexican Fried Rice", Arrays.asList(lst1));

        String[] lst2 = {"All Purpose Flour", "Baking powder", "Baking soda", "Salt", "Cinnamon Powder",
                "Sugar", "Oil", "Eggs", "Apples", "Almonds"};
        Recipe r2 = new Recipe("Apple Almond Cake", Arrays.asList(lst2));

        String[] lst3 = {"Black beans", "Onion", "Tomato", "Cheddar cheese", "Cumin powder", "Black pepper powder",
                "Salt", "Extra Virgin Olive Oil", "Tortillas"};
        Recipe r3 = new Recipe("Cheese and Black Beans Quesadillas", Arrays.asList(lst3));

        String[] lst4 = {"Chicken breast", "Coriander Powder", "Red Chilli powder", "Cumin powder",
                "Black pepper powder", "Turmeric powder", "Extra Virgin Olive Oil"};
        Recipe r4 = new Recipe("Chicken Shawarma", Arrays.asList(lst4));

        String[] lst5 = {"Prawns", "Garlic", "Onion", "Spring Onion Greens", "Coriander Leaves",
                "Red Chilli powder", "Turmeric powder", "Extra Virgin Olive Oil", "Salt"};
        Recipe r5 = new Recipe("Sauteed Spicy Prawns", Arrays.asList(lst5));

        Recipe[] main = {r1, r2, r3, r4, r5};
        this.recipes = Arrays.asList(main);
    }

    public void setRecipe(List<Recipe> recipes2){
        recipebook.setRecipes(recipes, recipes2);
    }
    public void addRecipe(Recipe recipe){
        recipebook.addRecipe(recipes,recipe);
    }

    public void removeRecipe(Recipe recipe){
        recipebook.removeRecipe(recipes,recipe);
    }

    public List<Recipe> findRecipe(List<String> fridge){
        return recipefinder.Find(recipes, fridge);
    }
    public String printRecipes() {
        return recipeprinter.print(recipes);
    }
}
