package com.online_ordering.warehouse;

import com.online_ordering.user.dtos.CreateUserDTO;
import com.online_ordering.warehouse.abstractions.IWarehouseService;
import com.online_ordering.warehouse.dtos.CreateWarehouseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class WarehouseController {

    private final IWarehouseService _warehouseService;

    public WarehouseController(IWarehouseService warehouseService) {
        this._warehouseService = warehouseService;
    }

    @GetMapping("/warehouse")
    public ModelAndView Index() {
        ModelAndView modelAndView = new ModelAndView();

        List<Warehouse> warehouses = _warehouseService.GetAllWarehouses();

        modelAndView.addObject("warehouses", warehouses);

        modelAndView.setViewName("warehouse/index");

        return modelAndView;
    }

    @GetMapping("/warehouse/create")
    public ModelAndView Create() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("warehouse/create");

        return modelAndView;
    }

    @PostMapping("/warehouse/create")
    public RedirectView Create(CreateWarehouseDTO model) {

        _warehouseService.AddWarehouse(model.getName(), model.getCity());

        return new RedirectView("/warehouse");
    }

}
