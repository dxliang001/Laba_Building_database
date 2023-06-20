package dao.interfaces;

import models.ProjectEmployees;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProjectEmployeesMapper {

    @Select("SELECT * FROM project_employees")
    List<ProjectEmployees> getAllProjectEmployees();

    @Select("SELECT * FROM project_employees WHERE project_id = #{projectId} AND emp_id = #{empId}")
    ProjectEmployees getProjectEmployeeById(@Param("projectId") int projectId, @Param("empId") int empId);

    @Insert("INSERT INTO project_employees (project_id, emp_id) VALUES (#{projectId}, #{empId})")
    void save(ProjectEmployees projectEmployee);

    @Delete("DELETE FROM project_employees WHERE project_id = #{projectId} AND emp_id = #{empId}")
    void delete(ProjectEmployees projectEmployee);
}
