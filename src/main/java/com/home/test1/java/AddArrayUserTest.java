package java;

import com.home.newProject.main.main.User;
import com.home.newProject.main.main.Users;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by FDR on 09.06.2017.
 */
public class AddArrayUserTest {
    @Test
    public void test1() {
        Users users = new Users();
        User user = new User(1, "name", "surname");
        users.addUser(user);

        assertEquals(1, users.users.size());
    }


}
