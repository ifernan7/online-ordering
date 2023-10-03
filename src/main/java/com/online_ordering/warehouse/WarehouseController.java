package com.online_ordering.warehouse;

import com.online_ordering.warehouse.abstractions.IWarehouseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WarehouseController {

    private final IWarehouseService _warehouseService;

    public WarehouseController(IWarehouseService warehouseService) {
        this._warehouseService = warehouseService;
    }

    @GetMapping("/warehouse")
    public ModelAndView Index() {
        ModelAndView modelAndView = new ModelAndView();

//        modelAndView.addObject("users", users);

        modelAndView.setViewName("warehouse/index");
        return modelAndView;
    }
}
