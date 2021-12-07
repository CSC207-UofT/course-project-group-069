package use_case_test;

import com.example.phase2.controller.Presenter;
import com.example.phase2.use_case.RecipeFacade;
import com.example.phase2.use_case.UserFridgeManager;
import com.example.phase2.use_case.UserManageLoginAndNewUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FridgeManagerTest {

    private Presenter p;
    private RecipeFacade recipeManager;
    private UserManageLoginAndNewUser userManager;
    private UserFridgeManager fridge;

    /**
     * As many methods in UserFridgeManager requires a user to login first, the following set up is necessary.
     */
    @Before
    public void setUp() {
        p = new Presenter();
        recipeManager = new RecipeFacade(p);
        fridge = new UserFridgeManager(p);
        userManager = new UserManageLoginAndNewUser(fridge, recipeManager, p);
        userManager.login("default", "123");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test add ingredient successfully
     */
    @Test
    public void testAddIngredient(){
        fridge.addIngredient("Potato", "Vegetable");
        fridge.getUsersIngredientsName();
        assertEquals(p.getFridge(),"potato | ");
    }

    /**
     * Test adding the wrong ingredient
     */
    @Test
    public void testAddWrongIngredient(){
        fridge.addIngredient("Tomato", "Vegetable");
        fridge.getUsersIngredientsName();
        assertFalse(p.getFridge()=="potato | ");
    }

    /**
     * Test adding multiple ingredient, and test getUserIngredientName
     */
    @Test
    public void testAddMultipleIngredientAndGetUserIngName() {
        fridge.addIngredient("Tomato", "Vegetable");
        fridge.addIngredient("Potato", "Vegetable");
        fridge.addIngredient("Lettuce", "Vegetable");
        fridge.addIngredient("Meat", "Vegetable");
        fridge.getUsersIngredientsName();
        assertEquals(p.getFridge(), "tomato | potato | lettuce | meat | ");
    }

    /**
     * Test cook method
     */
    @Test
    public void testCook(){
        fridge.addIngredient("Ripe Bananas", "Fruit");
        fridge.addIngredient("Honey", "Fruit");
        fridge.addIngredient("White Chocolate", "Fruit");
        fridge.getUsersIngredientsName();
        assertEquals(p.getFridge(), "ripe bananas | honey | white chocolate | ");
        fridge.Cooked("banana ice cream", recipeManager);
        fridge.getUsersIngredientsName();
        assertEquals(p.getFridge(), "Empty Fridge");
    }

    /**
     * Test cook method with a different recipe
     */
    @Test
    public void testCookWithDifferentRecipe(){
        fridge.addIngredient("Meat", "meat");
        fridge.addIngredient("butter", "butter");
        fridge.addIngredient("pepper", "pepper");
        fridge.getUsersIngredientsName();
        assertEquals(p.getFridge(), "meat | butter | pepper | ");
        fridge.Cooked("steak", recipeManager);
        fridge.getUsersIngredientsName();
        assertEquals(p.getFridge(), "Empty Fridge");
    }

    /**
     * Test cook method with a wrong recipe
     */
    @Test
    public void testCookWithWrongRecipe(){
        fridge.addIngredient("Meat", "meat");
        fridge.addIngredient("butter", "butter");
        fridge.addIngredient("pepper", "pepper");
        fridge.getUsersIngredientsName();
        assertEquals(p.getFridge(), "meat | butter | pepper | ");
        fridge.Cooked("banana ice cream", recipeManager);
        fridge.getUsersIngredientsName();
        assertEquals(p.getFridge(), "meat | butter | pepper | ");
    }





}
