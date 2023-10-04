package com.online_ordering.warehouse;

import com.online_ordering.warehouse.abstractions.IWarehouseRepository;
import com.online_ordering.warehouse.abstractions.IWarehouseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService implements IWarehouseService {
    private final IWarehouseRepository _warehouseRepository;

    public WarehouseService(IWarehouseRepository warehouseRepository) {
        this._warehouseRepository = warehouseRepository;
    }

    public List<Warehouse> GetAllWarehouses() {
        return _warehouseRepository.GetAllWarehouses();
    }
}
