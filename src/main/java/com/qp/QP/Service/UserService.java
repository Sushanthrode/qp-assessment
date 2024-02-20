package com.qp.QP.Service;

import com.qp.QP.Data.GroceryItem;
import com.qp.QP.Data.Order;
import com.qp.QP.Repository.GroceryItemRepository;
import com.qp.QP.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final GroceryItemRepository groceryItemRepository;
    private final OrderRepository orderRepository;

    public UserService(GroceryItemRepository groceryItemRepository, OrderRepository orderRepository) {
        this.groceryItemRepository = groceryItemRepository;
        this.orderRepository = orderRepository;
    }

    public List<GroceryItem> viewAvailableGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public Order placeOrder(List<Long> itemIds) {
        List<GroceryItem> items = groceryItemRepository.findAllById(itemIds);

        if (items.isEmpty()) {
            throw new RuntimeException("No items found for provided ids");
        }

        Order order = new Order();
        order.setItems(items);

        return orderRepository.save(order);
    }
}