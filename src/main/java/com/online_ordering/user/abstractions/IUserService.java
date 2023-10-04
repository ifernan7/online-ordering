package com.online_ordering.user.abstractions;

import com.online_ordering.user.User;
import com.online_ordering.utilities.Response;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserService {

     List<User> GetAllUsers();

     void AddUser(String email, String password);

     Response<Boolean> UpdateUserEmailById(int id, String email);

     User GetUserById(int id);

     void DeleteUserById(int id);
}