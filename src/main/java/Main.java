import dao.connectionPool.ConnectionPool;
import dao.jdbc.ClientsDAOJDBC;
import models.Clients;
import services.ClientService;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ConnectionPool connectionPool = null;
        try {
            connectionPool = new ConnectionPool();

            // Create the DAO and Service instances
            ClientsDAOJDBC clientsDAO = new ClientsDAOJDBC(connectionPool);
            ClientService clientService = new ClientService(clientsDAO);

            // Fetch a client by ID
            List<Clients> allClients = clientService.getAllClients();
            for (Clients client : allClients) {
                logger.info("Client: " + client);
            }
        } catch (Exception e) {
            logger.error("An error occurred.", e);
        } finally {
            if (connectionPool != null) {
                ConnectionPool.shutdown();
            }
        }
    }
}