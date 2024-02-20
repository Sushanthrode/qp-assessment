package com.qp.QP.Controller;

import com.qp.QP.Data.GroceryItem;
import com.qp.QP.Data.Order;
import com.qp.QP.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

   @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userPage()
    {
        return "Welcome to QuestionPro User Portal";
    }

    @GetMapping("/grocery-items")
    public List<GroceryItem> viewAvailableGroceryItems() {
        return userService.viewAvailableGroceryItems();
    }

    @PostMapping("/order")
    public Order placeOrder(@RequestBody List<Long> itemIds) {
        return userService.placeOrder(itemIds);
    }
}
