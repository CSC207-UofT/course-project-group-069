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
     * @throws Exception
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
     * Test getDirectionAction and get recipe direction
     */
    @Test
    public void testGetDirectionAction(){
        controller.getDirectionAction("steak");
        System.out.println(presenter.getRecipeDirection());
        assertFalse(presenter.getRecipeDirection() == "No directions available");
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
        assertEquals(presenter.getAvailableRecipes(), "Banana Ice Cream | Steak | ");
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

}
