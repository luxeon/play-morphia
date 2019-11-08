import models.User;
import org.junit.Test;
import play.test.UnitTest;


public class UserTest extends UnitTest {

    @Test
    public void testStoreUser() {
        User u = new User();
        u.name = "alex";
        assertTrue(u.isNew());
        u.save();

        assertFalse(u.isNew());
        assertEquals("alex", u.name);
    }
}
