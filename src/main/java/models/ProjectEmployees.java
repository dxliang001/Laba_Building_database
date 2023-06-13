package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
@XmlRootElement(name = "ProjectEmployees")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectEmployees {
    @XmlElement(name = "projectId")
    private Projects projectId;
    @XmlElement(name = "empId")
    private Employees empId;

    public ProjectEmployees(Projects projectId, Employees empId) {
        this.projectId = projectId;
        this.empId = empId;
    }

    public Projects getProjectId() {
        return projectId;
    }

    public void setProjectId(Projects projectId) {
        this.projectId = projectId;
    }

    public Employees getEmpId() {
        return empId;
    }

    public void setEmpId(Employees empId) {
        this.empId = empId;
    }
    @Override
    public String toString() {
        return "ProjectEmployees{" +
                "projectId=" + projectId +
                ", empId=" + empId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectEmployees that = (ProjectEmployees) o;
        return projectId == that.projectId &&
                empId == that.empId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, empId);
    }
}
