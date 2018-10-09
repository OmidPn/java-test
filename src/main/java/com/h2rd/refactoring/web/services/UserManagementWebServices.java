package com.h2rd.refactoring.web.services;

import com.h2rd.refactoring.view.UserView;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Service;

@Service
public interface UserManagementWebServices
{
    Response findUsers();
    Response addUser(final UserView userView);
    Response deleteUser(final UserView userView);
    Response updateUser(final UserView userView);
    Response findUserByName(final String name);
}
