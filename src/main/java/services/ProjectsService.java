package services;

import dao.interfaces.ProjectsDAO;
import models.Projects;

import java.util.List;

public class ProjectsService {
    private ProjectsDAO projectsDao;

    public ProjectsService(ProjectsDAO projectsDao) {
        this.projectsDao = projectsDao;
    }

    public Projects getProjectById(int id) {
        return projectsDao.getProjectById(id);
    }

    public List<Projects> getAllProjects() {
        return projectsDao.getAllProjects();
    }

    public void saveProject(Projects project) {
        projectsDao.save(project);
    }

    public void updateProject(Projects project) {
        projectsDao.update(project);
    }

    public void deleteProject(Projects project) {
        projectsDao.delete(project);
    }
}
