package dao.interfaces;

import models.Invoices;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface InvoicesMapper {

    @Select("SELECT * FROM invoices")
    List<Invoices> getAllInvoices();

    @Select("SELECT * FROM invoices WHERE invoice_id = #{id}")
    Invoices getInvoiceById(int id);

    @Insert("INSERT INTO invoices (invoice_id, client_id, project_id, issue_date, due_date, total_amount, payment_id) VALUES (#{invoiceId}, #{clientId}, #{projectId}, #{issueDate}, #{dueDate}, #{totalAmount}, #{paymentId})")
    void save(Invoices invoice);

    @Update("UPDATE invoices SET client_id = #{clientId}, project_id = #{projectId}, issue_date = #{issueDate}, due_date = #{dueDate}, total_amount = #{totalAmount}, payment_id = #{paymentId} WHERE invoice_id = #{invoiceId}")
    void update(Invoices invoice);

    @Delete("DELETE FROM invoices WHERE invoice_id = #{invoiceId}")
    void delete(Invoices invoice);
}
