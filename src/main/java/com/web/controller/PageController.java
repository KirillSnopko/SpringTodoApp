package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
    @GetMapping("/")
    public String displayWelcom(Model model) {
        return "welcom";
    }

    @GetMapping("/pageLogin")
    public String displayLogin(Model model) {
        return "login";
    }

    @GetMapping("/pageRegistration")
    public String displayRegistration(Model model) {
        return "registration";
    }
}
