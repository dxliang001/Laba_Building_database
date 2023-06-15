package dao.jdbc;


import dao.connectionPool.ConnectionPool;
import dao.interfaces.ProjectEmployeeDAO;
import models.Employees;
import models.ProjectEmployees;
import models.Projects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectEmployeeDAOJDBC implements ProjectEmployeeDAO {

    private ConnectionPool connectionPool;
    private ProjectsDAOJDBC projectsDAOJDBC;

    private EmployeesDAOJDBC employeesDAOJDBC;

    public ProjectEmployeeDAOJDBC(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        this.projectsDAOJDBC = new ProjectsDAOJDBC(connectionPool);
        this.employeesDAOJDBC = new EmployeesDAOJDBC(connectionPool);
    }

    @Override
    public List<ProjectEmployees> getAllProjectEmployees() {
        List<ProjectEmployees> projectEmployees = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ProjectEmployees");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employees employee = employeesDAOJDBC.getEmployeeById(rs.getInt("emp_id"));
                Projects project = projectsDAOJDBC.getProjectById(rs.getInt("project_id"));
                projectEmployees.add(new ProjectEmployees(project,employee));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectEmployees;
    }

    // Note: Not implementing a getProjectEmployeeById method since this table doesn't have a unique id field

    @Override
    public void save(ProjectEmployees projectEmployee) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO ProjectEmployees (project_id, emp_id) VALUES (?, ?)");
            ps.setInt(1, projectEmployee.getProjectId().getProjectId());
            ps.setInt(2, projectEmployee.getEmpId().getEmpId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Note: There's no specific field to update in ProjectEmployees table since both fields are identifiers.

    @Override
    public void delete(ProjectEmployees projectEmployee) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM ProjectEmployees WHERE project_id = ? AND emp_id = ?");
            ps.setInt(1, projectEmployee.getProjectId().getProjectId());
            ps.setInt(2, projectEmployee.getEmpId().getEmpId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
