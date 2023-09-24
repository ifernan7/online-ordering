package com.online_ordering.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Order {
    @Id
    private int id;

    private String email;

    private Date order_date;

    private String status;
}

