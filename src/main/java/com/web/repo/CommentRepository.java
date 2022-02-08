package com.web.repo;

import com.web.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.web.utils.ConstantClass.*;
import static com.web.utils.SqlQueries.*;

@Repository
public class CommentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addSave(Comment comment) {
        jdbcTemplate.update(ADD_COMMENT, comment.getIdProject(), comment.getIdTask(), comment.getLogin(), comment.getComment());
    }

    public List<Comment> getByIdTask(int id) {
        return jdbcTemplate.query(GET_COMMENT_BY_ID_TASK, new CommentMapper(), id);
    }

    public void deleteCommentsByTaskId(int taskId) {
        jdbcTemplate.update(DELETE_COMMENTS, taskId);
    }

    private class CommentMapper implements RowMapper<Comment> {

        @Override
        public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
            Comment comment = new Comment();
            comment.setId(rs.getInt(ID));
            comment.setIdTask(rs.getInt(ID_TASK));
            comment.setLogin(rs.getString(LOGIN));
            comment.setComment(rs.getString(COMMENT));
            comment.setDate(rs.getDate(DATE));
            return comment;
        }
    }
}
