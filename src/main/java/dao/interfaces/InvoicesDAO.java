package dao.interfaces;

import models.Invoices;
import java.util.List;

public interface InvoicesDAO {
    List<Invoices> getAllInvoices();
    Invoices getInvoiceById(int id);
    void save(Invoices invoice);
    void update(Invoices invoice);
    void delete(Invoices invoice);
}