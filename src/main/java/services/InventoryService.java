package services;

import dao.interfaces.InventoryMapper;
import models.Inventory;

import java.util.List;

public class InventoryService {
    private InventoryMapper inventoryMapper;

    public InventoryService(InventoryMapper inventoryMapper) {
        this.inventoryMapper = inventoryMapper;
    }

    public Inventory getInventoryById(int id) {
        return inventoryMapper.getInventoryById(id);
    }

    public List<Inventory> getAllInventory() {
        return inventoryMapper.getAllInventory();
    }

    public void saveInventory(Inventory inventory) {
        inventoryMapper.save(inventory);
    }

    public void updateInventory(Inventory inventory) {
        inventoryMapper.update(inventory);
    }

    public void deleteInventory(Inventory inventory) {
        inventoryMapper.delete(inventory);
    }
}
