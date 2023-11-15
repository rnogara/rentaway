package com.example.rentaway.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "client")
@Table(name = "client")
public class ClientEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
  @Column(name = "idClient")
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;
  
}
