package dao.interfaces;

import models.ProjectMaterials;
import java.util.List;

public interface ProjectMaterialDAO {
    List<ProjectMaterials> getAllProjectMaterials();
    void save(ProjectMaterials projectMaterial);
    void update(ProjectMaterials projectMaterial);
    void delete(ProjectMaterials projectMaterial);
}