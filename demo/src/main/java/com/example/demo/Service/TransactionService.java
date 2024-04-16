package com.example.demo.Service;

import com.example.demo.model.Product;
import com.example.demo.model.Transaction;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepository;

    @Autowired
    private ProductRepo productRepository;
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction logTransaction(String type, int productId, int quantity, LocalDateTime timestamp) {
        Transaction transaction = new Transaction();
        transaction.setType(type);
        // Fetch the product by id and set it
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + productId));
        transaction.setProduct(product);
        transaction.setQuantity(quantity);
        transaction.setTimestamp(timestamp);
        return transactionRepository.save(transaction);
    }
}