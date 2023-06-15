package dao.jdbc;

import dao.connectionPool.ConnectionPool;
import dao.interfaces.ProjectsDAO;
import models.Clients;
import models.Projects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectsDAOJDBC implements ProjectsDAO {

    private ConnectionPool connectionPool;
    private ClientsDAOJDBC clientsDAOJDBC;

    public ProjectsDAOJDBC(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        this.clientsDAOJDBC = new ClientsDAOJDBC(connectionPool);
    }

    @Override
    public List<Projects> getAllProjects() {
        List<Projects> projects = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Projects");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Clients client = clientsDAOJDBC.getClientById(rs.getInt("client_id"));
                projects.add(new Projects(rs.getInt("project_id"), rs.getString("project_name"), rs.getDate("start_date"), rs.getDate("end_date"), client, rs.getString("project_status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    @Override
    public Projects getProjectById(int id) {
        Projects project = null;
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Projects WHERE project_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Clients client = clientsDAOJDBC.getClientById(rs.getInt("client_id"));
                project = new Projects(rs.getInt("project_id"), rs.getString("project_name"), rs.getDate("start_date"), rs.getDate("end_date"), client, rs.getString("project_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public void save(Projects project) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Projects (project_id, project_name, start_date, end_date, client_id, project_status) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, project.getProjectId());
            ps.setString(2, project.getProjectName());
            ps.setDate(3, project.getStartDate());
            ps.setDate(4, project.getEndDate());
            ps.setInt(5, project.getClientId().getClientId());
            ps.setString(6, project.getProjectStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Projects project) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE Projects SET project_name = ?, start_date = ?, end_date = ?, client_id = ?, project_status = ? WHERE project_id = ?");
            ps.setString(1, project.getProjectName());
            ps.setDate(2, project.getStartDate());
            ps.setDate(3, project.getEndDate());
            ps.setInt(4, project.getClientId().getClientId());
            ps.setString(5, project.getProjectStatus());
            ps.setInt(6, project.getProjectId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Projects project) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Projects WHERE project_id = ?");
            ps.setInt(1, project.getProjectId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}