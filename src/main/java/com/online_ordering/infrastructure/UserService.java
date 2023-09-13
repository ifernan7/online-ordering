package com.online_ordering.infrastructure;

import com.online_ordering.infrastructure.abstractions.IUserService;
import com.online_ordering.repository.abstractions.IUserRepository;

public class UserService implements IUserService {

    private final IUserRepository _userRepository;

    public UserService(IUserRepository userRepository) {

        this._userRepository = userRepository;
    }

    public String GetUserByEmail(){
        return _userRepository.GetUserByEmail();
    }
}
