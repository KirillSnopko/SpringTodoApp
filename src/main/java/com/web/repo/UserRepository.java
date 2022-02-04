package com.web.repo;

import com.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public void addSave(User user) {
        String sql = "insert into users (firstName, secondName, username, password, email, authority) values (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getSecondName(), user.getLogin(), user.getPassword(), user.getEmail(), user.getRole());
    }

    public User getByUserName(String name) {
        String sql = "SELECT users.id, users.firstName, users.secondName, users.username," +
                " users.password, users.email, users.authority from users where username=?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), name);
    }

   /* String sql = "SELECT users.id, users.firstName, users.secondName, users.username," +
            " users.password, users.email, authorities.authority from users join authorities" +
            " on users.username=authorities.username where users.username=?";*/
}
