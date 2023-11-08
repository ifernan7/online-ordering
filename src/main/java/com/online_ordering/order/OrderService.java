package com.online_ordering.order;

import com.online_ordering.order.abstractions.IOrderProductRepository;
import com.online_ordering.order.abstractions.IOrderRepository;
import com.online_ordering.order.abstractions.IOrderService;
import com.online_ordering.user.User;
import com.online_ordering.user.abstractions.IUserRepository;
import ognl.enhance.OrderedReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class OrderService implements IOrderService {

    @Autowired
    public IOrderRepository _orderRepository;

    @Autowired
    public IUserRepository _userRepository;

    @Autowired
    public IOrderProductRepository _orderProductRepository;

    public OrderService(IOrderRepository orderRepository, IUserRepository userRepository) {
        this._orderRepository = orderRepository;
        this._userRepository = userRepository;
    }

    public List<Order> GetAllOrders() {
        return _orderRepository.GetAllOrders();
    }

    public List<Order> findOrdersByUserId(int userId) {
        return _orderRepository.findOrdersByUserId(userId);
    }

    public List<Order> findOrdersByStatusId(int statusId) {
        return _orderRepository.findOrdersByStatusId(statusId);
    }

    public List<Order> findOrdersByUserEmail(String email) {
        return _orderRepository.findOrdersByUserEmail(email);
    }

    public void DeleteOrderById(int id) {
        _orderRepository.DeleteOrderById(id);
    }

    public Order GetOrderById(int id) {
        return  _orderRepository.GetOrderById(id);
    }

    public void CreateNewOrder(String email) {

        User user = _userRepository.GetUserByEmail(email);

        _orderRepository.CreateNewOrder(user.getId(), new Date(), 1 );
    }

    public List<OrderProduct> GetProductsOnOrder(int id) {

        List<OrderProduct> products = _orderProductRepository.GetProductsOnOrder(id);

        return  products;
    }

    public void AddToOrder(int order_id, int product_id, int quantity) {
        List<OrderProduct> existingOrderProducts = GetProductsOnOrder(order_id);
        Boolean productFoundInOrder = false;

        for (int i = 0; i < existingOrderProducts.size(); i++) {
            if (existingOrderProducts.get(i).getId() == product_id) {
                productFoundInOrder = true;
            }
        }

        if (!productFoundInOrder) {
            _orderRepository.AddToOrder(order_id, product_id, quantity);
        }
    }
}