package test.com.h2rd.refactoring.unit;

import com.j2rd.refactoring.entity.Role;
import com.j2rd.refactoring.entity.User;
import java.util.Arrays;

public class UserBuilder
{
    public static User create(final Long id){
        final User user=new User();
        user.setId(id);
        user.setName("Fake Name");
                user.setEmail("fake@email.com");
                user.setRoles(Arrays.asList(new Role("admin"), new Role("master")));
                return user;
    }
}
