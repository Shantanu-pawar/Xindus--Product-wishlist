package Xindus.Productwishlist.Service;

import Xindus.Productwishlist.DTOs.LoginUserDto;
import Xindus.Productwishlist.DTOs.UserRegisterDto;
import Xindus.Productwishlist.Enum.Role;
import Xindus.Productwishlist.Entity.UserEntity;
import Xindus.Productwishlist.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public String registerUser(UserRegisterDto dto) {
        UserEntity user = new UserEntity();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

//        since this assignment not explicitly mention any admin roles so for security
//        purpose just giving the user role
        user.setRole(Role.USER);
        userRepository.save(user);
        return "New user added successfully";
    }


    public String login(LoginUserDto loginDto) {

        Optional<UserEntity> userOp = userRepository.findByEmail(loginDto.getEmail());
        if(!userOp.isPresent()) return "check your email";

        UserEntity user = userOp.get();

        boolean check = false;
        check = passwordEncoder.matches(loginDto.getPassword(), user.getPassword());

        if (check) return "Successfully login";
        return "put valid credentials";
    }
}
