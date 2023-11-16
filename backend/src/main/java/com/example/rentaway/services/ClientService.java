package com.example.rentaway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentaway.entities.ClientEntity;
import com.example.rentaway.repositories.ClientRepository;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  public List<ClientEntity> getClients() {
    List<ClientEntity> clients = clientRepository.findAll();
    System.out.println("Clients retrieved");
    return clients;
  }

  public ClientEntity login(String email, String password) {
    List<ClientEntity> clients = clientRepository.findByEmail(email);
    if (!clients.isEmpty() && clients.get(0).getPassword().equals(password)) {
      System.out.println("Login successful");
      return clients.get(0);
    } else {
      System.out.println("Login failed");
      return null;
    }
  }
  
  public ClientEntity createOrUpdateClient(ClientEntity client) {
    clientRepository.save(client);
    System.out.println("Client created");
    return client;
  }

  public void deleteClient(Integer id) {
    clientRepository.deleteById(id);
    System.out.println("Client deleted");
  }
}
