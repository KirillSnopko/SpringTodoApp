package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

  //  @PostMapping("/login")
    @RequestMapping(name = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("login") String login, @RequestParam("password") String password, Model model) {
        if (login.equals("kira") && password.equals("password")) {
            return "todo";
        } else {
            return "login";
        }
    }

    @PostMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("message", "Hello Spring MVC 5!");
        return "login";
    }
}