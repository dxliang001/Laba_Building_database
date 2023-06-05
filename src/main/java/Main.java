

import dao.connectionPool.ConnectionPool;
import dao.jdbc.ClientsDAOJDBC;
import models.Clients;
import services.ClientService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        ConnectionPool connectionPool = new ConnectionPool();

        // Create the DAO and Service instances
        ClientsDAOJDBC clientsDAO = new ClientsDAOJDBC(connectionPool);
        ClientService clientService = new ClientService(clientsDAO);

        // Fetch a client by ID
        Clients client = clientService.getClientById(1);
        System.out.println("Client: " + client);
    }
}
