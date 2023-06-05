package services;

import dao.interfaces.RolesDAO;
import models.Roles;

import java.util.List;

public class RolesService {
    private RolesDAO rolesDao;

    public RolesService(RolesDAO rolesDao) {
        this.rolesDao = rolesDao;
    }

    public Roles getRoleById(int id) {
        return rolesDao.getRoleById(id);
    }

    public List<Roles> getAllRoles() {
        return rolesDao.getAllRoles();
    }

    public void saveRole(Roles role) {
        rolesDao.save(role);
    }

    public void updateRole(Roles role) {
        rolesDao.update(role);
    }

    public void deleteRole(Roles role) {
        rolesDao.delete(role);
    }
}
