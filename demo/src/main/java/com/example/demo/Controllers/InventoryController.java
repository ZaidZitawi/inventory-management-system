package com.example.demo.Controllers;

import com.example.demo.Service.InventoryService;
import com.example.demo.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;//spring bean

    @GetMapping("/")
    public ResponseEntity<List<Inventory>> getAllInventoryItems() {
        return ResponseEntity.ok(inventoryService.getAllInventoryItems());
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable int productId, @RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.updateInventoryByProductId(productId, inventory.getQuantity(), inventory.getWarehouseLocation()));
    }
}