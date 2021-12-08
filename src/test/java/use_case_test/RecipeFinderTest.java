package use_case_test;

import org.junit.*;
import com.example.phase2.entity.Recipe;
import com.example.phase2.use_case.RecipeFinder;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Tests for all methods in RecipeFinder
 */

public class RecipeFinderTest {

    private RecipeFinder recipefinder;
    private List<Recipe> recipes;
    private List<String> fridge;
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;

    @Before
    public void setUp() {
        recipefinder = new RecipeFinder();
        List<String> ingredients1 = new ArrayList<>();
        ingredients1.add("apple");
        ingredients1.add("beef");
        ingredients1.add("chicken");
        ingredients1.add("leek");
        recipe1 = new Recipe("recipe1",ingredients1, "");

        List<String> ingredients2 = new ArrayList<>();
        ingredients2.add("chicken");
        ingredients2.add("leek");
        recipe2 = new Recipe("recipe2",ingredients2, "");

        List<String> ingredients3 = new ArrayList<>();
        ingredients3.add("chicken");
        recipe3 = new Recipe("recipe3",ingredients3, "");
        recipes = new ArrayList<>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        fridge = new ArrayList<>();
        fridge.add("chicken");
        fridge.add("leek");
        fridge.add("beef");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test for Find method
     */

    @Test
    public void testFind(){
        assertTrue(recipefinder.Find(recipes, fridge).contains("recipe2 | recipe3"));
    }
    /**
     * Test for FindDetail method
     */
    @Test
    public void testFindDetail(){
        assertTrue(recipefinder.FindDetail(recipes, "recipe1").equalsIgnoreCase(recipe1.showDetail()));
    }
    /**
     * Test for getRecipe method
     */
    @Test
    public void testgetRecipe(){
        RecipeFinder recipefinder = new RecipeFinder();
        List<String> ingredients1 = new ArrayList<>();
        ingredients1.add("apple");
        ingredients1.add("beef");
        ingredients1.add("chicken");
        ingredients1.add("leek");
        Recipe recipe1 = new Recipe("recipe1",ingredients1, "");

        List<String> ingredients2 = new ArrayList<>();
        ingredients2.add("chicken");
        ingredients2.add("leek");
        Recipe recipe2 = new Recipe("recipe2",ingredients2, "");

        List<String> ingredients3 = new ArrayList<>();
        ingredients3.add("chicken");
        Recipe recipe3 = new Recipe("recipe3",ingredients3, "");

        List<Recipe> recipes = new ArrayList<>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        List<String> fridge = new ArrayList<>();
        fridge.add("chicken");
        fridge.add("leek");
        fridge.add("beef");
        assertTrue(recipefinder.getRecipes(recipes, "recipe1").equals(recipe1));
    }

    }
