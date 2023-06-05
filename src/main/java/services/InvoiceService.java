package services;

import dao.interfaces.InvoicesDAO;
import models.Invoices;

import java.util.List;

public class InvoiceService {
    private InvoicesDAO invoicesDao;

    public InvoiceService(InvoicesDAO invoicesDao) {
        this.invoicesDao = invoicesDao;
    }

    public Invoices getInvoiceById(int id) {
        return invoicesDao.getInvoiceById(id);
    }

    public List<Invoices> getAllInvoices() {
        return invoicesDao.getAllInvoices();
    }

    public void saveInvoice(Invoices invoice) {
        invoicesDao.save(invoice);
    }

    public void updateInvoice(Invoices invoice) {
        invoicesDao.update(invoice);
    }

    public void deleteInvoice(Invoices invoice) {
        invoicesDao.delete(invoice);
    }
}
