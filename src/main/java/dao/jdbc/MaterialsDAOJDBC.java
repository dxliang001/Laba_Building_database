package dao.jdbc;


import dao.connectionPool.ConnectionPool;
import dao.interfaces.MaterialsDAO;
import models.Materials;
import models.Suppliers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class MaterialsDAOJDBC implements MaterialsDAO {

    private ConnectionPool connectionPool;

    private SuppliersDAOJDBC suppliersDAOJDBC;

    public MaterialsDAOJDBC(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        this.suppliersDAOJDBC = new SuppliersDAOJDBC(connectionPool);
    }

    @Override
    public List<Materials> getAllMaterials() {
        List<Materials> materials = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM materials");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Suppliers suppliers = suppliersDAOJDBC.getSupplierById(rs.getInt("supplier_id"));
                materials.add(new Materials(rs.getInt("material_id"),
                        rs.getString("material_name"),
                        rs.getString("description"),
                        suppliers));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materials;
    }

    @Override
    public Materials getMaterialById(int id) {
        Materials material = null;
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM materials WHERE material_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Suppliers suppliers = suppliersDAOJDBC.getSupplierById(rs.getInt("supplier_id"));
                material = new Materials(rs.getInt("material_id"),
                        rs.getString("material_name"),
                        rs.getString("description"),
                        suppliers);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return material;
    }

    @Override
    public void save(Materials material) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO materials (material_id, material_name, description, supplier_id) VALUES (?, ?, ?, ?)");
            ps.setInt(1, material.getMaterialId());
            ps.setString(2, material.getMaterialName());
            ps.setString(3, material.getMaterialDescription());
            ps.setInt(4, material.getSupplierId().getSupplierId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Materials material) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE materials SET material_name = ?, description = ?, supplier_id = ? WHERE material_id = ?");
            ps.setString(1, material.getMaterialName());
            ps.setString(2, material.getMaterialDescription());
            ps.setInt(3, material.getSupplierId().getSupplierId());
            ps.setInt(4, material.getMaterialId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Materials material) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM materials WHERE material_id = ?");
            ps.setInt(1, material.getMaterialId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}