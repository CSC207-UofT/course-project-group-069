import org.junit.*;
import com.example.phase2.entity.Recipe;
import com.example.phase2.use_case.RecipeBook;


import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeBookTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testsetRecipes(){
        List<String> ingredients1 = new ArrayList<String>();
        ingredients1.add("apple");
        ingredients1.add("beef");
        ingredients1.add("chicken");
        ingredients1.add("leek");
        Recipe recipe1 = new Recipe("recipe1",ingredients1,"");

        List<String> ingredients2 = new ArrayList<String>();
        ingredients2.add("chicken");
        ingredients2.add("leek");
        Recipe recipe2 = new Recipe("recipe2",ingredients2,"");

        List<String> ingredients3 = new ArrayList<String>();
        ingredients3.add("chicken");
        Recipe recipe3 = new Recipe("recipe3",ingredients3,"");

        List<Recipe> recipes = new ArrayList<Recipe>();
        RecipeBook recipebook = new RecipeBook();
        recipebook.addRecipe(recipes, recipe1);
        recipebook.addRecipe(recipes, recipe2);
        recipebook.addRecipe(recipes, recipe3);
        assertEquals(recipes.contains(recipe1),true);
        assertEquals(recipes.contains(recipe2),true);
        assertEquals(recipes.contains(recipe3),true);

        recipebook.removeRecipe(recipes,recipe3);
        assertEquals(recipes.contains(recipe3),false);


        List<Recipe> recipes2 = new ArrayList<Recipe>();
        recipebook.addRecipe(recipes2,recipe3);
        recipebook.setRecipes(recipes,recipes2);
        assertEquals(recipes.contains(recipe3),true);

    }




}
