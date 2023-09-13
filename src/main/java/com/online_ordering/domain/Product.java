package com.online_ordering.domain;

import lombok.Data;

@Data
public class Product {
    private String stockNumber;
    private String name;
    private String description;
}