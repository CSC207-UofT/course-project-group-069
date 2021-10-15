package test;

import entity.User;
import org.junit.*;
import use_case.UserManager;

import static org.junit.Assert.*;

import java.io.*;

public class UserManagerTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 50)
    public void testLogin(){
        UserManager um = new UserManager();
        User Jack = new User("Jack123", "1234");
        um.addUser(Jack);
        assertTrue(um.login("Jack123", "1234"));
    }

    @Test(timeout = 50)
    public void testAddIngredient(){
        UserManager um = new UserManager();
        User Jack = new User("Jack123", "1234");
        um.addUser(Jack);
        um.login("Jack123", "1234");
        um.addIngredient("potato","vegetable","4 days");
        assertEquals(Jack.fridge.get(0).getIngredientName(),"potato");

    }



}
