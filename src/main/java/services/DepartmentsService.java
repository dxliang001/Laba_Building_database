package services;

import dao.interfaces.DepartmentsDAO;
import models.Departments;

import java.util.List;

public class DepartmentsService {
    private DepartmentsDAO departmentsDao;

    public DepartmentsService(DepartmentsDAO departmentsDao) {
        this.departmentsDao = departmentsDao;
    }

    public Departments getDepartmentById(int id) {
        return departmentsDao.getDepartmentById(id);
    }

    public List<Departments> getAllDepartments() {
        return departmentsDao.getAllDepartments();
    }

    public void saveDepartment(Departments department) {
        departmentsDao.save(department);
    }

    public void updateDepartment(Departments department) {
        departmentsDao.update(department);
    }

    public void deleteDepartment(Departments department) {
        departmentsDao.delete(department);
    }
}