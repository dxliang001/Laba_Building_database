package dao.interfaces;

import models.Clients;
import models.Employees;

import java.util.List;

public interface EmployeesDAO {

    List<Employees> getAllEmployee();
    Employees getEmployeeById(int id);
    void save(Employees employees);
    void update(Employees employees);
    void delete(Employees employees);
}