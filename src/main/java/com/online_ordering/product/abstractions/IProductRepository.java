package com.online_ordering.product.abstractions;

import com.online_ordering.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {


    //SELECT p.id ,p.name ,p.description ,p.price ,CASE WHEN op.id IS NULL THEN 0 ELSE 1 END AS on_order FROM online_ordering_db.products p LEFT JOIN online_ordering_db.order_products op ON p.id = op.product_id
    //@Query(value = "SELECT id, name, description, price FROM online_ordering_db.products", nativeQuery = true)

    @Query(value = "SELECT DISTINCT p.id ,p.name ,p.description ,p.price ,CASE WHEN op.id IS NULL THEN 0 ELSE 1 END AS on_order FROM online_ordering_db.products p LEFT JOIN online_ordering_db.order_products op ON p.id = op.product_id", nativeQuery = true)
    List<Product> GetAllProducts();

    @Transactional
    @Query(value = "SELECT p.id ,p.name ,p.description ,p.price ,CASE WHEN op.id IS NULL THEN 0 ELSE 1 END AS on_order FROM online_ordering_db.products p LEFT JOIN online_ordering_db.order_products op ON p.id = op.product_id WHERE p.id = :id", nativeQuery = true)
    Product GetProductFromID(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO online_ordering_db.products (name, description, price) VALUES (:name, :description, :price)", nativeQuery = true)
    void AddProduct(@Param("name") String name, @Param("description") String description, @Param("price") String price);

    @Modifying
    @Transactional
    @Query(value = "UPDATE online_ordering_db.products SET name = :name, description = :description, price = :price WHERE id = :id", nativeQuery = true)
    void ModifyProduct(@Param("id") int id, @Param("name") String name, @Param("description") String description, @Param("price") String price);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM online_ordering_db.products WHERE id = :id", nativeQuery = true)
    void DeleteProductFromID(@Param("id") int id);
}
