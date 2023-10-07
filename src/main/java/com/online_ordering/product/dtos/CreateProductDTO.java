package com.online_ordering.product.dtos;

import lombok.Data;

@Data
public class CreateProductDTO {
    private String name;
    private String description;
    private String price;
}
