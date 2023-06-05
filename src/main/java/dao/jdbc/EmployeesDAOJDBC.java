package dao.jdbc;

import dao.interfaces.EmployeesDAO;
import dao.connectionPool.ConnectionPool;
import models.Employees;
import models.Roles;
import models.Departments;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAOJDBC implements EmployeesDAO {
    private ConnectionPool connectionPool;

    public EmployeesDAOJDBC(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }


    @Override
    public List<Employees> getAllEmployee() {
        List<Employees> employees = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Employees WHERE emp_id = ?");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Roles role = new Roles(rs.getInt("role_id"), rs.getString("role_name"), rs.getString("role_description"));
                Departments department = new Departments(rs.getInt("department_id"), rs.getString("department_name"), rs.getString("department_description"));
                employees.add(new Employees(rs.getInt("emp_id"), rs.getString("first_name"), rs.getString("last_name"), role, department, rs.getDate("hire_date"), rs.getString("email"), rs.getString("phone_number")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employees getEmployeeById(int id) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Employees WHERE emp_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Roles role = new Roles(rs.getInt("role_id"), rs.getString("role_name"), rs.getString("role_description"));
                Departments department = new Departments(rs.getInt("department_id"), rs.getString("department_name"), rs.getString("department_description"));
                return new Employees(rs.getInt("emp_id"), rs.getString("first_name"), rs.getString("last_name"), role, department, rs.getDate("hire_date"), rs.getString("email"), rs.getString("phone_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void save(Employees employee) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Employees (emp_id, first_name, last_name, role_id, department_id, hire_date, email, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, employee.getEmpId());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());
            ps.setInt(4, employee.getRole().getRoleId());
            ps.setInt(5, employee.getDepartment().getDepartmentId());
            ps.setDate(6, employee.getHireDate());
            ps.setString(7, employee.getEmail());
            ps.setString(8, employee.getPhoneNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employees employee) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE Employees SET first_name = ?, last_name = ?, role_id = ?, department_id = ?, hire_date = ?, email = ?, phone_number = ? WHERE emp_id = ?");
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setInt(3, employee.getRole().getRoleId());
            ps.setInt(4, employee.getDepartment().getDepartmentId());
            ps.setDate(5, employee.getHireDate());
            ps.setString(6, employee.getEmail());
            ps.setString(7, employee.getPhoneNumber());
            ps.setInt(8, employee.getEmpId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Employees employee) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Employees WHERE emp_id = ?");
            ps.setInt(1, employee.getEmpId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
