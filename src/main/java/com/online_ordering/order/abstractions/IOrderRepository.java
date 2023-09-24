package com.online_ordering.order.abstractions;

import com.online_ordering.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT * FROM Order", nativeQuery = true)
    List<Order> GetAllOrders();

    @Query("SELECT o FROM Order o WHERE o.user_id = ?1")
    List<Order> findOrdersByUserId(int userId);

    @Query("SELECT o FROM Order o WHERE o.status_id = ?1")
    List<Order> findOrdersByStatusId(int statusId);

    @Query("SELECT o FROM Order o WHERE o.order_date BETWEEN ?1 AND ?2")
    List<Order> findOrdersWithinDateRange(Date startDate, Date endDate);

    @Query(value = "SELECT o.* FROM orders o JOIN users u ON o.user_id = u.id WHERE u.email = ?1", nativeQuery = true)
    List<Order> findOrdersByUserEmail(String email);

    @Query(value = "SELECT o.* FROM orders o JOIN order_status os ON o.status_id = os.id WHERE os.status = ?1", nativeQuery = true)
    List<Order> findOrdersByStatusDescription(String statusDescription);

    @Query(value = "SELECT o.* FROM orders o JOIN order_products op ON o.id = op.order_id JOIN products p ON op.product_id = p.id WHERE p.name = ?1", nativeQuery = true)
    List<Order> findOrdersByProductName(String productName);

}