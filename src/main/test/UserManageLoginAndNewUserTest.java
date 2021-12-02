import com.example.phase2.use_case.UserFridgeManager;
import com.example.phase2.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.example.phase2.use_case.CurrentUserObserver;
import com.example.phase2.use_case.UserFridgeManager;
import com.example.phase2.use_case.UserManageLoginAndNewUser;

import static org.junit.Assert.*;

public class UserManageLoginAndNewUserTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void testLogin() throws Exception{
//        CurrentUserObserver observer = new UserFridgeManager();
//        UserManageLoginAndNewUser umlanu = new UserManageLoginAndNewUser(observer);
////        assertTrue(umlanu.login("default", "123"));
//    }

//    @Test
//    public void testCreateUser() throws Exception{
//        CurrentUserObserver observer = new UserFridgeManager();
//        UserManageLoginAndNewUser umlanu = new UserManageLoginAndNewUser(observer);
//        umlanu.createUser("avalo", "123");
////        assertTrue(umlanu.login("avalo", "123"));
//
//    }

//    @Test
//    public void testLogOut() throws Exception{
//        UserFridgeManager ufm = new UserFridgeManager();
//        UserManageLoginAndNewUser umlanu = new UserManageLoginAndNewUser(ufm);
//        umlanu.login("default", "123");
//        ufm.addIngredient("potato","veggie","4 days");
//        umlanu.logOut();
//        umlanu.login("default", "123");
//        User currentUser = ufm.getCurrentUser();
//        assertEquals(currentUser.fridge.get(0).getIngredientName(),"potato");
//    }
}
