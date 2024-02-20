package com.qp.QP.Controller;

import com.qp.QP.Data.GroceryItem;
import com.qp.QP.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public String adminPage()
    {
        return "Welcome to QuestionPro Admin Home Page";
    }
    @PostMapping("/grocery-item")
    public GroceryItem addGroceryItem(@RequestBody GroceryItem groceryItem) {
        return adminService.addGroceryItem(groceryItem);
    }

    @GetMapping("/grocery-items")
    public List<GroceryItem> viewAllGroceryItems() {
        return adminService.viewAllGroceryItems();
    }

    @DeleteMapping("/grocery-item/{itemId}")
    public void removeGroceryItem(@PathVariable Long itemId) {
        adminService.removeGroceryItem(itemId);
    }

    @PutMapping("/grocery-item/{itemId}")
    public GroceryItem updateGroceryItem(@PathVariable Long itemId, @RequestBody GroceryItem updatedItem) {
        return adminService.updateGroceryItem(itemId, updatedItem);
    }

    @PostMapping("/manage-inventory/{itemId}")
    public void manageInventory(@PathVariable Long itemId, @RequestParam int quantity) {
        adminService.manageInventory(itemId, quantity);
    }
}