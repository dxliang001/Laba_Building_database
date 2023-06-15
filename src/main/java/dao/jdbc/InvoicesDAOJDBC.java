package dao.jdbc;

import dao.connectionPool.ConnectionPool;
import dao.interfaces.InvoicesDAO;
import models.Clients;
import models.Invoices;
import models.Payments;
import models.Projects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoicesDAOJDBC implements InvoicesDAO {

    private ConnectionPool connectionPool;

    private ClientsDAOJDBC clientsDAOJDBC;
    private ProjectsDAOJDBC projectsDAOJDBC;
    private PaymentsDAOJDBC paymentsDAOJDBC;

    public InvoicesDAOJDBC(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        this.clientsDAOJDBC = new ClientsDAOJDBC(connectionPool);
        this.projectsDAOJDBC = new ProjectsDAOJDBC(connectionPool);
        this.paymentsDAOJDBC = new PaymentsDAOJDBC(connectionPool);
    }

    @Override
    public List<Invoices> getAllInvoices() {
        List<Invoices> invoices = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM invoices");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Clients client = clientsDAOJDBC.getClientById(rs.getInt("client_id"));
                Projects project = projectsDAOJDBC.getProjectById(rs.getInt("project_id"));
                Payments payment = paymentsDAOJDBC.getPaymentById(rs.getInt("payment_id"));
                invoices.add(new Invoices(rs.getInt("invoice_id"),
                        client,
                        project,
                        rs.getDate("issue_date"),
                        rs.getDate("due_date"),
                        rs.getDouble("total_amount"),
                        payment));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoices;
    }

    @Override
    public Invoices getInvoiceById(int id) {
        Invoices invoice = null;
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM invoices WHERE invoice_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Clients client = clientsDAOJDBC.getClientById(rs.getInt("client_id"));
                Projects project = projectsDAOJDBC.getProjectById(rs.getInt("project_id"));
                Payments payment = paymentsDAOJDBC.getPaymentById(rs.getInt("payment_id"));
                invoice = new Invoices(rs.getInt("invoice_id"),
                        client,
                        project,
                        rs.getDate("issue_date"),
                        rs.getDate("due_date"),
                        rs.getDouble("total_amount"),
                        payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoice;
    }

    @Override
    public void save(Invoices invoice) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO invoices (invoice_id, client_id, project_id, issue_date, due_date, total_amount, payment_id) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, invoice.getInvoiceId());
            ps.setInt(2, invoice.getClientId().getClientId());
            ps.setInt(3, invoice.getProjectId().getProjectId());
            ps.setDate(4, invoice.getIssueDate());
            ps.setDate(5, invoice.getDueDate());
            ps.setDouble(6, invoice.getTotalAmount());
            ps.setInt(7, invoice.getPaymentId().getPaymentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Invoices invoice) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE invoices SET client_id = ?, project_id = ?, issue_date = ?, due_date = ?, total_amount = ?, payment_id = ? WHERE invoice_id = ?");
            ps.setInt(1, invoice.getClientId().getClientId());
            ps.setInt(2, invoice.getProjectId().getProjectId());
            ps.setDate(3, invoice.getIssueDate());
            ps.setDate(4, invoice.getDueDate());
            ps.setDouble(5, invoice.getTotalAmount());
            ps.setInt(6, invoice.getPaymentId().getPaymentId());
            ps.setInt(7, invoice.getInvoiceId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Invoices invoice) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM invoices WHERE invoice_id = ?");
            ps.setInt(1, invoice.getInvoiceId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}