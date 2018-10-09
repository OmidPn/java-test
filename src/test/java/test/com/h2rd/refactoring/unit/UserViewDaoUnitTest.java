package test.com.h2rd.refactoring.unit;

import com.j2rd.refactoring.entity.UserView;
import com.h2rd.refactoring.usermanagement.UserDao;
import org.junit.Test;

import java.util.Arrays;

public class UserViewDaoUnitTest
{

    UserDao userDao;

    @Test
    public void saveUserTest() {
        userDao = UserDao.getUserDao();

        UserView user = new UserView();
        user.setName("Fake Name");
        user.setEmail("fake@email.com");
        user.setRoles(Arrays.asList("admin", "master"));

        userDao.saveUser(user);
    }

    @Test
    public void deleteUserTest() {
        userDao = UserDao.getUserDao();

        UserView user = new UserView();
        user.setName("Fake Name");
        user.setEmail("fake@email.com");
        user.setRoles(Arrays.asList("admin", "master"));

        try {
            userDao.deleteUser(user);
        } catch (NullPointerException e) {
        }
    }
}