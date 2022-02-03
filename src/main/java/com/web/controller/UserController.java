package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
public class UserController {
    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    /*
    походу этот урл перехватывает spring security
     */
    @RequestMapping(name = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("login") String login, @RequestParam("password") String password, Model model) {
        LOGGER.info("login => " + login);
        LOGGER.info("password => " + password);
        if (login.equals("kira") && password.equals("1234")) {
            return "todo";
        } else {
            return "login";
        }
    }

/*
    @PostMapping(name = "/registration")
    public String registration(@RequestParam("firstName") String firsName,
                               @RequestParam("secondName") String secondName,
                               @RequestParam("login") String login,
                               @RequestParam("password") String password,
                               @RequestParam("email") String email,
                               @RequestParam("role") String role,
                               Model model) {
        model.addAttribute("message", "Hello Spring MVC 5!");
        return "login";
    }*/
}