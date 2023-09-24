package com.online_ordering.product;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Product {
    private int id;
    private String stockNumber;
    private String name;
    private String description;
}