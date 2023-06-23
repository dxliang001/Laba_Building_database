package services;

import dao.interfaces.DepartmentsMapper;
import models.Departments;

import java.util.List;

public class DepartmentService {
    private DepartmentsMapper departmentsMapper;

    public DepartmentService(DepartmentsMapper departmentsMapper) {
        this.departmentsMapper = departmentsMapper;
    }

    public Departments getDepartmentById(int id) {
        return departmentsMapper.getDepartmentById(id);
    }

    public List<Departments> getAllDepartments() {
        return departmentsMapper.getAllDepartments();
    }

    public void saveDepartment(Departments department) {
        departmentsMapper.save(department);
    }

    public void updateDepartment(Departments department) {
        departmentsMapper.update(department);
    }

    public void deleteDepartment(Departments department) {
        departmentsMapper.delete(department);
    }
}
