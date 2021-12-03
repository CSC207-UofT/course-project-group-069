
import com.example.phase2.entity.User;
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
    public void testRecipeBook(){
        List<String> b = new ArrayList<String>();
        b.add("b");
        b.add("c");
        Recipe a = new Recipe("a",b, "1", "a", "2", "a");

        List<String> n = new ArrayList<String>();
        n.add("c");
        n.add("n");
        Recipe x = new Recipe("x",n, "1", "x", "2", "x");

        List<String> r = new ArrayList<String>();
        r.add("p");
        r.add("q");
        Recipe z = new Recipe("z",r, "1", "z", "2", "z");

        RecipeFacade recipefacade = new RecipeFacade();

        recipefacade.addRecipe(a);
        recipefacade.addRecipe(x);
        recipefacade.addRecipe(z);

        List<Recipe> res = recipefacade.findRecipe ("c");
        RecipeFacade rf2 = new RecipeFacade();
        rf2.setRecipe(res);
        assertEquals(res.contains(a), true);
        assertEquals(res.contains(x), true);
        assertEquals(res.contains(z), false);
        rf2.removeRecipe(x);
        assertTrue(rf2.printRecipes().contains("a"));


    }


}
