package dao.interfaces;

import models.Inventory;
import java.util.List;

public interface InventoryDAO {
    List<Inventory> getAllInventory();
    Inventory getInventoryById(int id);
    void save(Inventory inventory);
    void update(Inventory inventory);
    void delete(Inventory inventory);
}