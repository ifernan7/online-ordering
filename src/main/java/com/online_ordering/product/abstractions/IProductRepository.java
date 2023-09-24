package com.online_ordering.product.abstractions;

import com.online_ordering.product.Product;
import com.online_ordering.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT id, name, description, price FROM online_ordering_db.products", nativeQuery = true)
    List<User> GetAllProducts();

    @Modifying
    @Transactional
    @Query(value = "SELECT id, name, description, price FROM online_ordering_db.products WHERE id = :id", nativeQuery = true)
    void GetProductFromID(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO online_ordering_db.products (name, description, price) VALUES (:name, :description, :price)", nativeQuery = true)
    void AddProduct(@Param("name") String name, @Param("description") String description, @Param("price") String price);

    @Modifying
    @Transactional
    @Query(value = "UPDATE online_ordering_db.products SET (name, description, price) VALUES (:name, :description, :price) WHERE id = :id", nativeQuery = true)
    void ModifyProduct(@Param("id") int id, @Param("name") String name, @Param("description") String description, @Param("price") String price);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM online_ordering_db.products WHERE id = :id", nativeQuery = true)
    void DeleteProductFromID(@Param("id") int id);
}
