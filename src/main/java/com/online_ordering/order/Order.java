package com.online_ordering.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Order {
    @Id
    private Long id;

    private int user_id;

    private Date order_date;

    private int status_id;
}

