package com.commerce.catalogoservice.repository;

import com.commerce.catalogoservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository <Product, Long> {
    @Query("SELECT p from Product p where p.productName = :productName")
    Product findByProductName (String productName);

    List<Product> findByproductNameContaining(String namePart);
    List<Product> findByCategory(String category);
}
