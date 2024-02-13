package Xindus.Productwishlist.DTOs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddProductDto {

    private String productName;

    private String description;

    private double price;

    private  int userId;
}
