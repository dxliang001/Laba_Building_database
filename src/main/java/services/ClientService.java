package services;

import dao.interfaces.ClientsDAO;
import models.Clients;

import java.util.List;

public class ClientService {
    private ClientsDAO clientDao;

    public ClientService(ClientsDAO clientDao) {
        this.clientDao = clientDao;
    }

    public Clients getClientById(int id) {
        return clientDao.getClientById(id);
    }

    public List<Clients> getAllClients() {
        return clientDao.getAllClients();
    }

    public void saveClient(Clients client) {
        clientDao.save(client);
    }

    public void updateClient(Clients client) {
        clientDao.update(client);
    }

    public void deleteClient(Clients client) {
        clientDao.delete(client);
    }
}
