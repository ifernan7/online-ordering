package com.online_ordering.order.abstractions;

import com.online_ordering.order.Order;
import com.online_ordering.order.OrderProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrderService {

    List<Order> GetAllOrders();

    List<Order> findOrdersByUserId(int userId);

    List<Order> findOrdersByStatusId(int statusId);

    List<Order> findOrdersByUserEmail(String email);

    void DeleteOrderById(int id);

    Order GetOrderById(int id);

    void CreateNewOrder(String email);

    List<OrderProduct> GetProductsOnOrder(int id);

    void AddToOrder(int order_id, int product_id, int quantity);

    void UpdateQuantityOnOrder(int order_id, int product_id, int quantity);

}