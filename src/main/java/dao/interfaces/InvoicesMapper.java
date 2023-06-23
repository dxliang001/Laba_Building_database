package dao.interfaces;

import models.Invoices;

import java.util.List;

public interface InvoicesMapper {

    List<Invoices> getAllInvoices();
    Invoices getInvoiceById(int id);
    void save(Invoices invoice);
    void update(Invoices invoice);
    void delete(Invoices invoice);
}
