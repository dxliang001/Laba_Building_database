package dao.jdbc;

import dao.interfaces.DepartmentsDAO;
import dao.connectionPool.ConnectionPool;
import models.Departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsDAOJDBC implements DepartmentsDAO {

    private ConnectionPool connectionPool;

    public DepartmentsDAOJDBC(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public List<Departments> getAllDepartments() {
        List<Departments> departments = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Departments");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                departments.add(new Departments(rs.getInt("department_id"), rs.getString("department_name"), rs.getString("department_description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public Departments getDepartmentById(int id) {
        Departments department = null;
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Departments WHERE department_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                department = new Departments(rs.getInt("department_id"), rs.getString("department_name"), rs.getString("department_description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public void save(Departments department) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Departments (department_id, department_name, department_description) VALUES (?, ?, ?)");
            ps.setInt(1, department.getDepartmentId());
            ps.setString(2, department.getDepartmentName());
            ps.setString(3, department.getDepartmentDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Departments department) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE Departments SET department_name = ?, department_description = ? WHERE department_id = ?");
            ps.setString(1, department.getDepartmentName());
            ps.setString(2, department.getDepartmentDescription());
            ps.setInt(3, department.getDepartmentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Departments department) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Departments WHERE department_id = ?");
            ps.setInt(1, department.getDepartmentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}