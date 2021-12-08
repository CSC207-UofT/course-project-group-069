package entity_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import com.example.phase2.entity.User;
import com.example.phase2.entity.Ingredient;
import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests for all methods in Recipe
 */
public class UserTest {

    private User user;
    @Before
    public void setUp() {
        user = new User("default","123");
    }

    @After
    public void tearDown() {
    }
    /**
     * Test for getPasscode method
     */
    @Test
    public void testgetPasscode(){

        assertEquals(user.getPasscode(),"123");
    }
    /**
     * Test for getUserName method
     */
    @Test
    public void testgetUserName(){
        assertEquals(user.getUserName(),"default");
    }
    /**
     * Test for getFridge method
     */
    @Test
    public void testgetFridge(){
        assertEquals(user.getFridge(),new ArrayList<String>());
        user.fridge.add(new Ingredient("egg","meat"));
        user.fridge.add(new Ingredient("cabbage","vegetable"));

        List<String> content = new ArrayList<>();
        content.add("egg");
        content.add("cabbage");
        assertEquals(user.getFridge(),content);
    }




}
