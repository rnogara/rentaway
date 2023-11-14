package com.example.rentaway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rentaway.entities.CarEntity;
import com.example.rentaway.services.CarService;

@RestController
@RequestMapping
public class CarController {
  
  @Autowired
  CarService carService;

  @PostMapping("/admin/cars")
  public ResponseEntity<String> createCar(@RequestBody CarEntity car) {
    carService.createOrUpdateCar(car);
    return ResponseEntity.status(201).body("Car created");
  }

  @GetMapping
  public ResponseEntity<List<CarEntity>> getCars() {
    List<CarEntity> cars = carService.getCars(null);
    return ResponseEntity.status(200).body(cars);
  }

  @GetMapping("/rent")
  public ResponseEntity<List<CarEntity>> getAvailableCars() {
    List<CarEntity> cars = carService.getCars(true);
    return ResponseEntity.status(200).body(cars);
  }

  @PutMapping("/admin/cars")
  public ResponseEntity<String> updateCar(@RequestBody CarEntity car) {
    carService.createOrUpdateCar(car);
    return ResponseEntity.status(200).body("Car updated");
  }

  @DeleteMapping("/admin/cars")
  public ResponseEntity<String> deleteCar(@RequestBody Integer id) {
    carService.deleteCar(id);
    return ResponseEntity.status(200).body("Car deleted");
  }
}
