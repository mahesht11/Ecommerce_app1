package com.ecom.product.service;

import com.ecom.product.dto.ProductRequest;
import com.ecom.product.dto.ProductResponse;
import com.ecom.product.entity.Product;
import com.ecom.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setCategory(productRequest.getCategory());
        product.setDescription(productRequest.getDescription());
        product.setStockQuantity(productRequest.getStockQuantity());
        product.setImage(productRequest.getImageUrl());
        product.setIsActive(true);
        Product product1 = productRepository.save(product);
        ProductResponse response = new ProductResponse();
        response.setName(product1.getName());
        response.setPrice(product1.getPrice());
        response.setCategory(product1.getCategory());
        response.setDescription(product1.getDescription());
        response.setStockQuantity(product1.getStockQuantity());
        response.setImageUrl(product1.getImage());
        response.setActive(product1.getIsActive());

        return response;
    }
}
