package entity_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import com.example.phase2.entity.Recipe;
import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests for all methods in Recipe
 */
public class RecipeTest {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    /**
     * Test for getRecipeName method
     */
    @Test
    public void testgetRecipeName(){
        List<String> ingredients = new ArrayList<String>();
        ingredients.add("egg");
        ingredients.add("chicken");
        Recipe recipe = new Recipe("recipe", ingredients, "","","","");
        assertEquals(recipe.getRecipeName().equalsIgnoreCase("recipe"),true);
    }
    /**
     * Test for getIngredients method
     */
    @Test
    public void testgetIngredients(){
        List<String> ingredients = new ArrayList<String>();
        ingredients.add("egg");
        ingredients.add("chicken");
        Recipe recipe = new Recipe("recipe", ingredients, "","","","");
        assertEquals(recipe.getIngredients().equals(ingredients),true);
    }

    /**
     * Test for showSimple method
     */
    @Test
    public void testshowSimple(){
        List<String> ingredients = new ArrayList<String>();
        ingredients.add("egg");
        ingredients.add("chicken");
        Recipe recipe = new Recipe("recipe", ingredients, "","","","");
        assertEquals(recipe.showSimple().contains("Recipe: recipe\nIngredients: egg, chicken"),true);
    }
    /**
     * Test for showDetail method
     */
    @Test
    public void testshowDetail(){
        List<String> ingredients = new ArrayList<String>();
        ingredients.add("egg");
        ingredients.add("chicken");
        Recipe recipe = new Recipe("recipe", ingredients, "abc","","","");
        assertEquals(recipe.showDetail().contains("Direction:"),true);
        assertEquals(recipe.showSimple().contains("Direction:"),false);
    }




}
