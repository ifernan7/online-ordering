package com.online_ordering.order.abstractions;

import com.online_ordering.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT o.id , u.email , o.order_date , os.status FROM online_ordering_db.orders AS o INNER JOIN online_ordering_db.order_status AS os ON o.status_id = os.id INNER JOIN online_ordering_db.users AS u ON o.user_id = u.id", nativeQuery = true)
    List<Order> GetAllOrders();

    @Query(value = "SELECT o.id , u.email , o.order_date , os.status FROM online_ordering_db.orders AS o INNER JOIN online_ordering_db.order_status AS os ON o.status_id = os.id INNER JOIN online_ordering_db.users AS u ON o.user_id = u.id WHERE o.user_id = :userId", nativeQuery = true)
    List<Order> findOrdersByUserId(int userId);

    @Query( value = "SELECT o.id , u.email , o.order_date , os.status FROM online_ordering_db.orders AS o INNER JOIN online_ordering_db.order_status AS os ON o.status_id = os.id INNER JOIN online_ordering_db.users AS u ON o.user_id = u.id WHERE o.status_id = :statusId", nativeQuery = true)
    List<Order> findOrdersByStatusId(int statusId);

    @Query(value = "SELECT o.id , u.email , o.order_date , os.status FROM online_ordering_db.orders AS o INNER JOIN online_ordering_db.order_status AS os ON o.status_id = os.id INNER JOIN online_ordering_db.users AS u ON o.user_id = u.id WHERE u.email = :email", nativeQuery = true)
    List<Order> findOrdersByUserEmail(String email);

    @Query(value = "DELETE FROM online_ordering_db.orders WHERE id = :id", nativeQuery = true)
    List<Order> DeleteOrderById(int id);
}