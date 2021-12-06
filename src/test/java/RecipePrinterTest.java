import com.example.phase2.entity.Recipe;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import com.example.phase2.use_case.RecipePrinter;
import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//public class RecipePrinterTest {
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void testprint(){
//        RecipePrinter recipeprinter = new RecipePrinter();
//
//        List<String> ingredients1 = new ArrayList<String>();
//        ingredients1.add("apple");
//        ingredients1.add("beef");
//        ingredients1.add("chicken");
//        ingredients1.add("leek");
//        Recipe recipe1 = new Recipe("recipe1",ingredients1,"");
//
//        List<String> ingredients2 = new ArrayList<String>();
//        ingredients2.add("chicken");
//        ingredients2.add("leek");
//        Recipe recipe2 = new Recipe("recipe2",ingredients2,"");
//
//        List<String> ingredients3 = new ArrayList<String>();
//        ingredients3.add("chicken");
//        Recipe recipe3 = new Recipe("recipe3",ingredients3,"");
//
//        List<Recipe> recipes = new ArrayList<Recipe>();
//
//        assertEquals(recipeprinter.printSimple(recipes).equalsIgnoreCase(""), true);
//        recipes.add(recipe1);
//        recipes.add(recipe2);
//        recipes.add(recipe3);
//
//        assertEquals(recipeprinter.printSimple(recipes).contains(recipe1.showSimple()), true);
//        assertEquals(recipeprinter.printSimple(recipes).contains(recipe2.showSimple()), true);
//        assertEquals(recipeprinter.printSimple(recipes).contains(recipe3.showSimple()), true);
//
//
//
//    }
//}
