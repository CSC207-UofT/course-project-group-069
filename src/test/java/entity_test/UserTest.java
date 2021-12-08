package entity_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.example.phase2.entity.User;
import com.example.phase2.entity.Ingredient;

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
    public void testGetPasscode(){

        assertEquals(user.getPasscode(),"123");
    }

    /**
     * Test for getUserName method
     */
    @Test
    public void testGetUserName(){
        assertEquals(user.getUserName(),"default");
    }

    /**
     * Test for getFridge method
     */
    @Test
    public void testGetFridge(){
        assertEquals(user.getFridge(),new ArrayList<String>());
        user.addToFridge(new Ingredient("egg","meat"));
        user.addToFridge(new Ingredient("cabbage","vegetable"));

        List<String> content = new ArrayList<>();
        content.add("egg");
        content.add("cabbage");
        assertEquals(user.getFridge(),content);
    }

    /**
     * Tests getShoppingList when the user's shopping list is both empty and non-empty.
     */
    @Test
    public void testGetShoppingList(){
        assertEquals(user.getShoppingList(),new ArrayList<Ingredient>());
        Ingredient apple = new Ingredient("apple", "fruit");
        user.addToShoppingList(apple);

        List<Ingredient> items = new ArrayList<>();
        items.add(apple);
        assertEquals(user.getShoppingList(), items);
    }

    /**
     * Tests addToShoppingList when the user adds one ingredient to their shopping list at a time.
     */
    @Test
    public void testAddToShoppingListSingleIngredient(){

        Ingredient banana = new Ingredient("banana", "fruit");
        user.addToShoppingList(banana);
        Ingredient papaya = new Ingredient("papaya", "fruit");
        user.addToShoppingList(papaya);

        List<Ingredient> items = new ArrayList<>();
        items.add(banana);
        items.add(papaya);
        assertEquals(user.getShoppingList(), items);
    }

    /**
     * Tests addToShoppingList when the user adds multiple ingredients to their shopping list at once.
     */
    @Test
    public void testAddToShoppingListMultipleIngredients(){
        Ingredient pear = new Ingredient("pear", "fruit");
        Ingredient coconut = new Ingredient("coconut", "fruit");
        Ingredient watermelon = new Ingredient("watermelon", "fruit");
        Ingredient tomato = new Ingredient("tomato", "fruit");

        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(coconut);
        ingredients.add(pear);
        ingredients.add(watermelon);
        ingredients.add(tomato);
        user.addToShoppingList(ingredients);

        assertEquals(user.getShoppingList(), ingredients);
    }

    /**
     * Tests removeFromShoppingList when one ingredient is removed successfully.
     */
    @Test
    public void testRemoveFromShoppingListSuccess(){
        Ingredient pear = new Ingredient("pear", "fruit");
        Ingredient coconut = new Ingredient("coconut", "fruit");
        Ingredient watermelon = new Ingredient("watermelon", "fruit");
        Ingredient tomato = new Ingredient("tomato", "fruit");

        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(coconut);
        ingredients.add(pear);
        ingredients.add(watermelon);
        ingredients.add(tomato);
        user.addToShoppingList(ingredients);

        user.removeFromShoppingList(watermelon);
        ArrayList<Ingredient> ingComp = new ArrayList<>();
        ingComp.add(coconut);
        ingComp.add(pear);
        ingComp.add(tomato);

        assertEquals(user.getShoppingList(), ingComp);
    }

    /**
     * Tests removeFromShoppingList when the ingredient that the user wants to remove is not in their
     * shopping list.
     */
    @Test
    public void testRemoveFromShoppingListFailure() {
        Ingredient pear = new Ingredient("pear", "fruit");
        Ingredient coconut = new Ingredient("coconut", "fruit");
        Ingredient watermelon = new Ingredient("watermelon", "fruit");
        Ingredient tomato = new Ingredient("tomato", "fruit");

        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(coconut);
        ingredients.add(pear);
        ingredients.add(tomato);
        user.addToShoppingList(ingredients);

        user.removeFromShoppingList(watermelon);
        ArrayList<Ingredient> ingComp = new ArrayList<>();
        ingComp.add(coconut);
        ingComp.add(pear);
        ingComp.add(tomato);

        assertEquals(user.getShoppingList(), ingComp);
    }


}
