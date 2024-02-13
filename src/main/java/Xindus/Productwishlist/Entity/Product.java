package Xindus.Productwishlist.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String productName;

    private String description;

//    String productImg;

    private double price;

    @ManyToOne
    @JoinColumn
    private UserEntity user;

    public Product(String productName, String description, double price) {
        this.productName = productName;
        this.description = description;
        this.price = price;
    }
}
