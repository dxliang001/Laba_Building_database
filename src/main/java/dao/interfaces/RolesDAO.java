package dao.interfaces;

import models.Roles;

import java.util.List;

public interface RolesDAO {
    List<Roles> getAllRoles();
    Roles selectRoleById(int id);
    void save(Roles role);
    void update(Roles role);
    void delete(Roles role);
}