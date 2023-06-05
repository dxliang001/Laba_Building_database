package dao.jdbc;

import dao.interfaces.ClientsDAO;
import dao.connectionPool.ConnectionPool;
import models.Clients;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientsDAOJDBC implements ClientsDAO {

    private ConnectionPool connectionPool;

    public ClientsDAOJDBC(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public List<Clients> getAllClients() {
        List<Clients> clients = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Clients");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clients.add(new Clients(rs.getInt("client_id"), rs.getString("client_name"), rs.getString("contact_name"),
                        rs.getString("client_address"), rs.getString("client_email"), rs.getString("client_phone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public Clients getClientById(int id) {
        Clients client = null;
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Clients WHERE client_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                client = new Clients(rs.getInt("client_id"), rs.getString("client_name"), rs.getString("contact_name"),
                        rs.getString("client_address"), rs.getString("client_email"), rs.getString("client_phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public void save(Clients client) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Clients (client_id, client_name, contact_name, client_address, client_email, client_phone) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, client.getClientId());
            ps.setString(2, client.getClientName());
            ps.setString(3, client.getContactName());
            ps.setString(4, client.getClientAddress());
            ps.setString(5, client.getClientEmail());
            ps.setString(6, client.getClientPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Clients client) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE Clients SET client_name = ?, contact_name = ?, client_address = ?, client_email = ?, client_phone = ? WHERE client_id = ?");
            ps.setString(1, client.getClientName());
            ps.setString(2, client.getContactName());
            ps.setString(3, client.getClientAddress());
            ps.setString(4, client.getClientEmail());
            ps.setString(5, client.getClientPhone());
            ps.setInt(6, client.getClientId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Clients client) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Clients WHERE client_id = ?");
            ps.setInt(1, client.getClientId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}