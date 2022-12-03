package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    private String name;
    private String model;
    private Integer createdYear;
    private Double mileage;
    private Double price;
}
