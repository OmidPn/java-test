package com.h2rd.refactoring.factories;

import com.h2rd.refactoring.view.RoleView;
import com.j2rd.refactoring.entity.User;
import com.h2rd.refactoring.view.UserView;
import java.util.ArrayList;
import java.util.List;

public class UserViewFactory
{
    public static UserView create(final User user)
    {
        return update(user);
    }
    
    
    public static UserView update(final User user)
    {
        final UserView userView = new UserView();
        userView.setName(user.getName());
        userView.setEmail(user.getEmail());
        
        if(user != null)
        {
            final List<RoleView> roleViews = new ArrayList<>();
            user.getRoles().forEach(role->{
                roleViews.add(RoleViewFactory.create(role));
            });
            userView.setRoles(roleViews);
        }
        return userView;
    }
}
