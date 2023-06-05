package services;

import dao.interfaces.ProjectMaterialDAO;
import models.ProjectMaterials;

import java.util.List;

public class ProjectMaterialService {
    private ProjectMaterialDAO projectMaterialDao;

    public ProjectMaterialService(ProjectMaterialDAO projectMaterialDao) {
        this.projectMaterialDao = projectMaterialDao;
    }

    public List<ProjectMaterials> getAllProjectMaterials() {
        return projectMaterialDao.getAllProjectMaterials();
    }

    public void saveProjectMaterial(ProjectMaterials projectMaterial) {
        projectMaterialDao.save(projectMaterial);
    }

    public void updateProjectMaterial(ProjectMaterials projectMaterial) {
        projectMaterialDao.update(projectMaterial);
    }

    public void deleteProjectMaterial(ProjectMaterials projectMaterial) {
        projectMaterialDao.delete(projectMaterial);
    }
}
