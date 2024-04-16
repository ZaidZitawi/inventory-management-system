package com.example.demo.Controllers;

import com.example.demo.DTO.TransactionDTO;
import com.example.demo.Service.TransactionService;
import com.example.demo.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @PostMapping("/")
    public ResponseEntity<Transaction> logTransaction(@RequestBody TransactionDTO transactionInput) {
        // Assuming that TransactionInputDTO is a class that contains all necessary inputs for creating a transaction
        return ResponseEntity.ok(transactionService.logTransaction(
                transactionInput.getType(),
                transactionInput.getProductId(),  // Ensure that your DTO has getProductId() or similar method to fetch product ID
                transactionInput.getQuantity(),
                transactionInput.getTimestamp()));
    }
}