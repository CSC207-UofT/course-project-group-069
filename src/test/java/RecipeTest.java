import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import com.example.phase2.entity.Recipe;
import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeTest {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testgetRecipeName(){
        List<String> ingredients = new ArrayList<String>();
        ingredients.add("egg");
        ingredients.add("chicken");
        Recipe recipe = new Recipe("recipe", ingredients, "");
        assertEquals(recipe.getRecipeName().equalsIgnoreCase("recipe"),true);
    }

    @Test
    public void testgetIngredients(){
        List<String> ingredients = new ArrayList<String>();
        ingredients.add("egg");
        ingredients.add("chicken");
        Recipe recipe = new Recipe("recipe", ingredients, "");
        assertEquals(recipe.getIngredients().equals(ingredients),true);
    }


    @Test
    public void testshowSimple(){
        List<String> ingredients = new ArrayList<String>();
        ingredients.add("egg");
        ingredients.add("chicken");
        Recipe recipe = new Recipe("recipe", ingredients, "");
        assertEquals(recipe.showSimple().contains("Recipe: recipe\ningredients: egg, chicken"),true);
    }

    @Test
    public void testshowDetail(){
        List<String> ingredients = new ArrayList<String>();
        ingredients.add("egg");
        ingredients.add("chicken");
        Recipe recipe = new Recipe("recipe", ingredients, "abc");
        assertEquals(recipe.showDetail().contains("Direction: abc"),true);
        assertEquals(recipe.showSimple().contains("Direction: abc"),false);
    }




}
