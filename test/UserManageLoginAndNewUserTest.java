import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import use_case.CurrentUserObserver;
import use_case.UserFridgeManager;
import use_case.UserManageLoginAndNewUser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserManageLoginAndNewUserTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 50)
    public void testLogin() throws Exception{
        CurrentUserObserver observer = new UserFridgeManager();
        UserManageLoginAndNewUser umlanu = new UserManageLoginAndNewUser(observer);
        assertTrue(umlanu.login("default", "123"));
    }

    @Test(timeout = 50)
    public void testCreateUser() throws Exception{
        CurrentUserObserver observer = new UserFridgeManager();
        UserManageLoginAndNewUser umlanu = new UserManageLoginAndNewUser(observer);
        umlanu.createUser("avalo", "123");
        assertTrue(umlanu.login("avalo", "123"));

    }
}
