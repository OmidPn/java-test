package com.h2rd.refactoring.factories;

import com.j2rd.refactoring.entity.Role;
import com.h2rd.refactoring.view.RoleView;

public class RoleViewFactory
{
    public static RoleView create(final Role role)
    {
        // if id is null it will be generated automatically in db
      return   update(role);
      
    }
    public static RoleView update(final Role role)
    {
        final RoleView roleView = new RoleView();
        roleView.setId(role.getId());
        roleView.setName(role.getName());
        return roleView;
    }
}
