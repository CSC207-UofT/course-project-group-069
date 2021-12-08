package use_case_test;

import com.example.phase2.entity.Ingredient;
import com.example.phase2.entity.User;
import org.junit.*;
import com.example.phase2.entity.Recipe;
import com.example.phase2.use_case.RecipeFacade;
import com.example.phase2.controller.Presenter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for all methods in RecipeFacade
 */

public class RecipeFacadeTest {

    private Presenter p;
    private RecipeFacade recipefacade;
    private User user;


    @Before
    public void setUp() {
        p = new Presenter();
        recipefacade = new RecipeFacade(p);
        user = new User("daniel", "123");
        user.fridge.add(new Ingredient("meat",""));
        user.fridge.add(new Ingredient("pepper",""));
        user.fridge.add(new Ingredient("butter",""));
        recipefacade.update(user);
    }

    @After
    public void tearDown() {
    }

    /**
     * testgetRecipes is the test case for getRecipes
     */
    @Test
    public void testgetRecipes(){
        assertEquals(recipefacade.getRecipes("Steak").getRecipeName(),"Steak");
    }

    /**
     * testUpdate is the test case for Update
     */
    @Test
    public void testUpdate(){
        assertEquals(recipefacade.currentUser,user);
    }


    /**
     * testUpdate is the test case for findRecipe
     */
    @Test
    public void testfindRecipe(){
        recipefacade.findRecipe();
        assertEquals(p.getAvailableRecipes(),"Steak | ");

    }
}
