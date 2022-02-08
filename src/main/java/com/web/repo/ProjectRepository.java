package com.web.repo;

import com.web.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.web.utils.ConstantClass.*;
import static com.web.utils.SqlQueries.*;

@Repository
public class ProjectRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Integer> getIdProjectsByIdUser(int id, String role) {
        String sql;
        if (role.equals(ROLE_USER)) {
            sql = GET_LIST_PROJECT_BY_USER_ID;
        } else {
            sql = GET_LIST_PROJECT_BY_ADMIN_ID;
        }
        return jdbcTemplate.queryForList(sql, Integer.class, id);
    }

    public void addProject(int adminId) {
        jdbcTemplate.update(ADD_PROJECT, adminId);
    }

    public List<Project> getByUserName(String name) {
        return jdbcTemplate.query(GET_PROJECT_BY_USERNAME, new ProjectsMapper(), name);
    }


    public Project getProjectById(int id) {
        return jdbcTemplate.queryForObject(GET_PROJECT_BY_ID, new ProjectsMapper(), id);
    }

    @Transactional
    public void deleteProject(int projectId) {
        jdbcTemplate.update(DELETE_COMMENTS_BY_PROJECT_ID, projectId);
        jdbcTemplate.update(DELETE_TASKS_BY_PROJECT_ID, projectId);
        jdbcTemplate.update(DELETE_PROJECT_BY_ID, projectId);
        jdbcTemplate.update(DELETE_FROM_USER_PROJECT_BY_PROJECT_ID, projectId);
    }

    public void updateStatus(int idProject, String status) {
        jdbcTemplate.update(CHANGE_PROJECT_STATUS, status, idProject);
    }

    public void addUserInProject(int idUser, int idProject) {
        jdbcTemplate.update(ADD_USER_IN_PROJECT, idUser, idProject);
    }

    private class ProjectsMapper implements RowMapper<Project> {
        @Override
        public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
            Project project = new Project();
            project.setId(rs.getInt(ID));
            project.setAdmin(rs.getString(USERNAME));
            project.setStatus(rs.getString(STATUS));
            return project;
        }
    }
}
