package com.backend.dao;

import com.backend.entity.ProductCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductCatalog, Long> {
    List<ProductCatalog> findByNameContainingIgnoreCaseAndProductCodeContainingIgnoreCaseAndBrandContainingIgnoreCase(String name, String productCode, String brand);

    Optional<ProductCatalog> findById(Long id);
}
