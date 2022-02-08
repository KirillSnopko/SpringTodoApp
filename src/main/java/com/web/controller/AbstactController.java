package com.web.controller;

import com.web.entity.User;
import com.web.repo.CommentRepository;
import com.web.service.ProjectService;
import com.web.service.TasksSevice;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.web.utils.ConstantClass.*;

@Controller
@RequestMapping(NOTHING)
public class AbstactController {
    @Autowired
    UserService userService;
    @Autowired
    ProjectService projectService;
    @Autowired
    TasksSevice tasksSevice;
    @Autowired
    CommentRepository commentRepository;
    private static final Logger LOGGER = Logger.getLogger(AbstactController.class.getName());

    public User getUser() {
        return new MySessionInfo().getCurrentUser();
    }

    @Component
    @Scope(SESSION)
    public class MySessionInfo {

        private User user;

        protected User getCurrentUser() {
            if (user == null) {
                user = userService.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
                user.setPassword(NULL);
            }
            LOGGER.log(Level.INFO, user.getLogin() + LOGGER_LOG_IN);
            return user;
        }
    }
}
