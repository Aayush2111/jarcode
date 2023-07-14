package com.backend.controllers;

import com.backend.entity.ProductCatalog;
import com.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductCatalog> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String productCode,
            @RequestParam(required = false) String brand

    ) {
        return productService.searchProducts(name, productCode, brand);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCatalog> getProductById(@PathVariable Long id) {
        Optional<ProductCatalog> optionalProduct = productService.findById(id);
        if (optionalProduct.isPresent()) {
            ProductCatalog productCatalog = optionalProduct.get();
            return ResponseEntity.ok(productCatalog);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/price")
    public ResponseEntity<ProductCatalog> getProductPrice(@PathVariable Long id) {

        BigDecimal price = productService.getProductPrice(id);

        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.setId(id);
        productCatalog.setPrice(price);

        return ResponseEntity.ok(productCatalog);
    }
}
