package com.example.demo.Service;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.model.Product;
import com.example.demo.model.Supplier;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepository;

    @Autowired
    private SupplierRepo supplierRepository;

    public Product createProduct(ProductDTO productDto) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setCategory(productDto.getCategory());
        product.setUnit(productDto.getUnit());
        product.setPrice(productDto.getPrice());

        // Fetch the existing supplier using the supplied ID
        Supplier supplier = supplierRepository.findById(productDto.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + productDto.getSupplierId()));

        product.setSupplier(supplier);

        return productRepository.save(product);
    }

    @Autowired  // This annotation is optional on constructors in Spring 4.3+
    public ProductService(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        if (product.getProductName() == null) {
            throw new IllegalArgumentException("Product name must not be null");
        }
        return productRepository.save(product);
    }


    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
