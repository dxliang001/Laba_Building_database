package Menu;

import dao.interfaces.ClientsMapper;
import dao.interfaces.EmployeesMapper;
import models.Clients;
import models.Employees;

import java.util.List;

public class BusinessLogicFacade {
    private final ClientsMapper clientsMapper;
    private final EmployeesMapper employeesMapper;

    public BusinessLogicFacade(ClientsMapper clientsMapper, EmployeesMapper employeesMapper) {
        this.clientsMapper = clientsMapper;
        this.employeesMapper = employeesMapper;
    }

    // Client-related operations
    public List<Clients> getAllClients() {
        return clientsMapper.getAllClients();
    }

    public Clients getClientById(int clientId) {
        return clientsMapper.getClientById(clientId);
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

    // Employee-related operations
    public List<Employees> getAllEmployees() {
        return employeesMapper.getAllEmployees();
    }

    public Employees getEmployeeById(int empId) {
        return employeesMapper.getEmployeeById(empId);
    }

    public void saveEmployee(Employees employee) {
        employeesMapper.save(employee);
    }

    public void updateEmployee(Employees employee) {
        employeesMapper.update(employee);
    }

    public void deleteEmployee(Employees employee) {
        employeesMapper.delete(employee);
    }
}
