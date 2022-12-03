package org.example.contorllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.CarDtoRq;
import org.example.dto.CarDtoRs;
import org.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CarController {

    private CarService carService;

    @PostMapping(path = "/car")
    public Integer createCar(@RequestBody CarDtoRq carDtoRq) {
        return carService.createCar(carDtoRq);
    }

    @GetMapping(path = "/car/{id}")
    public ResponseEntity getCar(@PathVariable Integer id) {
        try {
            CarDtoRs car = carService.getCar(id)
                    .orElseThrow(() -> new RuntimeException("Машина не найдена"));
            return new ResponseEntity(car, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
