import Menu.BusinessLogicFacade;
import dao.interfaces.*;
import models.Clients;
import models.Departments;
import models.Employees;
import models.Roles;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Runner {

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
            RolesMapper rolesMapper = session.getMapper(RolesMapper.class);
            DepartmentsMapper departmentsMapper = session.getMapper(DepartmentsMapper.class);
            //BuildingCostCalculatorApp.run();


//
//            Clients newClient = new Clients();
//            newClient.setClientId(9);
//            newClient.setClientName("New Client 8");
//            newClient.setContactName("JOHN");
//            newClient.setClientAddress("Some Address");
//            newClient.setClientEmail("client@example.com");
//            newClient.setClientPhone("123-456-7890");
//            mapper.save(newClient);
//            session.commit();

//           Delete Client above base on newClient.setClientId(9);
//            mapper.delete(newClient);
//            session.commit();

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
// Create a BusinessLogicFacade
            BusinessLogicFacade facade = new BusinessLogicFacade(mapper, employeesMapper);

// Test facade methods
            System.out.println("---- Clients ----");
            List<Clients> allClients = facade.getAllClients();
            allClients.forEach(c -> System.out.println("Client: " + c));

            Clients client = facade.getClientById(1);
            if (client != null) {
                System.out.println("Client 1: " + client);
            } else {
                System.out.println("Client with id 1 not found.");
            }

            Clients newClient = new Clients();
            newClient.setClientId(10);
            newClient.setClientName("New Client");
            newClient.setContactName("New Contact");
            newClient.setClientAddress("New Address");
            newClient.setClientEmail("newclient@example.com");
            newClient.setClientPhone("123-456-7890");
            facade.saveClient(newClient);
            System.out.println("New client saved.");

            allClients = facade.getAllClients();
            allClients.forEach(c -> System.out.println("Client: " + c));

            facade.deleteClient(newClient);
            System.out.println("New client deleted.");

            allClients = facade.getAllClients();
            allClients.forEach(c -> System.out.println("Client: " + c));

            System.out.println("---- Employees ----");
            List<Employees> allEmployees = facade.getAllEmployees();
            allEmployees.forEach(e -> System.out.println("Employee: " + e));


            Employees newEmployee = new Employees();
            newEmployee.setEmpId(10);
            newEmployee.setFirstName("New");
            newEmployee.setLastName("Employee");
            Roles role = rolesMapper.getRoleById(1);
            if (role != null) {
                newEmployee.setRole(role);
            } else {
                System.out.println("Role with id not found.");
            }

// Fetch the department with id 1 and set it to the new employee
            Departments department = departmentsMapper.getDepartmentById(1);
            if (department != null) {
                newEmployee.setDepartment(department);
            } else {
                System.out.println("Department with id not found.");
            }
            newEmployee.setHireDate(Date.valueOf(LocalDate.of(2023, 6, 26)));
            newEmployee.setEmail("newemployee@example.com");
            newEmployee.setPhoneNumber("987-654-3210");

            if (newEmployee.getRole() == null || newEmployee.getDepartment() == null || newEmployee.getHireDate() == null) {
                System.out.println("Invalid employee data. Role, Department and HireDate cannot be null.");
            } else {
                facade.saveEmployee(newEmployee);
                System.out.println("New employee saved.");
            }

            allEmployees = facade.getAllEmployees();
            allEmployees.forEach(e -> System.out.println("Employee: " + e));

            facade.deleteEmployee(newEmployee);
            System.out.println("New employee deleted.");

            allEmployees = facade.getAllEmployees();
            allEmployees.forEach(e -> System.out.println("Employee: " + e));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}