package entity_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.example.phase2.entity.Ingredient;
import static org.junit.Assert.*;

/**
 * Tests for all methods in Ingredient
 */
public class IngredientTest {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    /**
     * Test for getIngredientName method
     */
    @Test
    public void testgetIngredientName(){
        Ingredient ingredient = new Ingredient("chicken","meat");
        assertTrue(ingredient.getIngredientName().equalsIgnoreCase("chicken"));
    }
    /**
     * Test for toString method
     */
    @Test
    public void testtoString(){
        Ingredient ingredient = new Ingredient("chicken","meat");
        assertEquals(ingredient.toString(),"chicken" + ", " + "meat");
    }



}
