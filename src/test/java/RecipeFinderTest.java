import com.example.phase2.entity.User;
import org.junit.*;
import com.example.phase2.entity.Recipe;
import com.example.phase2.use_case.RecipeFinder;


import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;




//public class RecipeFinderTest {
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void testFind(){
//        RecipeFinder recipefinder = new RecipeFinder();
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
//        recipes.add(recipe1);
//        recipes.add(recipe2);
//        recipes.add(recipe3);
//        List<String> fridge = new ArrayList<String>();
//        fridge.add("chicken");
//        fridge.add("leek");
//        fridge.add("beef");
//        List<Recipe> res = recipefinder.Find(recipes, fridge);
//        assertEquals(res.contains(recipe2), true);
//        assertEquals(res.contains(recipe3), true);
//        assertEquals(res.contains(recipe1), false);
//
//
//    }
//}
