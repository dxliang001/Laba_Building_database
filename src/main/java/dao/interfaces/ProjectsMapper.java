package dao.interfaces;

import models.Projects;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProjectsMapper {

    @Select("SELECT * FROM projects")
    List<Projects> getAllProjects();

    @Select("SELECT * FROM projects WHERE project_id = #{id}")
    Projects getProjectById(int id);

    @Insert("INSERT INTO projects (project_id, project_name, start_date, end_date, client_id, project_status) VALUES (#{projectId}, #{projectName}, #{startDate}, #{endDate}, #{clientId}, #{projectStatus})")
    void save(Projects project);

    @Update("UPDATE projects SET project_name = #{projectName}, start_date = #{startDate}, end_date = #{endDate}, client_id = #{clientId}, project_status = #{projectStatus} WHERE project_id = #{projectId}")
    void update(Projects project);

    @Delete("DELETE FROM projects WHERE project_id = #{projectId}")
    void delete(Projects project);
}
