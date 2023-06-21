import dao.interfaces.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

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
            ProjectsMapper projectsMapper = session.getMapper(ProjectsMapper.class);
            InvoicesMapper invoicesMapper = session.getMapper(InvoicesMapper.class);
            PaymentsMapper paymentsMapper = session.getMapper(PaymentsMapper.class);
            //BuildingCostCalculatorApp.run();

            /* Test insertClient
            Clients newClient = new Clients();
            newClient.setClientId(8);
            newClient.setClientName("New Client 8");
            newClient.setContactName("JOHN");
            newClient.setClientAddress("Some Address");
            newClient.setClientEmail("client@example.com");
            newClient.setClientPhone("123-456-7890");
            mapper.save(newClient);
            session.commit();
            */

            /* Test getClientById
            Clients client = mapper.getClientById(8);
            logger.info("Client " + client.getClientName());

            client = mapper.getClientById(8);
            logger.info("Client : " + client);
            */
//            List<Clients> allClients = mapper.getAllClients();
//            for (Clients clients : allClients) {
//                logger.info("Client ID: " + clients.getClientId());
//                logger.info("Client Name: " + clients.getClientName());
//                logger.info("Contact Name: " + clients.getContactName());
//                logger.info("Client Address: " + clients.getClientAddress());
//                logger.info("Client Email: " + clients.getClientEmail());
//                logger.info("Client Phone: " + clients.getClientPhone());
//                logger.info("------------------------");
//            }
//
//            List<Employees> employees = employeesMapper.getAllEmployees();
//            logger.info("Employees:");
//            for (Employees employee : employees) {
//                logger.info(employee);
//            }
//
//            List<Projects> projects = projectsMapper.getAllProjects();
//            logger.info("Projects:");
//            for (Projects project : projects) {
//                logger.info(project);
//            }

//            List<Invoices> invoices = invoicesMapper.getAllInvoices();
//            logger.info("Invoices:");
//            for (Invoices invoice : invoices) {
//                logger.info(invoice);
//            }

//            List<Payments> payments = paymentsMapper.getAllPayments();
//            logger.info("Payments:");
//            for (Payments payment : payments) {
//                logger.info(payment);
//            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

