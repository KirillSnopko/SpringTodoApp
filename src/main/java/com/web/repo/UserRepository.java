package com.web.repo;

import com.web.entity.User;
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
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addSave(User user) {
        jdbcTemplate.update(ADD_USER, user.getFirstName(), user.getSecondName(), user.getLogin(), NOOP + user.getPassword(), user.getEmail(), user.getRole());
    }

    public User getByUserName(String name) {
        return jdbcTemplate.queryForObject(GET_USER_BY_USERNAME, new UserMapper(), name);
    }

    public List<User> getUsersInProjectByProjectId(int id) {
        return jdbcTemplate.query(GET_USERS_IN_PROJECT, new UserMapper(), id);
    }

    public List<User> getAllUsers() {
        return jdbcTemplate.query(GET_ALL_USERS, new UserMapper());
    }


    private class UserMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt(ID));
            user.setFirstName(rs.getString(FIRST_NAME));
            user.setSecondName(rs.getString(SECOND_NAME));
            user.setLogin(rs.getString(USERNAME));
            user.setPassword(rs.getString(PASSWORD));
            user.setEmail(rs.getString(EMAIL));
            user.setRole(rs.getString(AUTHORITY));
            return user;
        }
    }
}
