package dao.interfaces;

import models.Roles;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RolesMapper {

    @Select("SELECT * FROM roles")
    List<Roles> getAllRoles();

    @Select("SELECT * FROM roles WHERE role_id = #{id}")
    Roles getRoleById(int id);

    @Insert("INSERT INTO roles (role_id, role_name, role_description) VALUES (#{roleId}, #{roleName}, #{roleDescription})")
    void save(Roles role);

    @Update("UPDATE roles SET role_name = #{roleName}, role_description = #{roleDescription} WHERE role_id = #{roleId}")
    void update(Roles role);

    @Delete("DELETE FROM roles WHERE role_id = #{roleId}")
    void delete(Roles role);
}
