package Xindus.Productwishlist.Controller;

import Xindus.Productwishlist.DTOs.AddProductDto;
import Xindus.Productwishlist.Service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @Autowired private ProductService productService;

    @PostMapping("/new")
    public ResponseEntity<?> addProduct(@RequestBody AddProductDto dto){
        try{
            String response = productService.addProduct(dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") int productId){
        try{
            String response = productService.delete(productId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
