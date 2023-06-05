package services;

import dao.interfaces.MaterialsDAO;
import models.Materials;

import java.util.List;

public class MaterialService {
    private MaterialsDAO materialsDao;

    public MaterialService(MaterialsDAO materialsDao) {
        this.materialsDao = materialsDao;
    }

    public Materials getMaterialById(int id) {
        return materialsDao.getMaterialById(id);
    }

    public List<Materials> getAllMaterials() {
        return materialsDao.getAllMaterials();
    }

    public void saveMaterial(Materials material) {
        materialsDao.save(material);
    }

    public void updateMaterial(Materials material) {
        materialsDao.update(material);
    }

    public void deleteMaterial(Materials material) {
        materialsDao.delete(material);
    }
}
