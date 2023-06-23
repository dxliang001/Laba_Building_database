package dao.interfaces;

import models.Projects;

import java.util.List;

public interface ProjectsMapper {
    List<Projects> getAllProjects();
    Projects getProjectById(int id);
    void save(Projects project);
    void update(Projects project);
    void delete(Projects project);
}
