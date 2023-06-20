package services;

import dao.interfaces.InvoicesMapper;
import models.Invoices;

import java.util.List;

public class InvoiceService {
    private InvoicesMapper invoicesMapper;

    public InvoiceService(InvoicesMapper invoicesMapper) {
        this.invoicesMapper = invoicesMapper;
    }

    public Invoices getInvoiceById(int id) {
        return invoicesMapper.getInvoiceById(id);
    }

    public List<Invoices> getAllInvoices() {
        return invoicesMapper.getAllInvoices();
    }

    public void saveInvoice(Invoices invoice) {
        invoicesMapper.save(invoice);
    }

    public void updateInvoice(Invoices invoice) {
        invoicesMapper.update(invoice);
    }

    public void deleteInvoice(Invoices invoice) {
        invoicesMapper.delete(invoice);
    }
}
