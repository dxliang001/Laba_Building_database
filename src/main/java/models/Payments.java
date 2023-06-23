package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.util.Objects;
@XmlRootElement(name = "Payments")
@XmlAccessorType(XmlAccessType.FIELD)
public class Payments {
    @XmlElement(name = "paymentId")
    private int paymentId;
    @XmlElement(name = "clientId")
    private Clients clientId;
    @XmlElement(name = "projectId")
    private Projects projectId;
    @XmlElement(name = "amount")
    private double amount;
    @XmlElement(name = "paymentDate")
    private Date paymentDate;
    @XmlElement(name = "paymentMethod")
    private String paymentMethod;

    public Payments() {}
    public Payments(int paymentId, Clients clientId, Projects projectId, double amount, Date paymentDate, String paymentMethod) {
        this.paymentId = paymentId;
        this.clientId = clientId;
        this.projectId = projectId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    @Override
    public String toString() {
        return "Payments{" +
                "paymentId=" + paymentId +
                ", clientId=" + (clientId != null ? clientId.getClientId() : "null") +
                ", projectId=" + (projectId != null ? projectId.getProjectId() : "null") +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payments that = (Payments) o;
        return paymentId == that.paymentId &&
                clientId == that.clientId &&
                projectId == that.projectId &&
                amount == that.amount &&
                Objects.equals(paymentDate, that.paymentDate) &&
                Objects.equals(paymentMethod, that.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, clientId, projectId, amount, paymentDate, paymentMethod);
    }
}
