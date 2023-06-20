package dao.interfaces;

import models.ProjectMaterials;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProjectMaterialsMapper {

    @Select("SELECT * FROM project_materials")
    List<ProjectMaterials> getAllProjectMaterials();

    @Select("SELECT * FROM project_materials WHERE project_id = #{projectId} AND material_id = #{materialId}")
    ProjectMaterials getProjectMaterialById(@Param("projectId") int projectId, @Param("materialId") int materialId);

    @Insert("INSERT INTO project_materials (project_id, material_id, quantity_required) VALUES (#{projectId}, #{materialId}, #{quantityRequired})")
    void save(ProjectMaterials projectMaterial);

    @Update("UPDATE project_materials SET quantity_required = #{quantityRequired} WHERE project_id = #{projectId} AND material_id = #{materialId}")
    void update(ProjectMaterials projectMaterial);

    @Delete("DELETE FROM project_materials WHERE project_id = #{projectId} AND material_id = #{materialId}")
    void delete(ProjectMaterials projectMaterial);
}
