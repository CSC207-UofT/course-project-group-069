package use_case_test;

import com.example.phase2.controller.Presenter;
import com.example.phase2.entity.User;
import com.example.phase2.entity.UserList;
import com.example.phase2.use_case.RecipeFacade;
import com.example.phase2.use_case.UserFridgeManager;
import com.example.phase2.use_case.UserLoginManager;
import com.example.phase2.use_case.UserShoppingListManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import static org.junit.Assert.*;

public class UserLoginManagerTest {

    private Presenter p;
    private UserLoginManager userManager;
    private UserFridgeManager fridge;

    /**
     * Set up for the test.
     */
    @Before
    public void setUp() {
        p = new Presenter();
        RecipeFacade recipeManager = new RecipeFacade(p);
        fridge = new UserFridgeManager(p);
        UserShoppingListManager shoppingList = new UserShoppingListManager(p);
        userManager = new UserLoginManager(fridge, recipeManager, shoppingList, p);
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
     * test successful login
     */
    @Test
    public void testLoginSuccess(){
        userManager.login("default", "123");
        assertEquals(fridge.getCurrentUser().getUserName(), "default");
        assertTrue(p.getLoginStatus());
    }

    /**
     * test failed login with wrong username
     */
    @Test
    public void testLoginFailWrongUserName(){
        userManager.login("wrongUserName", "123");
        assertFalse(p.getLoginStatus());
    }

    /**
     * test failed login with wrong passcode
     */
    @Test
    public void testLoginFailWrongUserPasscode(){
        userManager.login("wrongUserName", "1234");
        assertFalse(p.getLoginStatus());
    }

    /**
     * test successful create new user
     */
    @Test
    public void testCreateUser(){
        userManager.createUser("csc207", "123");
        userManager.login("csc207", "123");
        assertEquals(fridge.getCurrentUser().getUserName(), "csc207");
        assertTrue(p.getLoginStatus());
    }

    /**
     * test successful create new user with a different username and passcode
     */
    @Test
    public void testCreateUserDifferentUserName(){
        userManager.createUser("phase2testCreateUser", "Phase2");
        userManager.login("phase2testCreateUser", "Phase2");
        assertEquals(fridge.getCurrentUser().getUserName(), "phase2testCreateUser");
        assertTrue(p.getLoginStatus());
    }

    /**
     * test successful logout
     */
    @Test
    public void testLogout(){
        userManager.login("default", "123");
        fridge.addIngredient("Potato", "Vegetable");
        userManager.logOut();
        userManager.login("default", "123");
        fridge.getUsersIngredientsName();
        assertEquals(p.getFridge(),"potato | ");
    }

    /**
     * test logout that serialized the correct ingredient
     */
    @Test
    public void testLogoutWrongIngredient(){
        userManager.login("default", "123");
        fridge.addIngredient("tomato", "Vegetable");
        userManager.logOut();
        userManager.login("default", "123");
        fridge.getUsersIngredientsName();
        assertFalse(p.getFridge().equals("potato | "));
    }


}
