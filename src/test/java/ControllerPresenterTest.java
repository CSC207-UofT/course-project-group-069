import com.example.phase2.controller.Controller;
import com.example.phase2.controller.Presenter;
import com.example.phase2.entity.User;
import com.example.phase2.entity.UserList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import static org.junit.Assert.*;

/**
 * This class test controller, and presenter, and overall functioning of the program.
 * There are fewer test cases here as main logics are all checked in the use case test.
 */
public class ControllerPresenterTest {

    Controller controller;
    Presenter presenter;

    @Before
    public void setUp() {
        presenter = new Presenter();
        controller = new Controller(presenter);
    }

    /**
     * resetting the ser file after each test
     * @throws Exception Throws IOException or ClassNotFoundException
     */
    @After
    public void tearDown() throws Exception{
        UserList users = new UserList();
        User user = new User("default", "123");
        users.add(user);

        FileOutputStream fos = new FileOutputStream("userlist.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
    }

    /**
     * Test loginAction and getLoginStatus
     */
    @Test
    public void testLoginAction(){
        controller.loginAction("default", "123");
        assertTrue(presenter.getLoginStatus());
    }

    /**
     * Test logoutAction
     */
    @Test
    public void testLogoutAction(){
        controller.loginAction("default", "123");
        controller.addIngAction("potato", "vegetable");
        controller.logoutAction();
        controller.loginAction("default", "123");
        controller.viewFridgeAction();
        assertEquals(presenter.getFridge(), "potato | ");
    }

    /**
     * Test createUserAction and getLoginStatus
     */
    @Test
    public void testCreateUserAction(){
        controller.createUserAction("meals", "123");
        controller.loginAction("meals", "123");
        assertTrue(presenter.getLoginStatus());
    }

    /**
     * Test addIngAction, viewFridgeAction, and getFridge
     */
    @Test
    public void testAddIngAndViewFridgeAction(){
        controller.loginAction("default", "123");
        controller.addIngAction("Potato", "Vegetable");
        controller.viewFridgeAction();
        assertEquals(presenter.getFridge(),"potato | ");
    }

    /**
     * Test addIngAction, viewFridgeAction, and getFridge with multiple ingredient
     */
    @Test
    public void testMultiIngredientAddIngAndViewFridgeAction(){
        controller.loginAction("default", "123");
        controller.addIngAction("Potato", "Vegetable");
        controller.addIngAction("Tomato", "Vegetable");
        controller.addIngAction("Lettuce", "Vegetable");
        controller.viewFridgeAction();
        assertEquals(presenter.getFridge(),"potato | tomato | lettuce | ");
    }

    /**
     * Test addItemAction() and viewShoppingListAction() when adding one ingredient to the shopping list.
     */
    @Test
    public void testAddItemActionAndViewShoppingListAction(){
        controller.loginAction("default", "123");
        controller.addItemAction("apple");
        controller.viewShoppingListAction();
        assertEquals(presenter.getShoppingList(),"apple | ");
    }

    /**
     * Test addItemAction() and viewShoppingListAction() when adding multiple ingredient to the
     * shopping list.
     */
    @Test
    public void testAddItemActionAndViewShoppingListActionMultiple(){
        controller.loginAction("default", "123");
        controller.addItemAction("apple");
        controller.addItemAction("papaya");
        controller.addItemAction("orange");
        controller.viewShoppingListAction();
        assertEquals(presenter.getShoppingList(),"apple | papaya | orange | ");
    }

    /**
     * Test removeItemAction when provided with the correct ingredient name.
     */
    @Test
    public void testRemoveItemActionSuccess(){
        controller.loginAction("default", "123");
        controller.addItemAction("apple");
        controller.viewShoppingListAction();
        controller.removeItemAction("apple");
        controller.viewShoppingListAction();
        assertEquals(presenter.getShoppingList(), "Empty Shopping List. Click Add Ingredient!");
        assertTrue(presenter.getRemoveStatus());
    }

    /**
     * Test removeItemAction when the user's shopping list is empty and when provided with
     * the incorrect ingredient name.
     */
    @Test
    public void testRemoveItemActionFailure(){
        controller.loginAction("default", "123");
        controller.removeItemAction("apple");
        controller.viewShoppingListAction();
        assertEquals(presenter.getShoppingList(), "Empty Shopping List. Click Add Ingredient!");
        assertFalse(presenter.getRemoveStatus());

        controller.addItemAction("apple");
        controller.viewShoppingListAction();
        controller.removeItemAction("banana");
        controller.viewShoppingListAction();
        assertEquals(presenter.getShoppingList(), "apple | ");
        assertFalse(presenter.getRemoveStatus());
    }

    /**
     * Test getDirectionAction and get recipe direction
     */
    @Test
    public void testGetDirectionAction(){
        controller.getDirectionAction("steak");
        System.out.println(presenter.getRecipeDirection());
        assertNotSame("No directions available", presenter.getRecipeDirection());
    }

    /**
     * Test getAvailableRecipe
     */
    @Test
    public void testGetAvailableRecipe(){
        controller.loginAction("default", "123");
        controller.addIngAction("meat", "meat");
        controller.addIngAction("butter", "butter");
        controller.addIngAction("pepper", "pepper");
        controller.getAvailableRecipe();
        assertEquals(presenter.getAvailableRecipes(), "Steak | ");
    }

    /**
     * Test getAvailableRecipe with a different recipe
     */
    @Test
    public void testGetAvailableRecipeDiffRecipe(){
        controller.loginAction("default", "123");
        controller.addIngAction("ripe bananas", "meat");
        controller.addIngAction("honey", "butter");
        controller.addIngAction("white chocolate", "pepper");
        controller.getAvailableRecipe();
        assertEquals(presenter.getAvailableRecipes(), "Banana Ice Cream | ");
    }

    /**
     * Test getAvailableRecipe with a multiple recipe
     */
    @Test
    public void testGetAvailableRecipeMultiRecipe(){
        controller.loginAction("default", "123");
        controller.addIngAction("ripe bananas", "meat");
        controller.addIngAction("honey", "butter");
        controller.addIngAction("white chocolate", "pepper");
        controller.addIngAction("meat", "meat");
        controller.addIngAction("butter", "butter");
        controller.addIngAction("pepper", "pepper");
        controller.getAvailableRecipe();
        assertEquals(presenter.getAvailableRecipes(), "Steak | Banana Ice Cream | ");
    }


    /**
     * Test cook
     */
    @Test
    public void testCook(){
        controller.loginAction("default", "123");
        controller.addIngAction("meat", "meat");
        controller.addIngAction("butter", "butter");
        controller.addIngAction("pepper", "pepper");
        controller.cook("steak");
        controller.viewFridgeAction();
        assertEquals(presenter.getFridge(), "Empty Fridge" );
    }

    /**
     * Test cook with more ingredients
     */
    @Test
    public void testCookMoreIngredient(){
        controller.loginAction("default", "123");
        controller.addIngAction("ripe bananas", "meat");
        controller.addIngAction("honey", "butter");
        controller.addIngAction("white chocolate", "pepper");
        controller.addIngAction("meat", "meat");
        controller.addIngAction("butter", "butter");
        controller.addIngAction("pepper", "pepper");
        controller.cook("steak");
        controller.viewFridgeAction();
        assertEquals(presenter.getFridge(), "ripe bananas | honey | white chocolate | " );
        controller.cook("banana ice cream");
        controller.viewFridgeAction();
        assertEquals(presenter.getFridge(), "Empty Fridge" );
    }

    /**
     * Test removeIngAction method
     */
    @Test
    public void testRemoveIngAction(){
        controller.loginAction("default", "123");
        controller.addIngAction("meat", "meat");
        controller.removeIngAction("meat");
        controller.viewFridgeAction();
        assertEquals(presenter.getFridge(), "Empty Fridge" );
    }

    /**
     * Test removeIngAction method with multiple ingredient
     */
    @Test
    public void testRemoveIngActionMultiIng(){
        controller.loginAction("default", "123");
        controller.addIngAction("meat", "meat");
        controller.addIngAction("potato", "vegetable");
        controller.removeIngAction("meat");
        controller.viewFridgeAction();
        assertEquals(presenter.getFridge(), "potato | " );
    }

    /**
     * Test removeIngAction method with wrong ingredient
     */
    @Test
    public void testRemoveIngActionWrongIng(){
        controller.loginAction("default", "123");
        controller.addIngAction("potato", "vegetable");
        controller.removeIngAction("meat");
        controller.viewFridgeAction();
        assertEquals(presenter.getFridge(), "potato | " );
    }

    /**
     * Test removeIngAction method with no ingredient added
     */
    @Test
    public void testRemoveIngActionEmptyIng(){
        controller.loginAction("default", "123");
        controller.removeIngAction("meat");
        controller.viewFridgeAction();
        assertEquals(presenter.getFridge(), "Empty Fridge" );
    }

}
