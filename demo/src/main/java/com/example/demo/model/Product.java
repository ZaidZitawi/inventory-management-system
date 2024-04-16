package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private int productId;

    @Column(name = "ProductName", nullable = false)
    private String productName;

    @Column(name = "Category", nullable = false)
    private String category;

    @ManyToOne
    @JoinColumn(name = "SupplierID", referencedColumnName = "SupplierID", nullable = false)
    private Supplier supplier;

    @Column(name = "Unit", nullable = false)
    private String unit;

    @Column(name = "Price", nullable = false)
    private double price;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Inventory> inventories;
}


