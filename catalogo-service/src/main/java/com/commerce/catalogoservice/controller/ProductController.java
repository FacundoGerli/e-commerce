package com.commerce.catalogoservice.controller;

import com.commerce.catalogoservice.DTO.ProductDTO;
import com.commerce.catalogoservice.model.Product;
import com.commerce.catalogoservice.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService;

    //-1 create
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void createProduct(@RequestBody ProductDTO request) {
        productService.createProduct(request);
    }

    //-2 find by id
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/find/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    //-3 find all
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findAll")
    public List<Product> findAll() {
        return productService.findAll();
    }

    //-3 find by productname
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/find/{productName}")
    public Product findByProductName(String productName) {
        return productService.findProductByProductName(productName);
    }

    //-5 modify
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/modify/{id}")
    public void modProduct(@PathVariable Long id, Product p) {
        productService.modifyProduct(id, p);
    }
}
