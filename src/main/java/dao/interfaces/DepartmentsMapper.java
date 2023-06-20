package dao.interfaces;

import models.Departments;

import java.util.List;

public interface DepartmentsMapper {

    List<Departments> getAllDepartments();

    Departments getDepartmentById(int id);

    void save(Departments department);

    void update(Departments department);

    void delete(Departments department);
}
