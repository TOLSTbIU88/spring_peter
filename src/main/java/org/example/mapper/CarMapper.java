package org.example.mapper;

import org.example.dto.CarDtoRq;
import org.example.dto.CarDtoRs;
import org.example.entities.Car;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class CarMapper {

    public Car getCarFromCarDtoRq(CarDtoRq carDtoRq) {
        return new Car(carDtoRq.getMark(), carDtoRq.getModel(),
                carDtoRq.getCarHistory().getCreatedYear(),
                carDtoRq.getCarHistory().getMileage(),
                getCarPrice(carDtoRq));
    }

    public Optional<CarDtoRs> getCarDtoRs(Optional<Car> car) {
        return car.map(e -> CarDtoRs.builder()
                .name(e.getName() + " " + e.getModel())
                .mileage(e.getMileage())
                .carAge(LocalDate.now().getYear() - e.getCreatedYear())
                .carPrice(e.getPrice())
                .build()
        );
    }

    private Double getCarPrice(CarDtoRq carDtoRq) {
        Double basePrice = switch (carDtoRq.getMark()) {
            case "bmw" -> 50000.0;
            case "mercedes" -> 70000.0;
            case "kia" -> 35000.0;
            default -> throw new RuntimeException("Нет такой марки машины");
        };

        return basePrice - (carDtoRq.getCarHistory().getMileage() * 0.1)
                * (carDtoRq.getCarHistory().getOwners() > 1 ? 0.8 : 1);
    }
}
