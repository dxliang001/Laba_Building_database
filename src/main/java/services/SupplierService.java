package services;

import dao.interfaces.SuppliersMapper;
import models.Suppliers;

import java.util.List;

public class SupplierService {
    private SuppliersMapper suppliersMapper;

    public SupplierService(SuppliersMapper suppliersMapper) {
        this.suppliersMapper = suppliersMapper;
    }

    public Suppliers getSupplierById(int id) {
        return suppliersMapper.getSupplierById(id);
    }

    public List<Suppliers> getAllSuppliers() {
        return suppliersMapper.getAllSuppliers();
    }

    public void saveSupplier(Suppliers supplier) {
        suppliersMapper.save(supplier);
    }

    public void updateSupplier(Suppliers supplier) {
        suppliersMapper.update(supplier);
    }

    public void deleteSupplier(Suppliers supplier) {
        suppliersMapper.delete(supplier);
    }
}
