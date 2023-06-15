package dao.jdbc;

import dao.connectionPool.ConnectionPool;
import dao.interfaces.PaymentsDAO;
import models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentsDAOJDBC implements PaymentsDAO {

    private ClientsDAOJDBC clientsDAOJDBC;
    private ConnectionPool connectionPool;

    private ProjectsDAOJDBC projectsDAOJDBC;

    public PaymentsDAOJDBC(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        this.clientsDAOJDBC = new ClientsDAOJDBC(connectionPool);
        this.projectsDAOJDBC = new ProjectsDAOJDBC(connectionPool);
    }


    @Override
    public List<Payments> getAllPayments() {
        List<Payments> payments = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM payments");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Clients client = clientsDAOJDBC.getClientById(rs.getInt("client_id"));
                Projects project = projectsDAOJDBC.getProjectById(rs.getInt("project_id"));
                payments.add(new Payments(rs.getInt("payment_id"), client, project, rs.getDouble("amount"), rs.getDate("payment_date"), rs.getString("payment_method")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    @Override
    public Payments getPaymentById(int id) {
        Payments payment = null;
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM payments WHERE payment_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Clients client = clientsDAOJDBC.getClientById(rs.getInt("client_id"));
                Projects project = projectsDAOJDBC.getProjectById(rs.getInt("project_id"));
                payment = new Payments(rs.getInt("payment_id"),
                        client,
                        project,
                        rs.getDouble("amount"),
                        rs.getDate("payment_date"),
                        rs.getString("payment_method"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }

    @Override
    public void save(Payments payment) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO payments (payment_id, client_id, project_id, amount, payment_date, payment_method) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, payment.getPaymentId());
            ps.setInt(2, payment.getClientId().getClientId());
            ps.setInt(3, payment.getProjectId().getProjectId());
            ps.setDouble(4, payment.getAmount());
            ps.setDate(5, payment.getPaymentDate());
            ps.setString(6, payment.getPaymentMethod());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Payments payment) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE payments SET client_id = ?, project_id = ?, amount = ?, payment_date = ?, payment_method = ? WHERE payment_id = ?");
            ps.setInt(1, payment.getClientId().getClientId());
            ps.setInt(2, payment.getProjectId().getProjectId());
            ps.setDouble(3, payment.getAmount());
            ps.setDate(4, payment.getPaymentDate());
            ps.setString(5, payment.getPaymentMethod());
            ps.setInt(6, payment.getPaymentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Payments payment) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM payments WHERE payment_id = ?");
            ps.setInt(1, payment.getPaymentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}