package com.online_ordering.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class OrderProduct {
    @Id
    private int id;
    private String name;
    private String description;
    private String price;
    private int quantity;
}
