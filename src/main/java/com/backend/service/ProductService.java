package com.backend.service;

import com.backend.dao.ProductRepository;
import com.backend.entity.ProductCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductCatalog> searchProducts(String name, String productCode, String brand) {
        return productRepository.findByNameContainingIgnoreCaseAndProductCodeContainingIgnoreCaseAndBrandContainingIgnoreCase(name,productCode,brand);
    }

    public Optional<ProductCatalog> findById(Long id) {
        return productRepository.findById(id);
    }

    public BigDecimal getProductPrice(Long id) {

        Optional<ProductCatalog> productCatalog = productRepository.findById(id);
        if(productCatalog!=null){
            return productCatalog.get().getPrice();
        }
        return BigDecimal.ZERO;
    }
}
