package Xindus.Productwishlist.Service;

import Xindus.Productwishlist.DTOs.AddProductDto;
import Xindus.Productwishlist.Entity.Product;
import Xindus.Productwishlist.Entity.UserEntity;
import Xindus.Productwishlist.Repository.ProductRepository;
import Xindus.Productwishlist.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public String addProduct(AddProductDto dto) throws Exception{
        Optional<UserEntity> userOptional = userRepository.findById(dto.getUserId());
        if(!userOptional.isPresent())
            throw new RuntimeException("this user is not present in database");

        UserEntity user = userOptional.get();
        Product product = new Product(dto.getProductName(), dto.getDescription(), dto.getPrice());
        product.setUser(user);
        productRepository.save(product);
        return "Products added successfully";
    }

    public String delete(int productId) {
        Product product = productRepository.findById(productId).get();
        productRepository.delete(product);
        return "product deleted Successfully";
    }
}
