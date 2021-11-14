import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import controller.MealsSystem;
import org.junit.Before;
import org.junit.Test;
import ui.SystemInOut;

public class MealsSystemTest {
    MealsSystem ms;

    @Before
    public void setUp() {
        ms = new MealsSystem();
    }

    /**
     * Tests Incorrect Login attempt and Successful Account Creation
     */
    @Test
    public void testrun_createaccount() {
        String[] expectedOutput = new String[]{
            "Please type \"Create Account\" if you are new, " +
            "\"Login\" if you already have an account, or \"Quit\"",
            "Enter User Name:", "Enter Password:", "Incorrect Username or Password",
            "Please type \"Create Account\" if you are new, \"Login\" if you already" +
                    " have an account, or \"Quit\"", "Enter User Name:", "Enter Password:"};

        StringInOut inOut = new StringInOut(
                new String[]{"Login", "Jake", "Penguin123", "Create Account", "John", "Secret123"}
        );

        ms.run(inOut);
        assertArrayEquals(expectedOutput, inOut.testOutput);
        assertEquals(7, inOut.nextOutput);
    }

    /**
     * Tests Successful Login Attempt
     */
    @Test
    public void testrun_login() {
        String[] expectedOutput = new String[]{
                "Please type \"Create Account\" if you are new, " +
                        "\"Login\" if you already have an account, or \"Quit\"",
                "Enter User Name:", "Enter Password:", null, null, null, null};

        StringInOut inOut = new StringInOut(new String[]{"Login", "John", "Secret123"});

        ms.run(inOut);
        assertArrayEquals(expectedOutput, inOut.testOutput);
        assertEquals(3, inOut.nextOutput);
    }

    /**
     * Tests Unacceptable Input and Quitting
     */
    @Test
    public void testrun_quit() {
        String[] expectedOutput = new String[]{
                "Please type \"Create Account\" if you are new, " +
                        "\"Login\" if you already have an account, or \"Quit\"",
                "Input not recognized.", "Please type \"Create Account\" if you are new, " +
                "\"Login\" if you already have an account, or \"Quit\"", "Quit Successfully",
                null, null, null};

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
                this.testOutput = new String[7]; // Expecting only a handful of outputs.
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
