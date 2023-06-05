package models;
import java.sql.Date;
import java.util.Objects;

public class Invoices {
    private int invoiceId;
    private Clients clientId;
    private Projects projectId;
    private Date issueDate;
    private Date dueDate;
    private double totalAmount;
    private Payments paymentId;

    public Invoices(int invoiceId, Clients clientId, Projects projectId, Date issueDate, Date dueDate, double totalAmount, Payments paymentId) {
        this.invoiceId = invoiceId;
        this.clientId = clientId;
        this.projectId = projectId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.totalAmount = totalAmount;
        this.paymentId = paymentId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Clients getClientId() {
        return clientId;
    }

    public void setClientId(Clients clientId) {
        this.clientId = clientId;
    }

    public Projects getProjectId() {
        return projectId;
    }

    public void setProjectId(Projects projectId) {
        this.projectId = projectId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Payments getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Payments paymentId) {
        this.paymentId = paymentId;
    }
    @Override
    public String toString() {
        return "Invoices{" +
                "invoiceId=" + invoiceId +
                ", clientId=" + clientId +
                ", projectId=" + projectId +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", totalAmount=" + totalAmount +
                ", paymentId=" + paymentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoices invoices = (Invoices) o;
        return invoiceId == invoices.invoiceId &&
                clientId == invoices.clientId &&
                projectId == invoices.projectId &&
                totalAmount == invoices.totalAmount &&
                paymentId == invoices.paymentId &&
                Objects.equals(issueDate, invoices.issueDate) &&
                Objects.equals(dueDate, invoices.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, clientId, projectId, issueDate, dueDate, totalAmount, paymentId);
    }
}
