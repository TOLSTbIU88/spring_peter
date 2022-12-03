package org.example.service;

import org.example.dao.CarDao;
import org.example.dto.CarDtoRq;
import org.example.dto.CarDtoRs;
import org.example.entities.Car;
import org.example.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarDao carDao;
    @Autowired
    private CarMapper carMapper;

    public Integer createCar(CarDtoRq carDtoRq) {
        Car carFromCarDtoRq = carMapper.getCarFromCarDtoRq(carDtoRq);
        return carDao.createCar(carFromCarDtoRq);
    }

    public Optional<CarDtoRs> getCar(Integer id) {
        Optional<Car> car = carDao.getCar(id);
        return carMapper.getCarDtoRs(car);
    }

}
