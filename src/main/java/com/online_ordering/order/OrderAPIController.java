package com.online_ordering.order;

import com.online_ordering.order.abstractions.IOrderService;
import com.online_ordering.order.dtos.UpdateOrderDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderAPIController {

    private final IOrderService _orderService;

    public OrderAPIController(IOrderService iorderService) {
        this._orderService = iorderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<Object> GetAllOrders() {
        List<Order> orders = _orderService.GetAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("/update")
    public String updateOrder(@RequestBody UpdateOrderDTO updateOrderDTO) {

        for (int index = 0; index < updateOrderDTO.productId.length; index++) {
            _orderService.AddToOrder(updateOrderDTO.orderId, updateOrderDTO.productId[index], 1);
        }

        return "Order updated successfully!";
    }
}