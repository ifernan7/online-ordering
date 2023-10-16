package com.online_ordering.order;

import com.online_ordering.order.abstractions.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderController {

    private final IOrderService _orderService;

    public OrderController(IOrderService iorderService) {
        this._orderService = iorderService;
    }

    @GetMapping("/order")
    public ModelAndView Index() {

        List<Order> orders = _orderService.GetAllOrders();

        return new ModelAndView("order/index", "orders", orders);
    }

    @GetMapping("/order/create")
    public ModelAndView Create() {
        return new ModelAndView("order/create");
    }

    @GetMapping("/order/update")
    public ModelAndView Update() {
        return new ModelAndView("order/create");
    }
}