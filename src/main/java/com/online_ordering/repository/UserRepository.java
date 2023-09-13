package com.online_ordering.repository;

import com.online_ordering.repository.abstractions.IUserRepository;

public class UserRepository implements IUserRepository{

    public String GetUserByEmail(){
        return "Ismael";
    }
}