package com.h2rd.refactoring.web.services;

import com.h2rd.refactoring.view.UserView;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  Omid panahi email:omidpan4@gmaail.com
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserManagementWebController
{
   
    @Autowired
    private UserManagementWebServices userManagementWebServices;
    
    
    @PostMapping(value = "/add")
    public Response addUser(final UserView userView)
    {
       return userManagementWebServices.addUser(userView);
    }
    @GetMapping(value = "/find")
    public Response getUsers()
    {
       return userManagementWebServices.findUsers();
    }
    
    @PutMapping("update/")
    public Response updateUser(final UserView userView) {
       return userManagementWebServices.updateUser(userView);
    }
    
    @DeleteMapping("delete/")
    public Response deleteUser(final UserView userView) {
       return userManagementWebServices.deleteUser(userView);
    }
}
