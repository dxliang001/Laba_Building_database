package models;

import java.util.Objects;

public class Inventory {
    private int inventoryId;
    private Materials materialId;
    private int quantityOnHand;

    public Inventory(int inventoryId, Materials materialId, int quantityOnHand) {
        this.inventoryId = inventoryId;
        this.materialId = materialId;
        this.quantityOnHand = quantityOnHand;
    }

    public Materials getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Materials materialId) {
        this.materialId = materialId;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }
    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", materialId=" + materialId +
                ", quantityOnHand=" + quantityOnHand +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory that = (Inventory) o;
        return inventoryId == that.inventoryId &&
                materialId == that.materialId &&
                quantityOnHand == that.quantityOnHand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId, materialId, quantityOnHand);
    }
}
