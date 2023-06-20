import dao.interfaces.ClientsMapper;
import dao.interfaces.EmployeesMapper;
import models.Clients;
import models.Employees;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        SqlSession session = null;
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            session = sqlSessionFactory.openSession();
            ClientsMapper mapper = session.getMapper(ClientsMapper.class);
            EmployeesMapper employeesMapper = session.getMapper(EmployeesMapper.class);

            /* Test insertClient
            Clients newClient = new Clients();
            newClient.setClientId(1);
            newClient.setClientName("Client Name");
            newClient.setContactName("Contact Name");
            newClient.setClientAddress("Client Address");
            newClient.setClientEmail("client@example.com");
            newClient.setClientPhone("123-456-7890");
            mapper.save(newClient);
            session.commit();
            */

            // Test getClientById
            Clients client = mapper.getClientById(2);
            logger.info("Client " + client.getClientName());


            client = mapper.getClientById(5);
            logger.info("Client : " + client);

            List<Clients> allClients = mapper.getAllClients();
            for (Clients clients : allClients) {
                logger.info("Client ID: " + clients.getClientId());
                logger.info("Client Name: " + clients.getClientName());
                logger.info("Contact Name: " + clients.getContactName());
                logger.info("Client Address: " + clients.getClientAddress());
                logger.info("Client Email: " + clients.getClientEmail());
                logger.info("Client Phone: " + clients.getClientPhone());
                logger.info("------------------------");
            }

            List<Employees> employees = employeesMapper.getAllEmployees();
            System.out.println("Employees:");
            for (Employees employee : employees) {
                logger.info(employee);
            }



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

