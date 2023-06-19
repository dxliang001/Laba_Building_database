package services;

import dao.interfaces.ClientsMapper;
import models.Clients;

import java.util.List;

public class ClientService {
    private ClientsMapper clientsMapper;

    public ClientService(ClientsMapper clientsMapper) {
        this.clientsMapper = clientsMapper;
    }

    public Clients getClientById(int id) {
        return clientsMapper.getClientById(id);
    }

    public List<Clients> getAllClients() {
        return clientsMapper.getAllClients();
    }

    public void saveClient(Clients client) {
        clientsMapper.save(client);
    }

    public void updateClient(Clients client) {
        clientsMapper.update(client);
    }

    public void deleteClient(Clients client) {
        clientsMapper.delete(client);
    }
}
