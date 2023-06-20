package dao.interfaces;

import models.Suppliers;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SuppliersMapper {

    @Select("SELECT * FROM suppliers")
    List<Suppliers> getAllSuppliers();

    @Select("SELECT * FROM suppliers WHERE supplier_id = #{id}")
    Suppliers getSupplierById(int id);

    @Insert("INSERT INTO suppliers (supplier_id, supplier_name, supplier_address, supplier_email, supplier_phone) VALUES (#{supplierId}, #{supplierName}, #{supplierAddress}, #{supplierEmail}, #{supplierPhone})")
    void save(Suppliers supplier);

    @Update("UPDATE suppliers SET supplier_name = #{supplierName}, supplier_address = #{supplierAddress}, supplier_email = #{supplierEmail}, supplier_phone = #{supplierPhone} WHERE supplier_id = #{supplierId}")
    void update(Suppliers supplier);

    @Delete("DELETE FROM suppliers WHERE supplier_id = #{supplierId}")
    void delete(Suppliers supplier);
}
