package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;


@XmlRootElement(name = "Departments")
@XmlAccessorType(XmlAccessType.FIELD)
public class Departments {
    @XmlElement(name = "departmentId")
    private int departmentId;
    @XmlElement(name = "departmentName")
    private String departmentName;
    @XmlElement(name = "departmentDescription")
    private String departmentDescription;

    public Departments(int departmentId, String departmentName, String departmentDescription) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentDescription='" + departmentDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departments that = (Departments) o;
        return departmentId == that.departmentId &&
                Objects.equals(departmentName, that.departmentName) &&
                Objects.equals(departmentDescription, that.departmentDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, departmentName, departmentDescription);
    }

}
