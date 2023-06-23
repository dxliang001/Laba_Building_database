package services;

import dao.interfaces.ProjectsMapper;
import models.Projects;

import java.util.List;

public class ProjectService {
    private ProjectsMapper projectsMapper;

    public ProjectService(ProjectsMapper projectsMapper) {
        this.projectsMapper = projectsMapper;
    }

    public Projects getProjectById(int id) {
        return projectsMapper.getProjectById(id);
    }

    public List<Projects> getAllProjects() {
        return projectsMapper.getAllProjects();
    }

    public void saveProject(Projects project) {
        projectsMapper.save(project);
    }

    public void updateProject(Projects project) {
        projectsMapper.update(project);
    }

    public void deleteProject(Projects project) {
        projectsMapper.delete(project);
    }
}
