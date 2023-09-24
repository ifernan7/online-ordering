package com.online_ordering.user.dtos;

import lombok.Data;

@Data
public class CreateUserDTO {
    private String email;
    private String password;
}
