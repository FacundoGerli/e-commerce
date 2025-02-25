package com.commerce.catalogoservice.service;

import com.commerce.catalogoservice.DTO.ProductDTO;
import com.commerce.catalogoservice.model.Product;
import com.commerce.catalogoservice.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ProductService implements IProductService{
    private final IProductRepository productRepository;

    @Override
    public void createProduct(ProductDTO request) {
        var product = Product.builder()
                .productName(request.productName())
                .productDescription(request.productDescription())
                .unitPrice(request.unitPrice())
                .build();
        productRepository.save(product);

    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product findProductByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByStringContains(String contains) {
        return productRepository.findByproductNameContaining(contains);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public void modifyProduct(Long id, Product product) {

        var p = this.findProductById(id);

        p.setProductName(product.getProductName());
        p.setProductDescription(product.getProductDescription());
        p.setUnitPrice(product.getUnitPrice());

        productRepository.save(p);
    }
}
