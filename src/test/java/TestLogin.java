import com.example.phase2.controller.Controller;
import com.example.phase2.controller.Presenter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestLogin {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLogin(){
        Presenter presenter = new Presenter();
        Controller controller = new Controller(presenter);
        controller.loginAction("default", "123");
        assertTrue(presenter.getLoginStatus());
    }
}
