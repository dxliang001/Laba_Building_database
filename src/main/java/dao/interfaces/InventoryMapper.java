package dao.interfaces;

import models.Inventory;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface InventoryMapper {

    @Select("SELECT * FROM inventory")
    List<Inventory> getAllInventory();

    @Select("SELECT * FROM inventory WHERE inventory_id = #{id}")
    Inventory getInventoryById(int id);

    @Insert("INSERT INTO inventory (inventory_id, material_id, quantity_on_hand) VALUES (#{inventoryId}, #{materialId}, #{quantityOnHand})")
    void save(Inventory inventory);

    @Update("UPDATE inventory SET material_id = #{materialId}, quantity_on_hand = #{quantityOnHand} WHERE inventory_id = #{inventoryId}")
    void update(Inventory inventory);

    @Delete("DELETE FROM inventory WHERE inventory_id = #{inventoryId}")
    void delete(Inventory inventory);
}
