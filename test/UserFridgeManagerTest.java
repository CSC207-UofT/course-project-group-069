import entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import use_case.CurrentUserObserver;
import use_case.UserFridgeManager;
import use_case.UserManageLoginAndNewUser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserFridgeManagerTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 50)
    public void testAddIngredient() throws Exception{
        UserFridgeManager ufm = new UserFridgeManager();
        UserManageLoginAndNewUser umlanu = new UserManageLoginAndNewUser(ufm);
        umlanu.login("default", "123");
        ufm.addIngredient("potato","veggie","4 days");
        User currentUser = ufm.getCurrentUser();
        assertEquals(currentUser.fridge.get(0).getIngredientName(),"potato");
    }


}
