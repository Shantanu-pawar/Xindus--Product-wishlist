package Xindus.Productwishlist.Service;

import Xindus.Productwishlist.DTOs.AddUserDto;
import Xindus.Productwishlist.Entity.UserEntity;
import Xindus.Productwishlist.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(AddUserDto dto) {
        UserEntity user = new UserEntity(dto.getName(), dto.getPassword());
        userRepository.save(user);
        return "New user added successfully";
    }
}
