package dao.interfaces;

import models.Materials;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MaterialsMapper {

    @Select("SELECT * FROM materials")
    List<Materials> getAllMaterials();

    @Select("SELECT * FROM materials WHERE material_id = #{id}")
    Materials getMaterialById(int id);

    @Insert("INSERT INTO materials (material_id, material_name, material_description, supplier_id) VALUES (#{materialId}, #{materialName}, #{materialDescription}, #{supplierId})")
    void save(Materials material);

    @Update("UPDATE materials SET material_name = #{materialName}, material_description = #{materialDescription}, supplier_id = #{supplierId} WHERE material_id = #{materialId}")
    void update(Materials material);

    @Delete("DELETE FROM materials WHERE material_id = #{materialId}")
    void delete(Materials material);
}
