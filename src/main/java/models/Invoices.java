package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.util.Objects;
@XmlRootElement(name = "Invoices")
@XmlAccessorType(XmlAccessType.FIELD)
public class Invoices {

    @XmlElement(name = "invoiceId")
    private int invoiceId;
    @XmlElement(name = "clientId")
    private Clients clientId;
    @XmlElement(name = "projectId")
    private Projects projectId;
    @XmlElement(name = "issueDate")
    private Date issueDate;
    @XmlElement(name = "dueDate")
    private Date dueDate;
    @XmlElement(name = "totalAmount")
    private double totalAmount;
    @XmlElement(name = "paymentId")
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
                totalAmount == invoices.totalAmount &&
                Objects.equals(clientId, invoices.clientId) &&
                Objects.equals(projectId, invoices.projectId) &&
                Objects.equals(paymentId, invoices.paymentId) &&
                Objects.equals(issueDate, invoices.issueDate) &&
                Objects.equals(dueDate, invoices.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, clientId, projectId, issueDate, dueDate, totalAmount, paymentId);
    }
}
