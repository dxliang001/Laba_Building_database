package services;

import dao.interfaces.SuppliersDAO;
import models.Suppliers;

import java.util.List;

public class SupplierService {
    private SuppliersDAO suppliersDao;

    public SupplierService(SuppliersDAO suppliersDao) {
        this.suppliersDao = suppliersDao;
    }

    public Suppliers getSupplierById(int id) {
        return suppliersDao.getSupplierById(id);
    }

    public List<Suppliers> getAllSuppliers() {
        return suppliersDao.getAllSuppliers();
    }

    public void saveSupplier(Suppliers supplier) {
        suppliersDao.save(supplier);
    }

    public void updateSupplier(Suppliers supplier) {
        suppliersDao.update(supplier);
    }

    public void deleteSupplier(Suppliers supplier) {
        suppliersDao.delete(supplier);
    }
}
