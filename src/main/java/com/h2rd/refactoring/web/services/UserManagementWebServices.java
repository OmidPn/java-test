package com.h2rd.refactoring.web.services;

import com.sun.research.ws.wadl.Response;
import java.util.List;

public interface UserManagementWebServices
{
    Response getUsers();
    Response findUsers(final String userName);
    Response addUser(final String name,final String email, final List<String> roles);
    Response deleteUser(final String userName);
    Response updateUser(final String name,final String email, final List<String> roles);
}
