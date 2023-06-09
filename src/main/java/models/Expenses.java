package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.util.Objects;

@XmlRootElement(name = "Expenses")
@XmlAccessorType(XmlAccessType.FIELD)
public class Expenses {
    @XmlElement(name = "expenseId")
    private int expenseId;
    @XmlElement(name = "projectId")
    private Projects projectId;
    @XmlElement(name = "amount")
    private double amount;
    @XmlElement(name = "expenseDate")
    private Date expenseDate;
    @XmlElement(name = "description")
    private String description;

    public Expenses() {}

    public Expenses(int expenseId, Projects projectId, double amount, Date expenseDate, String description) {
        this.expenseId = expenseId;
        this.projectId = projectId;
        this.amount = amount;
        this.expenseDate = expenseDate;
        this.description = description;
    }


    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
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

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", projectId='" + projectId + '\'' +
                ", amount='" + amount + '\'' +
                ", expenseDate='" + expenseDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expenses that = (Expenses)  o;
        return expenseId == that.expenseId &&
                projectId == that.projectId &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(expenseDate, that.expenseDate) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expenseId, projectId, amount, expenseDate, description);
    }
}
