package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
@XmlRootElement(name = "ProjectMaterials")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectMaterials {
    @XmlElement(name = "projectId")
    private Projects projectId;
    @XmlElement(name = "materialId")
    private Materials materialId;
    @XmlElement(name = "quantityRequired")
    private int quantityRequired;

    public ProjectMaterials(Projects projectId, Materials materialId, int quantityRequired) {
        this.projectId = projectId;
        this.materialId = materialId;
        this.quantityRequired = quantityRequired;
    }

    public Projects getProjectId() {
        return projectId;
    }

    public void setProjectId(Projects projectId) {
        this.projectId = projectId;
    }

    public Materials getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Materials materialId) {
        this.materialId = materialId;
    }

    public int getQuantityRequired() {
        return quantityRequired;
    }

    public void setQuantityRequired(int quantityRequired) {
        this.quantityRequired = quantityRequired;
    }
    @Override
    public String toString() {
        return "ProjectMaterials{" +
                "projectId=" + projectId +
                ", materialId=" + materialId +
                ", quantityRequired=" + quantityRequired +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectMaterials that = (ProjectMaterials) o;
        return projectId == that.projectId &&
                materialId == that.materialId &&
                quantityRequired == that.quantityRequired;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, materialId, quantityRequired);
    }
}
