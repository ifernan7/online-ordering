package com.online_ordering.infrastructure.abstractions;
import com.online_ordering.domain.User;
import java.util.List;

public interface IUserService {

     List<User> GetAllUsers();
}