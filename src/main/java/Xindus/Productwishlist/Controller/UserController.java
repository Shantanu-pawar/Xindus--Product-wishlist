package Xindus.Productwishlist.Controller;

import Xindus.Productwishlist.DTOs.UserRegisterDto;
import Xindus.Productwishlist.Entity.UserEntity;
import Xindus.Productwishlist.Service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import Xindus.Productwishlist.DTOs.LoginUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterDto dto){
        try{
            String response = userService.registerUser(dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginUserDto loginDto){
        try{
            String response = userService.login(loginDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
