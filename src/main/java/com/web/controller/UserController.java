package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @RequestMapping(name = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("login") String login, @RequestParam("password") String password, Model model) {
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