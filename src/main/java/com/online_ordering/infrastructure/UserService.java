package com.online_ordering.infrastructure;

import com.online_ordering.domain.User;
import com.online_ordering.infrastructure.abstractions.IUserService;
import com.online_ordering.repository.IUserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements IUserService {

    private final IUserRepository _userRepository;

    public UserService(IUserRepository userRepository) {
        this._userRepository = userRepository;
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

    public List<User> GetUserById(int id) {
        return _userRepository.GetUserById(id);
    }

    public void DeleteUserById(int id) {
        _userRepository.DeleteUserById(id);
    }

}