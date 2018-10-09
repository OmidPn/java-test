package com.h2rd.refactoring.factories;

import com.j2rd.refactoring.entity.Role;
import com.j2rd.refactoring.entity.User;
import com.h2rd.refactoring.view.UserView;
import java.util.ArrayList;
import java.util.List;

public class UserFactory
{
    public static User create(final UserView userView)
    {
        final User user = new User();
        return update(userView,user);
    }
    
    
    public static User update(final UserView userView,final User user)
    {
        user.setName(userView.getName());
        user.setEmail(userView.getEmail());
    
        if(userView != null)
        {
            final List<Role> roles = new ArrayList <>();
            userView.getRoles().forEach(roleView->{
                roles.add(RoleFactory.create(roleView));
            });
            user.setRoles(roles);
        }
        return user;
    }
    
}
