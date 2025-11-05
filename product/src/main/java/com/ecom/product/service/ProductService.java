package com.ecom.product.service;

import aj.org.objectweb.asm.commons.Remapper;
import com.ecom.product.dto.ProductRequest;
import com.ecom.product.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();

    ProductResponse updateProduct(Long id, ProductRequest productRequest);

    String deleteProduct(Long id);

    ProductResponse findById(Long id);
}
