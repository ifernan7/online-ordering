package com.online_ordering.order.abstractions;

import com.online_ordering.order.Order;

import java.util.List;

public interface IOrderService {
    static List<Order> GetAllOrders() {
        return null;
    }

    List<Order> findOrdersByUserId(int userId);

    List<Order> findOrdersByStatusId(int statusId);

    List<Order> findOrdersByUserEmail(String email);

    void DeleteOrderById(int id);
}