package Xindus.Productwishlist.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDto {

    private String name;
    private String email;
    private String password;
    private String phoneNumber;


    public UserRegisterDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
