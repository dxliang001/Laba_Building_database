package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Date;
import java.util.Objects;


@XmlRootElement(name = "Employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {
    @XmlElement(name = "empId")
    @JsonProperty("emp_id")
    private int empId;
    @JsonProperty("first_name")
    @XmlElement(name = "firstName")
    private String firstName;
    @JsonProperty("last_name")
    @XmlElement(name = "lastName")
    private String lastName;
    @JsonProperty("role")
    @XmlElement(name = "role")
    private Roles role;
    @JsonProperty("department")
    @XmlElement(name = "department")
    private Departments department;
    @JsonProperty("hire_date")
    @XmlElement(name = "hireDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date hireDate;
    @JsonProperty("email")
    @XmlElement(name = "email")
    private String email;
    @JsonProperty("phone_number")
    @XmlElement(name = "phoneNumber")
    private String phoneNumber;

    public Employees() { }
    public Employees(int empId, String firstName, String lastName, Roles role,
                     Departments departmentId, Date hireDate, String email, String phoneNumber) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.department = departmentId;
        this.hireDate = hireDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", department=" + department +
                ", hireDate=" + hireDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees that = (Employees) o;
        return empId == that.empId &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(role, that.role) &&
                Objects.equals(department, that.department) &&
                Objects.equals(hireDate, that.hireDate) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, firstName, lastName, role, department, hireDate, email, phoneNumber);
    }

}