package services;

import dao.interfaces.RolesMapper;
import models.Roles;

import java.util.List;

public class RoleService {
    private RolesMapper rolesMapper;

    public RoleService(RolesMapper rolesMapper) {
        this.rolesMapper = rolesMapper;
    }

    public Roles getRoleById(int id) {
        return rolesMapper.getRoleById(id);
    }

    public List<Roles> getAllRoles() {
        return rolesMapper.getAllRoles();
    }

    public void saveRole(Roles role) {
        rolesMapper.save(role);
    }

    public void updateRole(Roles role) {
        rolesMapper.update(role);
    }

    public void deleteRole(Roles role) {
        rolesMapper.delete(role);
    }
}
