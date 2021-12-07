//package use_case_test;
//
//import org.junit.*;
//import com.example.phase2.entity.Recipe;
//import com.example.phase2.use_case.RecipeBook;
//
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Tests for all methods in Recipe Book
// */
//
//public class RecipeBookTest {
//
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * test for setRecipes
//     */
//    @Test
//    public void testsetRecipes(){
//        List<String> ingredients1 = new ArrayList<String>();
//        ingredients1.add("apple");
//        ingredients1.add("beef");
//        ingredients1.add("chicken");
//        ingredients1.add("leek");
//        Recipe recipe1 = new Recipe("recipe1",ingredients1, "");
//
//        List<String> ingredients2 = new ArrayList<String>();
//        ingredients2.add("chicken");
//        ingredients2.add("leek");
//        Recipe recipe2 = new Recipe("recipe2",ingredients2, "");
//
//        List<String> ingredients3 = new ArrayList<String>();
//        ingredients3.add("chicken");
//        Recipe recipe3 = new Recipe("recipe3",ingredients3, "");
//
//        List<Recipe> recipes1 = new ArrayList<Recipe>();
//        RecipeBook recipebook = new RecipeBook();
//        recipebook.addRecipe(recipes1, recipe1);
//        recipebook.addRecipe(recipes1, recipe2);
//        recipebook.addRecipe(recipes1, recipe3);
//
//        List<Recipe> recipes2 = new ArrayList<Recipe>();
//        recipebook.addRecipe(recipes2, recipe1);
//        recipebook.addRecipe(recipes2, recipe2);
//        recipebook.setRecipes(recipes1, recipes2);
//
//
//        assertEquals(recipes1.contains(recipe1),true);
//        assertEquals(recipes1.contains(recipe2),true);
//        assertEquals(recipes1.contains(recipe3),false);
//
//
//    }
//
//    /**
//     * test for addRecipes
//     */
//    @Test
//    public void testaddRecipes(){
//        List<String> ingredients1 = new ArrayList<String>();
//        ingredients1.add("apple");
//        ingredients1.add("beef");
//        ingredients1.add("chicken");
//        ingredients1.add("leek");
//        Recipe recipe1 = new Recipe("recipe1",ingredients1, "");
//
//        List<Recipe> recipes1 = new ArrayList<Recipe>();
//        RecipeBook recipebook = new RecipeBook();
//        recipebook.addRecipe(recipes1, recipe1);
//        assertTrue(recipes1.contains(recipe1));
//
//
//    }
//
//    /**
//     * test for removeRecipes
//     */
//    @Test
//    public void testremoveRecipes(){
//        List<String> ingredients1 = new ArrayList<String>();
//        ingredients1.add("apple");
//        ingredients1.add("beef");
//        ingredients1.add("chicken");
//        ingredients1.add("leek");
//        Recipe recipe1 = new Recipe("recipe1",ingredients1, "");
//
//        List<Recipe> recipes1 = new ArrayList<Recipe>();
//        RecipeBook recipebook = new RecipeBook();
//        recipebook.addRecipe(recipes1, recipe1);
//        recipebook.removeRecipe(recipes1,recipe1);
//        assertFalse(recipes1.contains(recipe1));
//
//    }
//
//
//
//
//}
