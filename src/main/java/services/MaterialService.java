package services;

import dao.interfaces.MaterialsMapper;
import models.Materials;

import java.util.List;

public class MaterialService {
    private MaterialsMapper materialsMapper;

    public MaterialService(MaterialsMapper materialsMapper) {
        this.materialsMapper = materialsMapper;
    }

    public Materials getMaterialById(int id) {
        return materialsMapper.getMaterialById(id);
    }

    public List<Materials> getAllMaterials() {
        return materialsMapper.getAllMaterials();
    }

    public void saveMaterial(Materials material) {
        materialsMapper.save(material);
    }

    public void updateMaterial(Materials material) {
        materialsMapper.update(material);
    }

    public void deleteMaterial(Materials material) {
        materialsMapper.delete(material);
    }
}
