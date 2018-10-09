package test.com.h2rd.refactoring.integration;

import com.h2rd.refactoring.factories.UserViewFactory;
import com.h2rd.refactoring.utils.UserResponseBuilder;
import com.h2rd.refactoring.view.UserView;
import com.h2rd.refactoring.web.services.UserManagementWebController;
import com.h2rd.refactoring.web.services.UserManagementWebServices;
import com.j2rd.refactoring.entity.User;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import test.com.h2rd.refactoring.unit.UserBuilder;
import static javax.ws.rs.core.Response.Status.ACCEPTED;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;
import static javax.ws.rs.core.Response.Status.OK;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserManagementWebControllerTest
{
    
    private final static Long ID=0000001L;
    
    @Mock
    private UserManagementWebServices userManagementWebServices;
    
    @InjectMocks
    private UserManagementWebController userManagementWebServicesImpl;
    private UserView userView;
    @Before
    public void  before()
    {
        final User user= UserBuilder.create(ID);
        userView= UserViewFactory.create(user);
        userManagementWebServicesImpl =new UserManagementWebController();
        initMocks(this);
    }
    @After
    public void after()
    {
        userManagementWebServicesImpl =null;
    }
    
    @Test
    public void findUsersTestReturnUsers()
    {
        //given
        final List<UserView> userViews= Arrays.asList(userView,userView,userView );
        final Response response= UserResponseBuilder.getResponseBuilder(OK,userViews);
        
        //when
        when(userManagementWebServices.findUsers()).thenReturn(response);
        
        final Response result= userManagementWebServicesImpl.getUsers();
        //then
        verify(userManagementWebServices,times(1)).findUsers();
        assertEquals("response is ok",response.getStatus(), 200);
    }
    @Test
    public void addUserTest()
    {
        //given
        final Response response= UserResponseBuilder.getResponseBuilder(CREATED,userView);
        
        //when
        when(userManagementWebServices.addUser(userView)).thenReturn(response);
        
        final Response result= userManagementWebServicesImpl.addUser(userView);
        //then
        verify(userManagementWebServices,times(1)).addUser(userView);
        assertEquals("response is 201",response.getStatus(), 201);
    }
    
    @Test
    public void updateUserTest()
    {
        //given
        final Response response= UserResponseBuilder.getResponseBuilder(ACCEPTED,userView);
        
        //when
        when(userManagementWebServices.updateUser(userView)).thenReturn(response);
        
        final Response result= userManagementWebServicesImpl.updateUser(userView);
        //then
        verify(userManagementWebServices,times(1)).updateUser(userView);
        assertEquals("response is 202",response.getStatus(), 202);
    }
    @Test
    public void deleteUserTest()
    {
        final Response response= UserResponseBuilder.getResponseBuilder(NO_CONTENT,userView);
        
        //when
        when(userManagementWebServices.deleteUser(userView)).thenReturn(response);
        
        final Response result= userManagementWebServicesImpl.deleteUser(userView);
        //then
        verify(userManagementWebServices,times(1)).deleteUser(userView);
        assertEquals("response is 204",response.getStatus(), 204);
    }
}
