package dao.interfaces;

import models.Employees;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import java.util.List;

public interface EmployeesMapper {

    @Results({
            @Result(property = "role", column = "roleId", javaType = models.Roles.class, one = @One(select = "dao.interfaces.RolesMapper.getRoleById")),
            @Result(property = "department", column = "departmentId", javaType = models.Departments.class, one = @One(select = "dao.interfaces.DepartmentsMapper.getDepartmentById"))
    })
    List<Employees> getAllEmployees();

    Employees getEmployeeById(int id);

    void save(Employees employee);

    void update(Employees employee);

    void delete(Employees employee);
}
