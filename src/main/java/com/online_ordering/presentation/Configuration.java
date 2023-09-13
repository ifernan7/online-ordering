package com.online_ordering.presentation;

import com.online_ordering.infrastructure.abstractions.IUserService;
import com.online_ordering.infrastructure.UserService;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;

import com.online_ordering.repository.UserRepository;
import com.online_ordering.repository.abstractions.IUserRepository;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public LayoutDialect layoutDialect() {

        return new LayoutDialect();
    }

    @Bean
    public IUserRepository UserRepository() {
        return new UserRepository();
    }

    @Bean
    public IUserService UserService(){
        return new UserService(UserRepository());
    }
}