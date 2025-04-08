package com.telusko.WebApp.controller;

import com.telusko.WebApp.model.*;
import com.telusko.WebApp.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/*
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String greeting( HttpServletRequest request ) {
        return "Enter" + request.getSession().getId();
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        System.out.println("retrieving all products");
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        System.out.println("getProduct");
        Product product = productService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable int id){
        Product prod = productService.getProductById(id);
        return ResponseEntity.ok().contentType(MediaType.valueOf( prod.getImageType() )).body( prod.getImg() );

    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct( @RequestPart Product product, @RequestPart MultipartFile imageFile){
         System.out.println("addProduct");
         try {
             Product prod = productService.addProduct(product, imageFile);
             return new ResponseEntity<>(product, HttpStatus.CREATED);
         } catch (Exception e) {
             return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct( @PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile ){
        Product prod = null;
        try {
            prod = productService.updateProduct( id, product, imageFile );
        } catch (IOException e) {
            return new ResponseEntity<>("Unable to Updated product", HttpStatus.BAD_REQUEST);
        }
        if (prod != null) {
            return new ResponseEntity<>("Updated product", HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Unable to Update product", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct( @PathVariable int id ){
        Product product = productService.getProductById(id);
        if (product != null) {
            productService.deleteProductById( id );
            return new ResponseEntity<>("Deleted product", HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Unable to Delete product", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts( @RequestParam String keyword){
        System.out.println( "Searching for " + keyword );
        List<Product> products = productService.searchProducts( keyword );
        return ResponseEntity.ok().body( products );
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken( HttpServletRequest request ) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
 */