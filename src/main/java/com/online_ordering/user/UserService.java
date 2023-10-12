package com.online_ordering.user;

import com.online_ordering.order.Order;
import com.online_ordering.order.abstractions.IOrderRepository;
import com.online_ordering.user.abstractions.IUserRepository;
import com.online_ordering.user.abstractions.IUserService;
import com.online_ordering.utilities.Response;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public Response<Boolean> AddUser(String email, String password) {

        if (email.isBlank() && password.isBlank()) {
            return new Response<Boolean>(false,"Please enter email and password.");
        }

        if (email.isBlank()) {
            return new Response<Boolean>(false,"Please enter email.");
        }

        if (password.isBlank()) {
            return new Response<Boolean>(false,"Please enter password.");
        }

        List<User> users = _userRepository.GetAllUsers();

        for (User user : users) {
            if(user.getEmail().equals(email)) {
                return new Response<Boolean>(false, "Email already exists, please enter different email.");
            }
        }

        _userRepository.AddUser(email,password);

         users = _userRepository.GetAllUsers();

        for (User user : users) {
            if(user.getEmail().equals(email)) {
                return new Response<Boolean>(true, "good job the user got added correctly!!");
            }
        }

        return new Response<Boolean>(false,"failure please try again...");
    }

    public Response<Boolean> UpdateUserEmailById(int id, String email) {

        if(!email.isBlank()) {
            List<User> users = _userRepository.GetAllUsers();

            for (User user : users) {
                if(user.getEmail().equals(email)) {
                    return new Response<Boolean>(false, "Email already exists, please enter different email.");
                }
            }
        }
        else{
            return new Response<Boolean>(false, "Please enter an email, email cannot be empty text.");
        }

        _userRepository.UpdateUserEmailById(id, email);

        return new Response<Boolean>(true, "Update Succeeded.");
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