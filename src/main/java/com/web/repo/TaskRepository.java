package com.web.repo;

import com.web.entity.Task;
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
public class TaskRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Task> getByIdProject(int id) {
        return jdbcTemplate.query(GET_BY_ID_PROJECT, new TaskMapper(), id);
    }


    public void addSave(int idProject, String task, int idUser) {
        jdbcTemplate.update(ADD_TASK, idProject, task, idUser);
    }

    public void changeStatus(String status, int id) {
        if (status.equals("COMPLETED")) {
            jdbcTemplate.update(CHANGE_STATUS_TASK_AND_FINISH, status, id);
        } else {
            jdbcTemplate.update(CHANGE_STATUS_TASK, status, id);
        }
    }

    @Transactional
    public void deleteTaskByTaskId(int id) {
        jdbcTemplate.update(DELETE_COMMENTS, id);
        jdbcTemplate.update(DELETE_TASK, id);
    }

    public Task getTaskByTaskId(int taskId) {
        return jdbcTemplate.queryForObject(GET_TASK_BY_ID_TASK, new TaskMapper(), taskId);
    }

    private class TaskMapper implements RowMapper<Task> {

        @Override
        public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
            Task task = new Task();
            task.setId(rs.getInt(ID));
            task.setIdProject(rs.getInt(ID_PROJECT));
            task.setTask(rs.getString(TASK));
            task.setIdUser(rs.getInt(ID_USER));
            task.setDateStart(rs.getDate(DATE_START));
            task.setDateFinish(rs.getDate(DATE_FINISH));
            task.setStatus(rs.getString(STATUS));
            return task;
        }
    }
}
