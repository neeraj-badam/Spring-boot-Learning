package com.telusko.WebApp.repository;

import com.telusko.WebApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query("SELECT p from Product p WHERE " +
    "LOWER(p.name) like LOWER(CONCAT( '%', :keyword, '%')) OR " +
    "LOWER(p.brand) like LOWER(CONCAT( '%', :keyword, '%')) OR " +
    "LOWER(p.description) like LOWER(CONCAT( '%', :keyword, '%')) OR " +
    "LOWER(p.category) like LOWER(CONCAT( '%', :keyword, '%')) "
    )
    List<Product> searchProducts(String keyword);
}
 */

public interface ProductRepo{

}