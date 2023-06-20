package dao.interfaces;

import models.Departments;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DepartmentsMapper {

    @Select("SELECT * FROM departments")
    List<Departments> getAllDepartments();

    @Select("SELECT * FROM departments WHERE department_id = #{id}")
    Departments getDepartmentById(int id);

    @Insert("INSERT INTO departments (department_id, department_name, department_description) VALUES (#{departmentId}, #{departmentName}, #{departmentDescription})")
    void save(Departments department);

    @Update("UPDATE departments SET department_name = #{departmentName}, department_description = #{departmentDescription} WHERE department_id = #{departmentId}")
    void update(Departments department);

    @Delete("DELETE FROM departments WHERE department_id = #{departmentId}")
    void delete(Departments department);
}
