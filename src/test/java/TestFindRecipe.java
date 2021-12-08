import com.example.phase2.controller.Controller;
import com.example.phase2.controller.Presenter;
import com.example.phase2.entity.Recipe;
import com.example.phase2.gateways.RW;
import com.example.phase2.gateways.RecipeCSV;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class TestFindRecipe {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInputRecipes() throws Exception{
        RW gateway = new RecipeCSV();
        List<Recipe> recipes = gateway.getRecipes();
        assertEquals(recipes.size(), 22);
    }

    @Test
    public void testFindRecipe() throws Exception{
        Presenter p = new Presenter();
        Controller c = new Controller(p);
        c.loginAction("default", "123");
        c.addIngAction("Ripe Bananas", "Fruit");
        c.addIngAction("Honey", "Fruit");
        c.addIngAction("White Chocolate", "Fruit");
        c.cook("Banana Ice Cream");

    }


}
