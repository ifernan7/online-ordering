package com.online_ordering.order.abstractions;

import com.online_ordering.order.Order;
import com.online_ordering.order.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface IOrderProductRepository extends JpaRepository<OrderProduct, Long> {

    @Query(value = "select op.id ,p.name, p.description ,p.price ,op.quantity, op.product_id from online_ordering_db.order_products op INNER JOIN online_ordering_db.orders o ON op.order_id  = o.id INNER JOIN online_ordering_db.products p ON op.product_id = p.id WHERE op.order_id = :id", nativeQuery = true)
    List<OrderProduct> GetProductsOnOrder(@Param("id") int id);
}