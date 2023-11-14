package com.example.rentaway.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "car")
public class CarEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
  @Column(name = "idCar")
  private int id;

  @Column(name = "model")
  private String model;

  @Column(name = "brand")
  private String brand;

  @Column(name = "color")
  private String color;

  @Column(name = "manufactureYear")
  private int manufactureYear;

  @Column(name = "licensePlate")
  private String licensePlate;

  @Column(name = "pricePerDay")
  private int pricePerDay;

  @Column(name = "availability")
  private boolean availability;
}
