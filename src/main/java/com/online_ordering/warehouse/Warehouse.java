package com.online_ordering.warehouse;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Warehouse {

    @Id
    private int id;

    private String name;

    private String city;
}
