package org.example.service;

import org.example.entities.Client;

import java.util.List;

public interface ClientService {

    Client createClient(Client client);
    Client readClient(int id);
    Client updateClient(int id, Client client);
    boolean deleteClient(int id);
    List<Client> showAllClients();

}
