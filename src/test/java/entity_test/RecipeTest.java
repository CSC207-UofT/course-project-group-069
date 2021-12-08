package entity_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.example.phase2.entity.Recipe;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for all methods in Recipe
 */
public class RecipeTest {

    private List<String> ingredients;
    private Recipe recipe;

    @Before
    public void setUp() {
        ingredients = new ArrayList<String>();
        ingredients.add("egg");
        ingredients.add("chicken");
        recipe = new Recipe("recipe", ingredients, "");
    }

    @After
    public void tearDown() {
    }
    /**
     * Test for getRecipeName method
     */
    @Test
    public void testgetRecipeName(){
        assertTrue(recipe.getRecipeName().equalsIgnoreCase("recipe"));
    }
    /**
     * Test for getIngredients method
     */
    @Test
    public void testgetIngredients(){
        assertEquals(recipe.getIngredients(), ingredients);
    }

    /**
     * Test for showSimple method
     */
    @Test
    public void testshowSimple(){
        assertTrue(recipe.showSimple().contains("Recipe: recipe\nIngredients: egg, chicken"));
    }
    /**
     * Test for showDetail method
     */
    @Test
    public void testshowDetail(){
        Recipe recipe = new Recipe("recipe", ingredients, "");
        assertTrue(recipe.showDetail().contains("Direction:"));
        assertFalse(recipe.showSimple().contains("Direction:"));
    }




}
