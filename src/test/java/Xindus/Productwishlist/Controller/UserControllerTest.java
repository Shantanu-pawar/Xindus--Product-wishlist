package Xindus.Productwishlist.Controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import Xindus.Productwishlist.DTOs.LoginUserDto;
import Xindus.Productwishlist.DTOs.UserRegisterDto;
import Xindus.Productwishlist.Service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private UserRegisterDto userRegisterDto;
    private LoginUserDto loginUserDto;

    @Before
    public void setup() {
        userRegisterDto = new UserRegisterDto("username", "password");
        loginUserDto = new LoginUserDto("username", "password");
    }

    @Test
    public void testRegisterUser_Success() {
        when(userService.registerUser(userRegisterDto)).thenReturn("Registration successful");

        ResponseEntity<?> responseEntity = userController.registerUser(userRegisterDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Registration successful", responseEntity.getBody());
    }

    @Test
    public void testRegisterUser_Exception() {
        when(userService.registerUser(userRegisterDto)).thenThrow(new RuntimeException("Registration failed"));

        ResponseEntity<?> responseEntity = userController.registerUser(userRegisterDto);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Registration failed", responseEntity.getBody());
    }

    @Test
    public void testLogin_Success() {
        when(userService.login(loginUserDto)).thenReturn("Login successful");

        ResponseEntity<String> responseEntity = userController.login(loginUserDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Login successful", responseEntity.getBody());
    }

    @Test
    public void testLogin_Exception() {
        when(userService.login(loginUserDto)).thenThrow(new RuntimeException("Login failed"));

        ResponseEntity<String> responseEntity = userController.login(loginUserDto);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Login failed", responseEntity.getBody());
    }
}
