package com.example.rentaway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rentaway.entities.CarEntity;
import com.example.rentaway.services.CarService;

@RestController
@RequestMapping
@CrossOrigin("*")
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
    List<CarEntity> cars = carService.getCars(false);
    return ResponseEntity.status(200).body(cars);
  }

  @GetMapping("/rent/{id}")
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
  public ResponseEntity<String> deleteCar(@RequestParam String idCar) {
    carService.deleteCar(Integer.valueOf(idCar));
    return ResponseEntity.status(200).body("Car deleted");
  }
}
