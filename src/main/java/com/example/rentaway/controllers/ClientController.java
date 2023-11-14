package com.example.rentaway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


public class ClientController {
  
  @Autowired
  private ClientService clientService;
  
  @PostMapping
  public String createAcount(@RequestBody ClientEntity client) {
    clientService.createOrUpdateClient(client);
    return "Account created";
  }

  @GetMapping
  public String login(@RequestBody String email, @RequestBody String password) {
    if (clientService.getClients(email, password)) {
      return "Login successful";
    } else {
      return "Login failed";
    }
  }

}
