package com.h2rd.refactoring.factories;

import com.j2rd.refactoring.entity.Role;
import com.h2rd.refactoring.view.RoleView;

public class RoleFactory
{
    public static Role create(final RoleView roleView)
    {
        // if id is null it will be generated automatically in db
       return update(roleView);
    }
    public static Role update(final RoleView roleView)
    {
        final Role role = new Role();
        role.setId(roleView.getId());
        role.setName(roleView.getName());
        return role;
    }
    
}
