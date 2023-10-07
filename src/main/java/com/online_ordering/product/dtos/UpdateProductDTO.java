package com.online_ordering.product.dtos;

import lombok.Data;

@Data
public class UpdateProductDTO {
    private int id;
    private String name;
    private String description;
    private String price;
}
