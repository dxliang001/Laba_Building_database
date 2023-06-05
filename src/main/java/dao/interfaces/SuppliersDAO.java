package dao.interfaces;


import models.Suppliers;
import java.util.List;

public interface SuppliersDAO {
    List<Suppliers> getAllSuppliers();
    Suppliers getSupplierById(int id);
    void save(Suppliers supplier);
    void update(Suppliers supplier);
    void delete(Suppliers supplier);
}