package com.online_ordering.infrastructure;

import com.online_ordering.domain.User;
import com.online_ordering.infrastructure.abstractions.IUserService;
import com.online_ordering.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final IUserRepository _userRepository;

    public UserService(IUserRepository userRepository) {
        this._userRepository = userRepository;
    }

    public String GetUserByEmail(){
        List<User> users = _userRepository.GetAllUsers();

        return "Ismael";
    }
}
