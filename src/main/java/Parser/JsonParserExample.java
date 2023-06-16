package Parser;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.javac.Main;
import models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class DataRoot {
    @JsonProperty("employees")
    private List<Employees> employees;
    @JsonProperty("roles")
    private List<Roles> roles;
    @JsonProperty("departments")
    private List<Departments> departments;
    @JsonProperty("projects")
    private List<Projects> projects;
    @JsonProperty("clients")
    private List<Clients> clients;

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public List<Departments> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Departments> departments) {
        this.departments = departments;
    }

    public List<Projects> getProjects() {
        return projects;
    }

    public void setProjects(List<Projects> projects) {
        this.projects = projects;
    }

    public List<Clients> getClients() {
        return clients;
    }

    public void setClients(List<Clients> clients) {
        this.clients = clients;
    }
}

public class JsonParserExample {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("src/main/resources/JSON/data.JSON")));
            DataRoot root = mapper.readValue(jsonString, DataRoot.class);

            // Now you can access the data in the 'root' object
            logger.info(root.getEmployees().get(0).getFirstName());
            logger.info(root.getEmployees().get(0).getRole().getRoleName());

            for (Employees emp : root.getEmployees()) {
                logger.info(emp.getFirstName() + " " + emp.getLastName());
            }

            for (Employees emp : root.getEmployees()) {
                if ("Engineering".equals(emp.getDepartment().getDepartmentName())) {
                    logger.info(emp.getFirstName() + " " + emp.getLastName());
                }
            }

            for (Projects project : root.getProjects()) {
                if ("In Progress".equals(project.getProjectStatus())) {
                    logger.info("Project Name: " + project.getProjectName());
                    logger.info("Start Date: " + project.getStartDate());
                    logger.info("End Date: " + project.getEndDate());
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}