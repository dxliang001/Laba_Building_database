package models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Date;
import java.util.Objects;
@XmlRootElement(name = "Projects")
@XmlAccessorType(XmlAccessType.FIELD)
public class Projects {

    @JsonProperty("project_id")
    @XmlElement(name = "projectId")
    private int projectId;
    @JsonProperty("project_name")
    @XmlElement(name = "projectName")
    private String projectName;

    @JsonProperty("start_date")
    @XmlElement(name = "startDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonProperty("end_date")
    @XmlElement(name = "endDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;

    @JsonProperty("client")
    @XmlElement(name = "clientId")
    private Clients clientId;

    @JsonProperty("project_status")
    @XmlElement(name = "projectStatus")
    private String projectStatus;

    public Projects (){}

    public Projects(int projectId, String projectName, Date startDate, Date endDate, Clients clientId, String projectStatus) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.clientId = clientId;
        this.projectStatus = projectStatus;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Clients getClientId() {
        return clientId;
    }

    public void setClientId(Clients clientId) {
        this.clientId = clientId;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", clientId=" + clientId +
                ", projectStatus='" + projectStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projects that = (Projects) o;
        return projectId == that.projectId &&
                clientId == that.clientId &&
                Objects.equals(projectName, that.projectName) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(projectStatus, that.projectStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, projectName, startDate, endDate, clientId, projectStatus);
    }
}
