package com.h2rd.refactoring.web;

import com.h2rd.refactoring.view.UserView;
import com.h2rd.refactoring.usermanagement.UserDao;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Path("/users")
@Repository
public class UserResource{
 //this class should be splited to repository rest controller and services
    /*
    public UserDao userDao;

    @GET
    @Path("add/")
    public Response addUser(@QueryParam("name") String name,
                            @QueryParam("email") String email,
                            @QueryParam("role") List<String> roles) {

        UserView user = new UserView();
        user.setName(name);
        user.setEmail(email);
        user.setRoles(roles);

        if (userDao == null) {
            userDao = UserDao.getUserDao();
        }

        userDao.saveUser(user);
        return Response.ok().entity(user).build();
    }

    @GET
    @Path("update/")
    public Response updateUser(@QueryParam("name") String name,
                               @QueryParam("email") String email,
                               @QueryParam("role") List<String> roles) {

        UserView user = new UserView();
        user.setName(name);
        user.setEmail(email);
        user.setRoles(roles);

        if (userDao == null) {
            userDao = UserDao.getUserDao();
        }

        userDao.updateUser(user);
        return Response.ok().entity(user).build();
    }

    @GET
    @Path("delete/")
    public Response deleteUser(@QueryParam("name") String name,
                               @QueryParam("email") String email,
                               @QueryParam("role") List<String> roles) {
        UserView user = new UserView();
        user.setName(name);
        user.setEmail(email);
        user.setRoles(roles);

        if (userDao == null) {
            userDao = UserDao.getUserDao();
        }

        userDao.deleteUser(user);
        return Response.ok().entity(user).build();
    }

    @GET
    @Path("find/")
    public Response getUsers() {
    	
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {
    		"classpath:/application-config.xml"	
    	});
    	userDao = context.getBean(UserDao.class);
    	List<UserView> users = userDao.getUsers();
    	if (users == null) {
    		users = new ArrayList<UserView>();
    	}

        GenericEntity<List<UserView>> usersEntity = new GenericEntity<List<UserView>>(users) {};
        return Response.status(200).entity(usersEntity).build();
    }

    @GET
    @Path("search/")
    public Response findUser(@QueryParam("name") String name) {

        if (userDao == null) {
            userDao = UserDao.getUserDao();
        }

        UserView user = userDao.findUser(name);
        return Response.ok().entity(user).build();
    }
    */
}
