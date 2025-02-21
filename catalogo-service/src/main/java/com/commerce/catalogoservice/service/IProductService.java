package com.commerce.catalogoservice.service;

import com.commerce.catalogoservice.DTO.ProductDTO;
import com.commerce.catalogoservice.model.Product;

import java.util.List;

public interface IProductService {
    public void createProduct(ProductDTO request);
    public Product findProductById(Long id);
    public Product findProductByProductName(String name);
    public List<Product> findAll();
    public void modifyProduct(Long id, Product product);
}
