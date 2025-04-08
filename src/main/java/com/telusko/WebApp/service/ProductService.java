package com.telusko.WebApp.service;

import com.telusko.WebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.WebApp.model.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public Product getProductById(int id) {
        return productRepo.findById( id ).orElse(null);
    }

    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    public Product addProduct( Product product, MultipartFile image ) throws IOException {
        product.setImageName( image.getOriginalFilename() );
        product.setImageType( image.getContentType() );
        product.setImg( image.getBytes() );
        return productRepo.save( product );
    }

    public Product updateProduct( int id, Product prod, MultipartFile imgFile ) throws IOException {
        prod.setImageName( imgFile.getOriginalFilename() );
        prod.setImageType( imgFile.getContentType() );
        prod.setImg( imgFile.getBytes() );
        return productRepo.save( prod );
    }

    public void deleteProductById(int id) {
        productRepo.deleteById( id );
    }


    public List<Product> searchProducts(String keyword) {
        return productRepo.searchProducts( keyword );
    }
}
 */