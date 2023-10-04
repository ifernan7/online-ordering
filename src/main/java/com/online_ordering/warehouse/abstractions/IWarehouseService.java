package com.online_ordering.warehouse.abstractions;

import com.online_ordering.warehouse.Warehouse;

import java.util.List;

public interface IWarehouseService {
    List<Warehouse> GetAllWarehouses();
}