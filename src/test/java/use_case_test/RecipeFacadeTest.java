package use_case_test;

import com.example.phase2.entity.User;
import org.junit.*;
import com.example.phase2.entity.Recipe;
import com.example.phase2.use_case.RecipeFacade;
import com.example.phase2.controller.Presenter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for all methods in RecipeFacade
 */

public class RecipeFacadeTest {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * testsetRecipe is the test case for setRecipe
     */
    @Test
    public void testsetRecipe(){
        Presenter p = new Presenter();
        RecipeFacade recipefacade = new RecipeFacade(p);
        List<Recipe> recipes = new ArrayList<>();

        List<String> ingredients1 = new ArrayList<String>();
        ingredients1.add("apple");
        ingredients1.add("beef");
        ingredients1.add("chicken");
        ingredients1.add("leek");
        Recipe recipe1 = new Recipe("recipe1",ingredients1, "");

        List<String> ingredients2 = new ArrayList<String>();
        ingredients2.add("chicken");
        ingredients2.add("leek");
        Recipe recipe2 = new Recipe("recipe2",ingredients2, "");

        List<String> ingredients3 = new ArrayList<String>();
        ingredients3.add("chicken");
        Recipe recipe3 = new Recipe("recipe3",ingredients3, "");

        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipefacade.setRecipe(recipes);
        assertEquals(recipefacade.recipes,recipes);
    }
    /**
     * testgetRecipes is the test case for getRecipes
     */
    @Test
    public void testgetRecipes(){
        Presenter p = new Presenter();
        RecipeFacade recipefacade = new RecipeFacade(p);
        List<Recipe> recipes = new ArrayList<>();

        List<String> ingredients1 = new ArrayList<String>();
        ingredients1.add("apple");
        ingredients1.add("beef");
        ingredients1.add("chicken");
        ingredients1.add("leek");
        Recipe recipe1 = new Recipe("recipe1",ingredients1, "");

        List<String> ingredients2 = new ArrayList<String>();
        ingredients2.add("chicken");
        ingredients2.add("leek");
        Recipe recipe2 = new Recipe("recipe2",ingredients2, "");

        List<String> ingredients3 = new ArrayList<String>();
        ingredients3.add("chicken");
        Recipe recipe3 = new Recipe("recipe3",ingredients3, "");

        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipefacade.setRecipe(recipes);
        assertEquals(recipefacade.getRecipes("recipe3"),recipe3);
    }

    /**
     * testUpdate is the test case for Update
     */
    @Test
    public void testUpdate(){
        Presenter p = new Presenter();
        RecipeFacade recipefacade = new RecipeFacade(p);
        User user = new User("daniel", "123");
        recipefacade.update(user);
        assertEquals(recipefacade.currentUser,user);
    }
}
