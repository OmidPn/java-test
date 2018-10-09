package com.h2rd.refactoring.transactions;

import com.h2rd.refactoring.factories.UserFactory;
import com.h2rd.refactoring.factories.UserViewFactory;
import com.h2rd.refactoring.repository.UserRepository;
import com.h2rd.refactoring.utils.UserResponseBuilder;
import com.h2rd.refactoring.view.UserView;
import com.h2rd.refactoring.web.services.UserManagementWebServices;
import com.j2rd.refactoring.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementTransactionServicesImpl implements UserManagementWebServices
{
    @Autowired
    UserRepository userRepository;
    
    @Override
    @Transactional
    public Response findUsers()
    {
        final List<User> users= (List <User>) userRepository.findAll();
        if(users.isEmpty())
            return UserResponseBuilder.getResponseBuilder(Status.NOT_FOUND,users);
            
        else {
            //create view
             final List<UserView> userViews = new ArrayList <>();
             users.forEach(usr->userViews.add(UserViewFactory.create(usr)));
            return UserResponseBuilder.getResponseBuilder(Status.OK,userViews);
        }
    }
    @Override
    @Transactional(value = TxType.REQUIRES_NEW)
    public Response addUser(final UserView userView)
    {
        // TODO implementing of view validator needed. :)
        final User user=  userRepository.save(UserFactory.create(userView));
        if(user==null)
            return UserResponseBuilder.getResponseBuilder(Status.BAD_REQUEST,user);
    
        else return UserResponseBuilder.getResponseBuilder(Status.CREATED,UserViewFactory.create(user));
    }
    @Override
    @Transactional(value = TxType.REQUIRED)
    public Response deleteUser(final UserView userView)
    {
        // TODO implementing of view validator needed.  :)
        final User user= userRepository.findUserByName(userView.getName());
        userRepository.delete(user);
        return UserResponseBuilder.getResponseBuilder(Status.NO_CONTENT,userView.getName());
    }
    @Override
    @Transactional(value = TxType.REQUIRES_NEW)
    public Response updateUser(final UserView userView)
    {
        // TODO implementing of view validator needed.  :)
        final Optional<User> user= userRepository.findById(userView.getId());
    
        if(user ==null) return UserResponseBuilder.getResponseBuilder(Status.BAD_REQUEST,user);
        else
        {
            final User updateUser= UserFactory.update(userView,user.get());
            return UserResponseBuilder.getResponseBuilder(Status.ACCEPTED,UserViewFactory.update(userRepository.save(updateUser)));
        }
        
    }
    @Override
    public Response findUserByName(final String name)
    {
        Response response=null;
        if (name!=null)
        {
            final User user= userRepository.findUserByName(name);
            if(user!=null)
            {
                response= UserResponseBuilder.getResponseBuilder(Status.OK,UserViewFactory.create(user));
            }
            else
            {
                response= UserResponseBuilder.getResponseBuilder(Status.NOT_FOUND,null);
            }
    
        }
        return response;
    }
}
