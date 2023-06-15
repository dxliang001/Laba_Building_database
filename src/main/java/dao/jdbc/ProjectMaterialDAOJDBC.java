package dao.jdbc;

import dao.connectionPool.ConnectionPool;
import dao.interfaces.ProjectMaterialDAO;
import models.Materials;
import models.ProjectMaterials;
import models.Projects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectMaterialDAOJDBC implements ProjectMaterialDAO {

    private ConnectionPool connectionPool;
    private MaterialsDAOJDBC materialsDAOJDBC;
    private ProjectsDAOJDBC projectsDAOJDBC;
    public ProjectMaterialDAOJDBC(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        this.projectsDAOJDBC = new ProjectsDAOJDBC(connectionPool);
        this.materialsDAOJDBC = new MaterialsDAOJDBC(connectionPool);
    }

    @Override
    public List<ProjectMaterials> getAllProjectMaterials() {
        List<ProjectMaterials> projectMaterials = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ProjectMaterials");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Projects project = projectsDAOJDBC.getProjectById(rs.getInt("project_id"));
                Materials materials = materialsDAOJDBC.getMaterialById(rs.getInt("material_id"));
                projectMaterials.add(new ProjectMaterials(project,materials, rs.getInt("quantity_required")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectMaterials;
    }

    // Note: Not implementing a getProjectMaterialById method since this table doesn't have a unique id field

    @Override
    public void save(ProjectMaterials projectMaterial) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO ProjectMaterials (project_id, material_id, quantity_required) VALUES (?, ?, ?)");
            ps.setInt(1, projectMaterial.getProjectId().getProjectId());
            ps.setInt(2, projectMaterial.getMaterialId().getMaterialId());
            ps.setInt(3, projectMaterial.getQuantityRequired());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ProjectMaterials projectMaterial) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE ProjectMaterials SET quantity_required = ? WHERE project_id = ? AND material_id = ?");
            ps.setInt(1, projectMaterial.getQuantityRequired());
            ps.setInt(2, projectMaterial.getProjectId().getProjectId());
            ps.setInt(3, projectMaterial.getMaterialId().getMaterialId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ProjectMaterials projectMaterial) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM ProjectMaterials WHERE project_id = ? AND material_id = ?");
            ps.setInt(1, projectMaterial.getProjectId().getProjectId());
            ps.setInt(2, projectMaterial.getMaterialId().getMaterialId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}