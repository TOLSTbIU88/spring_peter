package org.example.dto;

import lombok.*;

@ToString
@Getter @Setter
@AllArgsConstructor
@Builder
public class CarDtoRs {
    private String name;
    private Double mileage;
    private Integer carAge;
    private Double carPrice;
}
