package com.example.rentaway.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentaway.entities.CarEntity;
import com.example.rentaway.repositories.CarRepository;

@Service
public class CarService {

  @Autowired
  private CarRepository carRepository;

  public List<CarEntity> getCars(Boolean availability) {
    List<CarEntity> cars = new ArrayList<>();

    if (availability == true) {
      cars = carRepository.findByAvailability(availability);
      System.out.println("Available cars retrieved");
      return cars;
    } else {
      cars = carRepository.findAll();
      System.out.println("Cars retrieved");
    }
    
    return cars;
  }

  public void createOrUpdateCar(CarEntity car) {
    carRepository.save(car);
    System.out.println("Car created");
  }

  public void deleteCar(Integer id) {
    carRepository.deleteById(id);
    System.out.println("Car deleted");
  }
}
