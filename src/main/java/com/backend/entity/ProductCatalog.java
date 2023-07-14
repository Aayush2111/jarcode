package com.backend.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ProductCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String Description;

    public String getDescription() {
        return Description;
    }

    @Override
    public String toString() {
        return "ProductCatalog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Description='" + Description + '\'' +
                ", productCode='" + productCode + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", deliverable=" + deliverable +
                ", expectedDeliveryTime='" + expectedDeliveryTime + '\'' +
                '}';
    }

    public void setDescription(String description) {
        Description = description;
    }

    private String productCode;
    private String brand;
    private BigDecimal price;
    private boolean deliverable;
    private String expectedDeliveryTime;

    public boolean isDeliverable() {
        return deliverable;
    }

    public void setDeliverable(boolean deliverable) {
        this.deliverable = deliverable;
    }

    public String getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }

    public void setExpectedDeliveryTime(String expectedDeliveryTime) {
        this.expectedDeliveryTime = expectedDeliveryTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
