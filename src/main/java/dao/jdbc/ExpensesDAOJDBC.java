package dao.jdbc;

import dao.connectionPool.ConnectionPool;
import dao.interfaces.ExpensesDAO;
import models.Expenses;
import models.Projects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpensesDAOJDBC implements ExpensesDAO {

    private ConnectionPool connectionPool;
    private ProjectsDAOJDBC projectsDAOJDBC;

    public ExpensesDAOJDBC(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        this.projectsDAOJDBC = new ProjectsDAOJDBC(connectionPool);
    }

    @Override
    public List<Expenses> getAllExpenses() {
        List<Expenses> expenses = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Expenses");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Projects project = projectsDAOJDBC.getProjectById(rs.getInt("project_id"));
                expenses.add(new Expenses(rs.getInt("expense_id"),
                        project,
                        rs.getDouble("amount_spent"),
                        rs.getDate("expense_date"),
                        rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    @Override
    public Expenses getExpenseById(int id) {
        Expenses expense = null;
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Expenses WHERE expense_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Projects project = projectsDAOJDBC.getProjectById(rs.getInt("project_id"));
                expense = new Expenses(rs.getInt("expense_id"),
                        project,
                        rs.getDouble("amount_spent"),
                        rs.getDate("expense_date"),
                        rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expense;
    }

    @Override
    public void save(Expenses expense) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Expenses (expense_id, project_id, amount_spent, description, expense_date) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, expense.getExpenseId());
            ps.setInt(2, expense.getProjectId().getProjectId());
            ps.setDouble(3, expense.getAmount());
            ps.setString(4, expense.getDescription());
            ps.setDate(5, expense.getExpenseDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Expenses expense) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE Expenses SET project_id = ?, amount_spent = ?, description = ?, expense_date = ? WHERE expense_id = ?");
            ps.setInt(1, expense.getProjectId().getProjectId());
            ps.setDouble(2, expense.getAmount());
            ps.setString(3, expense.getDescription());
            ps.setDate(4, expense.getExpenseDate());
            ps.setInt(5, expense.getExpenseId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Expenses expense) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Expenses WHERE expense_id = ?");
            ps.setInt(1, expense.getExpenseId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}