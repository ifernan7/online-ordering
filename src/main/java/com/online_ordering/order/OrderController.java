package com.online_ordering.order;

import com.online_ordering.order.abstractions.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

    private final IOrderService _orderService;

    public OrderController(IOrderService iorderService) {
        this._orderService = iorderService;
    }

    @GetMapping("/order")
    public ModelAndView Index() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("order/index");
        return modelAndView;
    }

    @GetMapping("/order/create")
    public ModelAndView Create() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("order/create");
        return modelAndView;
    }

    @GetMapping("/order/update")
    public ModelAndView Update() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("order/update");
        return modelAndView;
    }

}