package Xindus.Productwishlist.Controller;

import Xindus.Productwishlist.DTOs.AddUserDto;
import Xindus.Productwishlist.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public ResponseEntity<?> addUser(@RequestBody AddUserDto dto){
        try{
            String response = userService.addUser(dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
