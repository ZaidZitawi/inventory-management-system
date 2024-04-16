package com.example.demo.Service;

import com.example.demo.model.Inventory;
import com.example.demo.repository.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepo inventoryRepository;

    public List<Inventory> getAllInventoryItems() {
        return inventoryRepository.findAll();
    }

    public Inventory updateInventoryByProductId(int productId, int quantity, String location) {
        Inventory inventory = inventoryRepository.findByProductProductId(productId).get(0); // Simplified for example
        inventory.setQuantity(quantity);
        inventory.setWarehouseLocation(location);
        return inventoryRepository.save(inventory);
    }
}