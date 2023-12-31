package com.online_ordering.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    private int id;
    private String name;
    private String description;
    private String price;
    private boolean onOrder;
}