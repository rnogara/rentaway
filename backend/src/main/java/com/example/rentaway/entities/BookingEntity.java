package com.example.rentaway.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "booking")
@Table(name = "booking")
public class BookingEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
  @Column(name = "idBooking")
  private int id;

  @Column(name = "idCar")
  private int idCar;

  @Column(name = "idClient")
  private int idClient;

  @Column(name = "startDate")
  private String startDate;

  @Column(name = "endDate")
  private String endDate;

  @Column(name = "totalPrice")
  private int totalPrice;
}
