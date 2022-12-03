package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class CarDtoRq {
    private String mark;
    private String model;
    @JsonProperty("history")
    private CarHistory carHistory;

    @ToString
    @Setter @Getter
    public static class CarHistory {
        @JsonProperty("created_year")
        private Integer createdYear;
        private Double mileage;
        @JsonProperty("count_owners")
        private Integer owners;
    }
}
