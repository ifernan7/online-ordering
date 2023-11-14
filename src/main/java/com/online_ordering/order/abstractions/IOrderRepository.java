package com.online_ordering.order.abstractions;

import com.online_ordering.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT o.id , u.email , o.create_date , os.status FROM online_ordering_db.orders AS o INNER JOIN online_ordering_db.order_status AS os ON o.status_id = os.id INNER JOIN online_ordering_db.users AS u ON o.user_id = u.id", nativeQuery = true)
    List<Order> GetAllOrders();

    @Query(value = "SELECT o.id , u.email , o.create_date , os.status FROM online_ordering_db.orders AS o INNER JOIN online_ordering_db.order_status AS os ON o.status_id = os.id INNER JOIN online_ordering_db.users AS u ON o.user_id = u.id WHERE o.user_id = :userId", nativeQuery = true)
    List<Order> findOrdersByUserId(int userId);

    @Query(value = "SELECT o.id , u.email , o.create_date , os.status FROM online_ordering_db.orders AS o INNER JOIN online_ordering_db.order_status AS os ON o.status_id = os.id INNER JOIN online_ordering_db.users AS u ON o.user_id = u.id WHERE o.status_id = :statusId", nativeQuery = true)
    List<Order> findOrdersByStatusId(int statusId);

    @Query(value = "SELECT o.id , u.email , o.create_date , os.status FROM online_ordering_db.orders AS o INNER JOIN online_ordering_db.order_status AS os ON o.status_id = os.id INNER JOIN online_ordering_db.users AS u ON o.user_id = u.id WHERE u.email = :email", nativeQuery = true)
    List<Order> findOrdersByUserEmail(String email);

    @Query(value = "DELETE FROM online_ordering_db.orders WHERE id = :id", nativeQuery = true)
    List<Order> DeleteOrderById(int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO online_ordering_db.orders(user_id, create_date, status_id) VALUE(:user_id, :create_date, :status_id);", nativeQuery = true)
    void CreateNewOrder(@Param("user_id") int user_id, @Param("create_date") Date create_date, @Param("status_id") int status_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO online_ordering_db.order_products(order_id, product_id, quantity) VALUE(:order_id, :product_id, :quantity);", nativeQuery = true)
    void AddToOrder(@Param("order_id") int order_id, @Param("product_id") int product_id, @Param("quantity") int quantity);

    @Modifying
    @Transactional
    @Query(value = "UPDATE online_ordering_db.order_products SET quantity = :quantity WHERE order_id = :order_id AND product_id = :product_id", nativeQuery = true)
    void UpdateQuantityOnOrder(@Param("order_id") int order_id, @Param("product_id") int product_id, @Param("quantity") int quantity);


    //When the passed in id has no records the method will return a null Order
    //need to make sure whatever calls this method does a null check..
    @Query(value = "SELECT o.id , u.email , o.create_date , os.status FROM online_ordering_db.orders AS o INNER JOIN online_ordering_db.order_status AS os ON o.status_id = os.id INNER JOIN online_ordering_db.users AS u ON o.user_id = u.id WHERE o.id = :id", nativeQuery = true)
    Order GetOrderById(@Param("id") int id);
}