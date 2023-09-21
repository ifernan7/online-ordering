package com.online_ordering.infrastructure.abstractions;
import com.online_ordering.domain.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserService {

     List<User> GetAllUsers();

     void AddUser(String email, String password);

     void UpdateUserEmailById(int id, String email);

     List<User> GetUserById(int id);

     void DeleteUserById(int id);
}