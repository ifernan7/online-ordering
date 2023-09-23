package com.online_ordering.order.abstractions;

import com.online_ordering.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT id, user_id, order_date, status_id FROM online_ordering_db.orders", nativeQuery = true)
    List<Order> GetAllOrders();
}