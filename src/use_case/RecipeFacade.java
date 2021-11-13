package use_case;
import entity.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeFacade {
    private List<Recipe> recipes;
    private final RecipeFinder recipefinder;
    private final RecipePrinter recipeprinter;
    private final RecipeBook recipebook;

    public RecipeFacade() {
        this.recipes = new ArrayList<Recipe>();
        this.recipefinder = new RecipeFinder();
        this.recipeprinter = new RecipePrinter();
        this.recipebook = new RecipeBook();
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

    public List<Recipe> findRecipe(String ingredient){
        return recipefinder.Find(recipes, ingredient);
    }
    public String printRecipes() {
        return recipeprinter.print(recipes);
    }
}
