package Xindus.Productwishlist.Controller;

import Xindus.Productwishlist.DTOs.AddProductDto;
import Xindus.Productwishlist.Entity.Product;
import Xindus.Productwishlist.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductControllerTest {

    ProductService productService = mock(ProductService.class);
    ProductController productController = new ProductController(productService);

    @Test
    void testAddProduct_Success() throws Exception {
        AddProductDto addProductDto = new AddProductDto();
        when(productService.addProduct(addProductDto)).thenReturn("Product added successfully");

        ResponseEntity<?> responseEntity = productController.addProduct(addProductDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Product added successfully", responseEntity.getBody());
    }

    @Test
    void testAddProduct_Exception() throws Exception {
        AddProductDto addProductDto = new AddProductDto();
        when(productService.addProduct(addProductDto)).thenThrow(new RuntimeException("Error adding product"));

        ResponseEntity<?> responseEntity = productController.addProduct(addProductDto);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Error adding product", responseEntity.getBody());
    }

    @Test
    void testDeleteProduct_Success() {
        int productId = 123;
        when(productService.delete(productId)).thenReturn("Product deleted successfully");

        ResponseEntity<?> responseEntity = productController.deleteProduct(productId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Product deleted successfully", responseEntity.getBody());
    }

    @Test
    void testDeleteProduct_Exception() {
        int productId = 123;
        when(productService.delete(productId)).thenThrow(new RuntimeException("Error deleting product"));

        ResponseEntity<?> responseEntity = productController.deleteProduct(productId);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Error deleting product", responseEntity.getBody());
    }

    @Test
    void testGetAllProducts_Success() {
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        when(productService.getAllProducts()).thenReturn(products);

        ResponseEntity<?> responseEntity = productController.getAllProducts();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(products, responseEntity.getBody());
    }

    @Test
    void testGetAllProducts_Exception() {
        when(productService.getAllProducts()).thenThrow(new RuntimeException("Error retrieving products"));

        ResponseEntity<?> responseEntity = productController.getAllProducts();

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Error retrieving products", responseEntity.getBody());
    }
}
