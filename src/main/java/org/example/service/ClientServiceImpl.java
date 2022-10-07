package org.example.service;

import org.example.entities.Client;
import org.example.repository.ClientRepo;
import org.example.repository.ClientRepoImpl;
import java.util.List;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService{

    private final ClientRepo repo = new ClientRepoImpl();

    @Override
    public Client createClient(Client client) {
        return (Client) repo.create(client);
    }

    @Override
    public Client readClient(int id) {
        return (Client) repo.read(id);
    }

    @Override
    public Client updateClient(int id, Client client) {
        return (Client) repo.update(id, client);
    }

    @Override
    public boolean deleteClient(int id) {
        return repo.delete(id);
    }

    @Override
    public List<Client> showAllClients() {
        return repo.readAll().stream().map(entity -> (Client) entity).collect(Collectors.toList());
    }
}
