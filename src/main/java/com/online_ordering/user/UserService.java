package com.online_ordering.user;

import com.online_ordering.order.Order;
import com.online_ordering.order.abstractions.IOrderRepository;
import com.online_ordering.user.abstractions.IUserRepository;
import com.online_ordering.user.abstractions.IUserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements IUserService {

    private final IUserRepository _userRepository;
    private final IOrderRepository _orderRepository;

    public UserService(IUserRepository userRepository, IOrderRepository orderRepository) {
        this._userRepository = userRepository;
        this._orderRepository = orderRepository;
    }

    public List<User> GetAllUsers() {
        return  _userRepository.GetAllUsers();
    }

    public void AddUser(String email, String password) {
        _userRepository.AddUser(email,password);
    }

    public void UpdateUserEmailById(int id, String email) {
        _userRepository.UpdateUserEmailById(id, email);
    }

    public User GetUserById(int id) {
        return _userRepository.GetUserById(id);
    }

    public void DeleteUserById(int id) {

        List<Order> orders = _orderRepository.findOrdersByUserId(id);

        if(orders.isEmpty()){
            _userRepository.DeleteUserById(id);
        }
    }
}