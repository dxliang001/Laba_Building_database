package dao.interfaces;

import models.Employees;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EmployeesMapper {

    @Select("SELECT * FROM Employees")
    @Results({
            @Result(property = "empId", column = "emp_id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "hireDate", column = "hire_date"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "role.roleId", column = "role_id"),
            @Result(property = "department.departmentId", column = "department_id")
    })
    List<Employees> getAllEmployees();

    @Select("SELECT * FROM Employees WHERE emp_id = #{id}")
    @Results({
            @Result(property = "empId", column = "emp_id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "hireDate", column = "hire_date"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "role.roleId", column = "role_id"),
            @Result(property = "department.departmentId", column = "department_id")
    })
    Employees getEmployeeById(int id);

    @Insert("INSERT INTO Employees (emp_id, first_name, last_name, role_id, department_id, hire_date, email, phone_number) VALUES (#{empId}, #{firstName}, #{lastName}, #{role.roleId}, #{department.departmentId}, #{hireDate}, #{email}, #{phoneNumber})")
    void save(Employees employee);

    @Update("UPDATE Employees SET first_name = #{firstName}, last_name = #{lastName}, role_id = #{role.roleId}, department_id = #{department.departmentId}, hire_date = #{hireDate}, email = #{email}, phone_number = #{phoneNumber} WHERE emp_id = #{empId}")
    void update(Employees employee);

    @Delete("DELETE FROM Employees WHERE emp_id = #{empId}")
    void delete(Employees employee);
}
