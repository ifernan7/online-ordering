package com.online_ordering.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
     @Id
     private int id;

     private String email;
}