package com.online_ordering.order;

import com.online_ordering.order.abstractions.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

    private final IOrderService _orderService;

    public OrderController(IOrderService iorderService) {
        this._orderService = iorderService;
    }
}