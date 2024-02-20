package com.qp.QP.Service;

import com.qp.QP.Data.GroceryItem;
import com.qp.QP.Repository.GroceryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final GroceryItemRepository groceryItemRepository;

    public AdminService(GroceryItemRepository groceryItemRepository) {
        this.groceryItemRepository = groceryItemRepository;
    }

    public GroceryItem addGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    public List<GroceryItem> viewAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public void removeGroceryItem(Long itemId) {
        groceryItemRepository.deleteById(itemId);
    }

    public GroceryItem updateGroceryItem(Long itemId, GroceryItem updatedItem) {
        GroceryItem existingItem = groceryItemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Grocery Item not found"));

        existingItem.setName(updatedItem.getName());
        existingItem.setPrice(updatedItem.getPrice());
        existingItem.setQuantity(updatedItem.getQuantity());

        return groceryItemRepository.save(existingItem);
    }

    public void manageInventory(Long itemId, int quantity) {
        GroceryItem existingItem = groceryItemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Grocery Item not found"));

        existingItem.setQuantity(existingItem.getQuantity() + quantity);
        groceryItemRepository.save(existingItem);
    }
}
