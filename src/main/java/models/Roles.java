package models;


import com.fasterxml.jackson.annotation.JsonProperty;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Objects;
@XmlRootElement(name = "Roles")
@XmlAccessorType(XmlAccessType.FIELD)
public class Roles {
    @JsonProperty("role_id")
    @XmlElement(name = "roleId")
    private int roleId;
    @JsonProperty("role_name")
    @XmlElement(name = "roleName")
    private String roleName;
    @JsonProperty("role_description")
    @XmlElement(name = "roleDescription")
    private String roleDescription;

    public Roles() {}
    public Roles(int roleId, String roleName, String roleDescription) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles that = (Roles) o;
        return roleId == that.roleId &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(roleDescription, that.roleDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, roleDescription);
    }

}
