package services;

import dao.interfaces.ProjectEmployeeDAO;
import models.ProjectEmployees;

import java.util.List;

public class ProjectEmployeeService {
    private ProjectEmployeeDAO projectEmployeeDao;

    public ProjectEmployeeService(ProjectEmployeeDAO projectEmployeeDao) {
        this.projectEmployeeDao = projectEmployeeDao;
    }

    public List<ProjectEmployees> getAllProjectEmployees() {
        return projectEmployeeDao.getAllProjectEmployees();
    }

    public void saveProjectEmployee(ProjectEmployees projectEmployee) {
        projectEmployeeDao.save(projectEmployee);
    }

    public void deleteProjectEmployee(ProjectEmployees projectEmployee) {
        projectEmployeeDao.delete(projectEmployee);
    }
}
