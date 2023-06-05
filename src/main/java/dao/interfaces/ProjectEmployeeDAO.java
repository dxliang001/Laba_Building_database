package dao.interfaces;


import models.ProjectEmployees;

import java.util.List;

public interface ProjectEmployeeDAO {
    List<ProjectEmployees> getAllProjectEmployees();
    void save(ProjectEmployees projectEmployee);
    void delete(ProjectEmployees projectEmployee);
}
