package test.com.h2rd.refactoring.integration;

import com.h2rd.refactoring.factories.UserViewFactory;
import com.h2rd.refactoring.repository.UserRepository;
import com.h2rd.refactoring.transactions.UserManagementTransactionServicesImpl;
import com.h2rd.refactoring.view.UserView;
import com.j2rd.refactoring.entity.User;
import java.util.Optional;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import test.com.h2rd.refactoring.unit.UserBuilder;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserManagementTransactionServicesImplTest
{
    private final static Long ID= 1L;
    private User user;
    @Mock
    private UserRepository userRepository;
    private UserView userView;
    @InjectMocks
    private UserManagementTransactionServicesImpl userManagementTransactionServicesImpl;

    @Before
    public void  before()
    {
         user= UserBuilder.create(ID);
         userView= UserViewFactory.create(user);
        userManagementTransactionServicesImpl =new UserManagementTransactionServicesImpl();
        initMocks(this);
    }
    @After
    public void after()
    {
        userManagementTransactionServicesImpl =null;
    }
    @Test
    public void findUSerByNameTest()
    {
        final String name="fake_name";
        when(userRepository.findUserByName(name)).thenReturn(user);
        final Response response = userManagementTransactionServicesImpl.findUserByName(name);
    
        verify(userRepository,times(1)).findUserByName(name);
        assertEquals("response is ok",response.getStatus(), 200);
    }
    @Test
    public void updateUserNotExistTest()
    {
        final Optional<User> optionalUser=null;
        when(userRepository.findById(userView.getId())).thenReturn(optionalUser);
        final Response response = userManagementTransactionServicesImpl.updateUser(userView);
        
        verify(userRepository,times(1)).findById(userView.getId());
        verify(userRepository,times(0)).save(any());
        assertEquals("response is bad request",response.getStatus(), 400);
    }
    @Test
    public void updateUserTest()
    {
        final Optional<User> optionalUser=Optional.of(user);
        when(userRepository.findById(userView.getId())).thenReturn(optionalUser);
        when(userRepository.save(any(User.class))).thenReturn(user);
        final Response response = userManagementTransactionServicesImpl.updateUser(userView);
        
        verify(userRepository,times(1)).findById(userView.getId());
        assertEquals("response is accepted ",response.getStatus(), 202);
    }
    @Test
    public void addUserTest()
    {
        when(userRepository.save(any(User.class))).thenReturn(user);
        final Response response = userManagementTransactionServicesImpl.addUser(userView);
        
        verify(userRepository,times(0)).save(user);
        assertEquals("response is created",response.getStatus(), 201);
    }
    @Test
    public void deleteUserByNameTest()
    {
        
        when(userRepository.findUserByName(userView.getName())).thenReturn(user);
        doNothing().when(userRepository).delete(user);
        
        final Response response = userManagementTransactionServicesImpl.deleteUser(userView);
        
        verify(userRepository,times(1)).findUserByName(userView.getName());
        verify(userRepository,times(1)).delete(user);
        assertEquals("response is no content",response.getStatus(), 204);
    }
}
