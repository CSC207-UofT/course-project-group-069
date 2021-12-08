package use_case_test;

import com.example.phase2.entity.Recipe;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.example.phase2.use_case.RecipePrinter;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for all methods in RecipePrinter
 */

public class RecipePrinterTest {

    private RecipePrinter recipeprinter;
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;
    private List<Recipe> recipes;

    @Before
    public void setUp() {
        recipeprinter = new RecipePrinter();

        List<String> ingredients1 = new ArrayList<String>();
        ingredients1.add("apple");
        ingredients1.add("beef");
        ingredients1.add("chicken");
        ingredients1.add("leek");
        recipe1 = new Recipe("recipe1",ingredients1, "");

        List<String> ingredients2 = new ArrayList<String>();
        ingredients2.add("chicken");
        ingredients2.add("leek");
        recipe2 = new Recipe("recipe2",ingredients2, "");

        List<String> ingredients3 = new ArrayList<String>();
        ingredients3.add("chicken");
        recipe3 = new Recipe("recipe3",ingredients3, "");

        recipes = new ArrayList<>();
    }

    @After
    public void tearDown() {
    }

    /**
     * testprintSimple is the test case for printSimple
     */
    @Test
    public void testprintSimple(){
        assertTrue(recipeprinter.printSimple(recipes).equalsIgnoreCase(""));
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        assertEquals("recipe1 | recipe2 | recipe3 | ", recipeprinter.printSimple(recipes));
    }

    /**
     * testprintDetail is the test case for printDetail
     */
    @Test
    public void testprintDetail(){
        assertEquals(recipeprinter.printDetail(recipes).equalsIgnoreCase(""), true);
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);

        assertEquals(recipeprinter.printDetail(recipes).contains(recipe1.showDetail()), true);
        assertEquals(recipeprinter.printDetail(recipes).contains(recipe2.showDetail()), true);
        assertEquals(recipeprinter.printDetail(recipes).contains(recipe3.showDetail()), true);
    }
}
