package services;

import dao.interfaces.EmployeesMapper;
import models.Employees;

import java.util.List;

public class EmployeeService {
    private EmployeesMapper employeesMapper;

    public EmployeeService(EmployeesMapper employeesMapper) {
        this.employeesMapper = employeesMapper;
    }

    public Employees getEmployeeById(int id) {
        return employeesMapper.getEmployeeById(id);
    }

    public List<Employees> getAllEmployees() {
        return employeesMapper.getAllEmployees();
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
