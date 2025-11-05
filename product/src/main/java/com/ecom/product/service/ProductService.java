package com.ecom.product.service;

import com.ecom.product.dto.ProductRequest;
import com.ecom.product.dto.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);
}
