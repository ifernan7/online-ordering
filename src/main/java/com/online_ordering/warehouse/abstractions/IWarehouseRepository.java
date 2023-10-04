package com.online_ordering.warehouse.abstractions;

import com.online_ordering.warehouse.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IWarehouseRepository extends JpaRepository<Warehouse, Long> {

    @Query(value = "SELECT w.id, w.name, w.city FROM online_ordering_db.warehouses AS w", nativeQuery = true)
    List<Warehouse> GetAllWarehouses();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO online_ordering_db.warehouses (name, city) VALUES (:name, :city)", nativeQuery = true)
    void AddWarehouse(@Param("name") String name, @Param("city") String city);
}
