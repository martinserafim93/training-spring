package com.toko.online.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    // field
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String productName;
    private String productCode;
    private String productType;

    // constructor
    public Product() {

    }

    // setter and getter

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductType() {
        return productType;
    }
}
