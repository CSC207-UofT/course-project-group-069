import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import com.example.phase2.controller.MealsSystem;
import org.junit.Before;
import org.junit.Test;
import com.example.phase2.ui.SystemInOut;
import com.example.phase2.use_case.RecipeFacade;

public class MealsSystemTest {
    MealsSystem ms;
    String message1;
    String message2;
    String message3;
    String recipes;

    @Before
    public void setUp() {
        ms = new MealsSystem();
        RecipeFacade recipemanager = new RecipeFacade();
        message1 = "If you'd like to add an ingredient to your fridge, please type \"Add\" \n" +
                         "If you would like to find a recipe, please type \"Recipe\" \n" +
                         "If you wish to view the items in your fridge, please type \"Fridge\" \n" +
                         "To logout, please type \"Logout\"";
        message2 = "Please type \"Create Account\" if you are new, " +
                   "\"Login\" if you already have an account, or \"Quit\"";
        message3 = "If you'd like to get a recipe for a specific ingredient, " +
                   "please type your ingredient.\nOr if you'd like to get a list of recipes that " +
                   "you can cook using items from your fridge, please type \"List\"";
        recipes = recipemanager.findRecipe("Extra Virgin Olive Oil").toString();
    }

    /**
     * Tests Incorrect Login attempt, Successful Account Creation, Finding recipes on user-inputted
     * ingredients with an empty fridge, and Logging Out.
     */
    @Test
    public void testrun_createaccount() {
        String[] expectedOutput = new String[]{
            message2, "Enter User Name:", "Enter Password:", "Incorrect Username or Password",
            message2, "Enter User Name:", "Enter Password:", "Account Created!", message1,
            message3, "[]", message1, message3, recipes, message1, "Successfully logged out.", null,
            null, null, null, null, null, null, null, null, null, null};

        StringInOut inOut = new StringInOut(
                new String[]{"Login", "Jake", "Penguin123", "Create Account", "John", "Secret123",
                "Recipe", "Chicken", "Recipe", "Extra Virgin Olive Oil", "Logout"}
        );

        ms.run(inOut);
        assertArrayEquals(expectedOutput, inOut.testOutput);
        assertEquals(16, inOut.nextOutput);
    }

    /**
     * Tests Successful Login Attempt, Adding items to a Fridge, Displaying items of Empty and
     * Non-empty Fridges, Finding Recipes based on items in Empty and Non-empty Fridges.
     */
    @Test
    public void testrun_login() {
        String[] expectedOutput = new String[]{
                message2, "Enter User Name:", "Enter Password:", "Login Successful! Welcome back!",
                message1, "[]", message1, message3, "There are no items in your fridge", message1,
                "What ingredient would you like to add?", "What food type is it?", "Successfully stored!\n\n",
                message1, "[Chicken]", message1, "What ingredient would you like to add?",
                "What food type is it?", "Successfully stored!\n\n", message1, "[Chicken, Extra Virgin Olive Oil]",
                message1, message3, "Chicken: Could not find any recipes.",
                "Extra Virgin Olive Oil: " + recipes, message1, "Successfully logged out."};

        StringInOut inOut = new StringInOut(new String[]{"Login", "John", "Secret123", "Fridge",
        "Recipe", "List", "Add", "Chicken", "Meat", "Fridge", "Add", "Extra Virgin Olive Oil", "Oil",
        "Fridge", "Recipe", "List", "Logout"});

        ms.run(inOut);
        assertArrayEquals(expectedOutput, inOut.testOutput);
        assertEquals(27, inOut.nextOutput);
    }

    /**
     * Tests Unacceptable Input and Quitting
     */
    @Test
    public void testrun_quit() {
        String[] expectedOutput = new String[]{
                message2, "Input not recognized.", message2, "Quit Successfully", null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null};

        StringInOut inOut = new StringInOut(new String[]{"Something", "Quit"});

        ms.run(inOut);
        assertArrayEquals(expectedOutput, inOut.testOutput);
        assertEquals(4, inOut.nextOutput);
    }

    public static class StringInOut extends SystemInOut {

            private final String[] testInput;
            private int nextInput;
            private final String[] testOutput;
            private int nextOutput;

            public StringInOut(String[] testStrings) {
                this.testInput = testStrings;
                this.testOutput = new String[27]; // Expecting only a handful of outputs.
                this.nextOutput = 0;
            }

            @Override
            public String getInput() {
                return this.testInput[nextInput++];
            }

            @Override
            public void sendOutput(Object s) {
                testOutput[nextOutput] = s.toString();
                nextOutput += 1;
            }
        }
}
