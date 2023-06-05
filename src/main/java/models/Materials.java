package models;

import java.util.Objects;

public class Materials {
    private int materialId;
    private String materialName;
    private String materialDescription;
    private Suppliers supplierId;

    public Materials(int materialId, String materialName, String materialDescription, Suppliers supplierId) {
        this.materialId = materialId;
        this.materialName = materialName;
        this.materialDescription = materialDescription;
        this.supplierId = supplierId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public Suppliers getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Suppliers supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        return "Materials{" +
                "materialId=" + materialId +
                ", materialName='" + materialName + '\'' +
                ", materialDescription='" + materialDescription + '\'' +
                ", supplierId=" + supplierId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materials that = (Materials) o;
        return materialId == that.materialId &&
                supplierId == that.supplierId &&
                Objects.equals(materialName, that.materialName) &&
                Objects.equals(materialDescription, that.materialDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, materialName, materialDescription, supplierId);
    }
}
