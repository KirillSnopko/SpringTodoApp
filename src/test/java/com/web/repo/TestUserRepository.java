package com.web.repo;

import com.web.config.database.MySQLConfig;
import com.web.config.database.TestMySQLConfig;
import com.web.entity.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@DirtiesContext
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = TestMySQLConfig.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestUserRepository {

    @Autowired
    UserRepository userRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;
    User user;

    @BeforeAll
    @DisplayName("create task user")
    void setUser() {
        user = new User();
        user.setFirstName("Test");
        user.setSecondName("Test");
        user.setLogin("test");
        user.setPassword("test");
        user.setEmail("test@mail.ru");
        user.setRole("ROLE_ADMIN");
    }

    @Test
    @Order(1)
    @DisplayName("save test user")
    void save() {
        userRepository.addSave(user);
    }

    @Test
    @Order(2)
    @DisplayName("get test user")
    void getUser() {
        User userFromDB = userRepository.getByUserName(user.getLogin());
        Assertions.assertTrue(userFromDB.equals(user));
    }


    @AfterAll
    @DisplayName("delete test user")
    void deleteUser() {
        jdbcTemplate.update("DELETE from users where username=?", user.getLogin());
    }
}
