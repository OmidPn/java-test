package com.h2rd.refactoring.usermanagement;

import com.h2rd.refactoring.view.UserView;
import java.util.ArrayList;

/**
 * @@deprecated  this class has been changed
 */
public class UserDao {

    
    
    
    public ArrayList<UserView> users;

    public static UserDao userDao;

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    public void saveUser(UserView user) {
        if (users == null) {
            users = new ArrayList<UserView>();
        }
        users.add(user);
    }

    public ArrayList<UserView> getUsers() {
        try {
            return users;
        } catch (Throwable e) {
            System.out.println("error");
            return null;
        }
    }

    public void deleteUser(UserView userToDelete) {
        try {
            for (UserView user : users) {
                if (user.getName() == userToDelete.getName()) {
                    users.remove(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(UserView userToUpdate) {
        try {
            for (UserView user : users) {
                if (user.getName() == userToUpdate.getName()) {
                    user.setEmail(userToUpdate.getEmail());
                    user.setRoles(userToUpdate.getRoles());
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public UserView findUser(String name) {
        try {
            for (UserView user : users) {
                if (user.getName() == name) {
                    return user;
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
