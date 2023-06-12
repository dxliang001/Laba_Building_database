package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
@XmlRootElement(name = "Suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Suppliers {
    @XmlElement(name = "supplierId")
    private int supplierId;
    @XmlElement(name = "supplierName")
    private String supplierName;
    @XmlElement(name = "supplierAddress")
    private String supplierAddress;
    @XmlElement(name = "supplierEmail")
    private String supplierEmail;
    @XmlElement(name = "supplierPhone")
    private String supplierPhone;

    public Suppliers(int supplierId, String supplierName, String supplierAddress, String supplierEmail, String supplierPhone) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierEmail = supplierEmail;
        this.supplierPhone = supplierPhone;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }
    @Override
    public String toString() {
        return "Suppliers{" +
                "supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                ", supplierEmail='" + supplierEmail + '\'' +
                ", supplierPhone='" + supplierPhone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suppliers that = (Suppliers) o;
        return supplierId == that.supplierId &&
                Objects.equals(supplierName, that.supplierName) &&
                Objects.equals(supplierAddress, that.supplierAddress) &&
                Objects.equals(supplierEmail, that.supplierEmail) &&
                Objects.equals(supplierPhone, that.supplierPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId, supplierName, supplierAddress, supplierEmail, supplierPhone);
    }

}
