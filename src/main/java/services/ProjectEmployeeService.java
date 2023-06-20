package services;

import dao.interfaces.ProjectEmployeesMapper;
import models.ProjectEmployees;

import java.util.List;

public class ProjectEmployeeService {
    private ProjectEmployeesMapper projectEmployeesMapper;

    public ProjectEmployeeService(ProjectEmployeesMapper projectEmployeesMapper) {
        this.projectEmployeesMapper = projectEmployeesMapper;
    }

    public ProjectEmployees getProjectEmployeeById(int projectId, int empId) {
        return projectEmployeesMapper.getProjectEmployeeById(projectId, empId);
    }

    public List<ProjectEmployees> getAllProjectEmployees() {
        return projectEmployeesMapper.getAllProjectEmployees();
    }

    public void saveProjectEmployee(ProjectEmployees projectEmployee) {
        projectEmployeesMapper.save(projectEmployee);
    }

    public void deleteProjectEmployee(ProjectEmployees projectEmployee) {
        projectEmployeesMapper.delete(projectEmployee);
    }
}
