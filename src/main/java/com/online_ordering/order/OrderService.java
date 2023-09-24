package com.online_ordering.order;

import com.online_ordering.order.abstractions.IOrderRepository;
import com.online_ordering.order.abstractions.IOrderService;
import ognl.enhance.OrderedReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService implements IOrderService {

    @Autowired
    public IOrderRepository _orderRepository;

    public OrderService(IOrderRepository orderRepository) {
        this._orderRepository = orderRepository;
    }

    public List<Order> GetAllOrders() {
        return _orderRepository.GetAllOrders();
    }

    public List<Order> findOrdersByUserId(int userId) {
        return _orderRepository.findOrdersByUserId(userId);
    }

    public List<Order> findOrdersByStatusId(int statusId) {
        return _orderRepository.findOrdersByStatusId(statusId);
    }

    public List<Order> findOrdersByUserEmail(String email) {
        return _orderRepository.findOrdersByUserEmail(email);
    }

    public void DeleteOrderById(int id) {
        _orderRepository.DeleteOrderById(id);
    }
}