package use_case_test;

import com.example.phase2.controller.Presenter;
import com.example.phase2.use_case.RecipeFacade;
import com.example.phase2.use_case.UserFridgeManager;
import com.example.phase2.use_case.UserLoginManager;
import com.example.phase2.use_case.UserShoppingListManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingListManagerTest {

    private Presenter p;
    private RecipeFacade recipeManager;
    private UserLoginManager userManager;
    private UserFridgeManager fridge;
    private UserShoppingListManager shoppingList;

    /**
     * Logs in the user to allow testing of methods in UserShoppingListManager
     */
    @Before
    public void setUp() {
        p = new Presenter();
        recipeManager = new RecipeFacade(p);
        fridge = new UserFridgeManager(p);
        shoppingList = new UserShoppingListManager(p);
        userManager = new UserLoginManager(fridge, recipeManager, shoppingList, p);
        userManager.login("default", "123");
    }

    @After
    public void tearDown(){}

    /**
     * Tests adding one item at a time (with and without whitespace) to the user's shopping list.
     */
    @Test
    public void testAddItemOne(){
        shoppingList.addItem("Papaya", "Fruit");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "papaya | ");

        shoppingList.addItem("Chicken Drumstick", "Meat");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "papaya | chicken drumstick | ");

        shoppingList.addItem("Ripe Yellow Banana", "Meat");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "papaya | chicken drumstick | ripe yellow banana | ");
    }

    /**
     * Tests adding one item to the user's shopping list that has an empty ingredient name.
     */
    @Test
    public void testAddItemEmptyName(){
        shoppingList.addItem("", "");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "Empty Shopping List. Click Add Ingredient!");
    }

    /**
     * Tests adding multiple items to the user's shopping list successfully.
     */
    @Test
    public void testAddItemMultiple(){
        shoppingList.addItem("orange,papaya,grapes,apples", "Fruit");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "orange | papaya | grapes | apples | ");
    }

    /**
     * Tests adding multiple items to the user's shopping list, all with empty ingredient names
     */
    @Test
    public void testAddItemAllEmpty(){
        shoppingList.addItem(", , , , , ,", "");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "Empty Shopping List. Click Add Ingredient!");
    }

    /**
     * Tests adding multiples items to the user's shopping list. Some items have empty ingredient names.
     */
    @Test
    public void testAddItemMixed(){
        shoppingList.addItem(", orange, , , apple, banana, , , custard apple, , watermelon, ",
                "Fruit");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "orange | apple | banana | custard apple | watermelon | ");
    }

    /**
     * Tests adding multiples items to the user's shopping list. Some items have empty ingredients and
     * the whitespaces present vary from item to item.
     */
    @Test
    public void testAddItemUnevenWhitespace(){
        shoppingList.addItem("   ,        orange,apple, watermelon, ,,,        custard apple,, " +
                "                     ,  ,        banana", "Fruit");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "orange | apple | watermelon | custard apple | banana | ");
    }

    /**
     * Tests removing an item that isn't present in the user's shopping list.
     */
    @Test
    public void testRemoveItemFail(){
        //Test with empty shopping list
        shoppingList.removeItem("banana");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "Empty Shopping List. Click Add Ingredient!");
        assertFalse(p.getRemoveStatus());

        //Test with non-empty shopping list
        shoppingList.addItem("apple", "Fruit");
        shoppingList.getAllIngredients();
        shoppingList.removeItem("banana");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "apple | ");
        assertFalse(p.getRemoveStatus());
    }

    /**
     * Tests successfully removing an item from the user's shopping list.
     */
    @Test
    public void testRemoveItemSuccess(){
        shoppingList.addItem("apple", "fruit");
        shoppingList.getAllIngredients();
        shoppingList.removeItem("apple");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "Empty Shopping List. Click Add Ingredient!");
        assertTrue(p.getRemoveStatus());

        shoppingList.addItem("apple, papaya", "fruit");
        shoppingList.getAllIngredients();
        shoppingList.removeItem("apple");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "papaya | ");
        assertTrue(p.getRemoveStatus());
        shoppingList.removeItem("papaya");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "Empty Shopping List. Click Add Ingredient!");
        assertTrue(p.getRemoveStatus());
    }

    /**
     * Tests removing multiples items from the user's shopping list with both successful and failed
     * attempts.
     */
    @Test
    public void testRemoveItemMixed(){
        shoppingList.addItem("apple, papaya", "fruit");
        shoppingList.getAllIngredients();

        //Failure
        shoppingList.removeItem("coconut");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "apple | papaya | ");
        assertFalse(p.getRemoveStatus());

        //Success
        shoppingList.removeItem("papaya");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "apple | ");
        assertTrue(p.getRemoveStatus());

        //Failure
        shoppingList.removeItem("papaya");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "apple | ");
        assertFalse(p.getRemoveStatus());

        //Success
        shoppingList.removeItem("apple");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "Empty Shopping List. Click Add Ingredient!");
        assertTrue(p.getRemoveStatus());

        //Failure
        shoppingList.removeItem("apple");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "Empty Shopping List. Click Add Ingredient!");
        assertFalse(p.getRemoveStatus());
    }

    /**
     * Tests getAllIngredients() when the user's shopping list is empty.
     */
    @Test
    public void testGetAllIngredientsEmptyList(){
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "Empty Shopping List. Click Add Ingredient!");
    }

    /**
     * Tests getAllIngredients() when the user's shopping list is non-empty.
     */
    @Test
    public void testGetAllIngredientsNonEmptyList(){
        shoppingList.addItem("apple", "Fruit");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "apple | ");

        shoppingList.addItem("banana, coconut, blueberry", "Fruit");
        shoppingList.getAllIngredients();
        assertEquals(p.getShoppingList(), "apple | banana | coconut | blueberry | ");
    }
}
