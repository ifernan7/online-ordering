package com.online_ordering.order;

import com.online_ordering.order.abstractions.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private IOrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrders() {
        return orderRepository.GetAllOrders();
    }

    public Order updateOrder(Order updatedOrder) {
        if (orderRepository.existsById(updatedOrder.getId())) {
            return orderRepository.save(updatedOrder);
        }
        return null;
    }
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}