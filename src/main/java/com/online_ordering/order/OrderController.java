package com.online_ordering.order;

import com.online_ordering.order.abstractions.IOrderService;
import com.online_ordering.order.dtos.CreateOrderDTO;
import com.online_ordering.order.dtos.UpdateOrderDTO;
import com.online_ordering.user.dtos.CreateUserDTO;
import com.online_ordering.utilities.Response;
import com.online_ordering.utilities.ViewModelBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
        ViewModelBase<CreateOrderDTO> viewModel = new ViewModelBase<CreateOrderDTO>(new CreateOrderDTO(), null);

        return new ModelAndView("order/create","viewModel",viewModel);
    }

    @PostMapping("/order/create")
    public Object Create(CreateOrderDTO model) {

        ViewModelBase<CreateOrderDTO> viewModel = new ViewModelBase<CreateOrderDTO>(new CreateOrderDTO(), null);

        return new ModelAndView("order/create","viewModel",viewModel);
    }

    @GetMapping("/order/update/{id}")
    public ModelAndView Update(@PathVariable int id){

        Order order = _orderService.GetOrderById(id);

        ViewModelBase<UpdateOrderDTO> viewModel = new ViewModelBase<UpdateOrderDTO>(new UpdateOrderDTO(), null);

        return new ModelAndView("order/update","viewModel",viewModel);
    }

    @PostMapping("/order/update")
    public Object Update(UpdateOrderDTO model) {
        
        ViewModelBase<UpdateOrderDTO> viewModel = new ViewModelBase<UpdateOrderDTO>(new UpdateOrderDTO(), null);

        return new ModelAndView("order/update","viewModel",viewModel);
    }

    @GetMapping("/order/delete/{id}")
    public RedirectView Delete(@PathVariable int id) {

        return new RedirectView("/order");
    }
}