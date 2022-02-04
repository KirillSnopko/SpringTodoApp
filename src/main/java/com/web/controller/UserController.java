package com.web.controller;

import com.web.entity.User;
import com.web.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
public class UserController {
    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    @Autowired
    public UserRepository usersRepository;

    /*
    походу этот урл перехватывает spring security

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
*/

    @PostMapping(value = "/signup")
    public ModelAndView registration(@ModelAttribute("user") User user) {
        usersRepository.addSave(user);
        return new ModelAndView("redirect:/login");
    }
}