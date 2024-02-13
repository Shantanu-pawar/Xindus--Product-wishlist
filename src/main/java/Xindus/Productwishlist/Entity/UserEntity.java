package Xindus.Productwishlist.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String name;

    // if this works then we can add user's address, phone no etc etc
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();

    public UserEntity(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
