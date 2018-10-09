package com.h2rd.refactoring.utils;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class UserResponseBuilder
{
    public static Response getResponseBuilder(final Status status, final Object entity)
    {
        return Response.status(status).entity(entity).build();
    }
}
