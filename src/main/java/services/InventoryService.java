package services;

import dao.interfaces.InventoryDAO;
import models.Inventory;

import java.util.List;

public class InventoryService {
    private InventoryDAO inventoryDao;

    public InventoryService(InventoryDAO inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    public Inventory getInventoryById(int id) {
        return inventoryDao.getInventoryById(id);
    }

    public List<Inventory> getAllInventory() {
        return inventoryDao.getAllInventory();
    }

    public void saveInventory(Inventory inventory) {
        inventoryDao.save(inventory);
    }

    public void updateDepartment(Inventory inventory) {
        inventoryDao.update(inventory);
    }

    public void deleteInventory(Inventory inventory) {
        inventoryDao.delete(inventory);
    }
}