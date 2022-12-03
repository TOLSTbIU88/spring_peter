package org.example.dao;


import org.example.entities.Car;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class CarDao {
    private Map<Integer, Car> data = new HashMap<>();
    private Integer countId = 0;

    public Integer createCar(Car car) {
        countId++;
        data.put(countId, car);
        return countId;
    }

    public Optional<Car> getCar(Integer id) {
        return Optional.ofNullable(data.get(id));
    }
}
