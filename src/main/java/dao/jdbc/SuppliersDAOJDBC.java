package dao.jdbc;

import dao.connectionPool.ConnectionPool;
import dao.interfaces.SuppliersDAO;
import models.Suppliers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuppliersDAOJDBC implements SuppliersDAO {

    private ConnectionPool connectionPool;

    public SuppliersDAOJDBC(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public List<Suppliers> getAllSuppliers() {
        List<Suppliers> suppliers = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM suppliers");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                suppliers.add(new Suppliers(rs.getInt("supplier_id"), rs.getString("supplier_name"), rs.getString("supplier_address"), rs.getString("supplier_email"), rs.getString("supplier_phone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppliers;
    }

    @Override
    public Suppliers getSupplierById(int id) {
        Suppliers supplier = null;
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM suppliers WHERE supplier_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                supplier = new Suppliers(rs.getInt("supplier_id"), rs.getString("supplier_name"), rs.getString("supplier_address"), rs.getString("supplier_email"), rs.getString("supplier_phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return supplier;
    }

    @Override
    public void save(Suppliers supplier) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO suppliers (supplier_id, supplier_name, supplier_address, supplier_email, supplier_phone) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, supplier.getSupplierId());
            ps.setString(2, supplier.getSupplierName());
            ps.setString(3, supplier.getSupplierAddress());
            ps.setString(4, supplier.getSupplierEmail());
            ps.setString(5, supplier.getSupplierPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Suppliers supplier) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE suppliers SET supplier_name = ?, supplier_address = ?, supplier_email = ?, supplier_phone = ? WHERE supplier_id = ?");
            ps.setString(1, supplier.getSupplierName());
            ps.setString(2, supplier.getSupplierAddress());
            ps.setString(3, supplier.getSupplierEmail());
            ps.setString(4, supplier.getSupplierPhone());
            ps.setInt(5, supplier.getSupplierId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Suppliers supplier) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM suppliers WHERE supplier_id = ?");
            ps.setInt(1, supplier.getSupplierId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}