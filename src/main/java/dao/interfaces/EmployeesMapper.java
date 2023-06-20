package dao.interfaces;

import models.Employees;

import java.util.List;

public interface EmployeesMapper {


    List<Employees> getAllEmployees();


    Employees getEmployeeById(int id);

    void save(Employees employee);

    void update(Employees employee);

    void delete(Employees employee);
}
