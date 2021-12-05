import org.junit.*;
import com.example.phase2.entity.Recipe;
import com.example.phase2.use_case.RecipeFacade;


import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeFacadeTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRecipeFacade(){

       /* List<String> ingredients1 = new ArrayList<String>();
        ingredients1.add("apple");
        ingredients1.add("beef");
        ingredients1.add("chicken");
        ingredients1.add("leek");
        Recipe recipe1 = new Recipe("recipe1",ingredients1,"");

        List<String> ingredients2 = new ArrayList<String>();
        ingredients2.add("chicken");
        ingredients2.add("leek");
        Recipe recipe2 = new Recipe("recipe2",ingredients2,"");

        List<String> ingredients3 = new ArrayList<String>();
        ingredients3.add("chicken");
        Recipe recipe3 = new Recipe("recipe3",ingredients3,"");



        RecipeFacade recipefacade = new RecipeFacade();

        recipefacade.addRecipe(recipe1);
        recipefacade.addRecipe(recipe2);
        recipefacade.addRecipe(recipe3);
        System.out.println(recipefacade.printSimple());

        List<String> fridge = new ArrayList<String>();
        fridge.add("chicken");
        fridge.add("leek");

        List<Recipe> res = recipefacade.findRecipe(fridge);
        assertEquals(res.contains(recipe2),true);
        assertEquals(res.contains(recipe3),true);
        assertEquals(res.contains(recipe1),false);

        RecipeFacade result = new RecipeFacade();
        result.setRecipe(res);
        assertEquals(result.printSimple().contains("recipe1"),false);
        assertEquals(result.printSimple().contains("recipe2"),true);
        assertEquals(result.printSimple().contains("recipe3"),true);*/



    }


}
