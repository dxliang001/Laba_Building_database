package dao.jdbc;


import dao.connectionPool.ConnectionPool;
import dao.interfaces.InventoryDAO;
import models.Inventory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Materials;

public class InventoryDAOJDBC implements InventoryDAO {

    private ConnectionPool connectionPool;

    private MaterialsDAOJDBC materialsDAOJDBC;
    public InventoryDAOJDBC(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        this.materialsDAOJDBC = new MaterialsDAOJDBC(connectionPool);
    }

    @Override
    public List<Inventory> getAllInventory() {
        List<Inventory> inventories = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Inventory");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materials materials = materialsDAOJDBC.getMaterialById(rs.getInt("material_id"));
                inventories.add(new Inventory(rs.getInt("inventory_id"),
                        materials,
                        rs.getInt("quantity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventories;
    }

    @Override
    public Inventory getInventoryById(int id) {
        Inventory inventory = null;
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Inventory WHERE inventory_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Materials materials = materialsDAOJDBC.getMaterialById(rs.getInt("material_id"));
                inventory = new Inventory(rs.getInt("inventory_id"),
                        materials,
                        rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventory;
    }

    @Override
    public void save(Inventory inventory) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Inventory (inventory_id, material_id, quantity) VALUES (?, ?, ?)");
            ps.setInt(1, inventory.getInventoryId());
            ps.setInt(2, inventory.getMaterialId().getMaterialId());
            ps.setInt(3, inventory.getQuantityOnHand());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Inventory inventory) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE Inventory SET material_id = ?, quantity = ? WHERE inventory_id = ?");
            ps.setInt(1, inventory.getMaterialId().getMaterialId());
            ps.setInt(2, inventory.getQuantityOnHand());
            ps.setInt(3, inventory.getInventoryId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Inventory inventory) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Inventory WHERE inventory_id = ?");
            ps.setInt(1, inventory.getInventoryId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}