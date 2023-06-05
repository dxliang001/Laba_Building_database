package dao.interfaces;

import models.Materials;
import java.util.List;

public interface MaterialsDAO {
    List<Materials> getAllMaterials();
    Materials getMaterialById(int id);
    void save(Materials material);
    void update(Materials material);
    void delete(Materials material);
}