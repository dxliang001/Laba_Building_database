package services;

import dao.interfaces.ProjectMaterialsMapper;
import models.ProjectMaterials;

import java.util.List;

public class ProjectMaterialService {
    private ProjectMaterialsMapper projectMaterialsMapper;

    public ProjectMaterialService(ProjectMaterialsMapper projectMaterialsMapper) {
        this.projectMaterialsMapper = projectMaterialsMapper;
    }

    public ProjectMaterials getProjectMaterialById(int projectId, int materialId) {
        return projectMaterialsMapper.getProjectMaterialById(projectId, materialId);
    }

    public List<ProjectMaterials> getAllProjectMaterials() {
        return projectMaterialsMapper.getAllProjectMaterials();
    }

    public void saveProjectMaterial(ProjectMaterials projectMaterial) {
        projectMaterialsMapper.save(projectMaterial);
    }

    public void updateProjectMaterial(ProjectMaterials projectMaterial) {
        projectMaterialsMapper.update(projectMaterial);
    }

    public void deleteProjectMaterial(ProjectMaterials projectMaterial) {
        projectMaterialsMapper.delete(projectMaterial);
    }
}
