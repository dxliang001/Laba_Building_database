package dao.jdbc;

import dao.connectionPool.ConnectionPool;
import models.Roles;
import dao.interfaces.RolesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolesDAOJDBC implements RolesDAO {

    private ConnectionPool connectionPool;

    public RolesDAOJDBC(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public List<Roles> getAllRoles() {
        List<Roles> roles = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Roles");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                roles.add(new Roles(rs.getInt("role_id"), rs.getString("role_name"), rs.getString("role_description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public Roles getRoleById(int id) {
        Roles role = null;
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Roles WHERE role_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                role = new Roles(rs.getInt("role_id"), rs.getString("role_name"), rs.getString("role_description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public void save(Roles role) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Roles (role_id, role_name, role_description) VALUES (?, ?, ?)");
            ps.setInt(1, role.getRoleId());
            ps.setString(2, role.getRoleName());
            ps.setString(3, role.getRoleDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Roles role) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE Roles SET role_name = ?, role_description = ? WHERE role_id = ?");
            ps.setString(1, role.getRoleName());
            ps.setString(2, role.getRoleDescription());
            ps.setInt(3, role.getRoleId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Roles role) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Roles WHERE role_id = ?");
            ps.setInt(1, role.getRoleId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}