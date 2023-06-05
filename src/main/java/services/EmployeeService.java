package services;

import dao.interfaces.EmployeesDAO;
import models.Employees;

import java.util.List;

public class EmployeeService {
    private EmployeesDAO employeeDao;

    public EmployeeService(EmployeesDAO employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Employees getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    public List<Employees> getAllEmployees() {
        return employeeDao.getAllEmployee();
    }

    public void saveEmployee(Employees employee) {
        employeeDao.save(employee);
    }

    public void updateEmployee(Employees employee) {
        employeeDao.update(employee);
    }

    public void deleteEmployee(Employees employee) {
        employeeDao.delete(employee);
    }
}
