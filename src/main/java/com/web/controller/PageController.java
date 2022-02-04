package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class PageController {
    private static final Logger LOGGER = Logger.getLogger(PageController.class.getName());

    @GetMapping("/")
    public String displayWelcom(Model model) {
        return "welcom";
    }

    // for spring sicurity
    @GetMapping("/login")
    public String springLogin(Model model) {
        LOGGER.log(Level.INFO, "user is trying to sign in");
        return "login";
    }

    @GetMapping("/sign_up")
    public String displayRegistration(Model model) {
        LOGGER.log(Level.INFO, "user is trying to sign up");
        return "registration";
    }

    @GetMapping("/user/todo")
    public String displayTodo(Model model) {
        return "todo";
    }
}
