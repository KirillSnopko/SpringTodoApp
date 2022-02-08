package com.web.controller;

import com.web.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.web.utils.ConstantClass.*;

@Controller
@RequestMapping({URL_WELCOM, URL_LOGIN, URL_SIGN_UP, URL_SIGNUP})
public class PageController extends ProjectController {

    private static final Logger LOGGER = Logger.getLogger(PageController.class.getName());

    @GetMapping(URL_WELCOM)
    public String displayWelcom() {
        return WELCOM;
    }

    @GetMapping(URL_LOGIN)
    public String springLogin() {
        return LOGIN;
    }

    @GetMapping(URL_SIGN_UP)
    public String displayRegistration() {
        return REGISTRATION;
    }

    @PostMapping(value = URL_SIGNUP)
    public ModelAndView registration(@ModelAttribute(USER) User user) {
        userService.addSave(user);
        LOGGER.log(Level.INFO, user.getLogin() + LOGGER_LOG_UP);
        return new ModelAndView(REDIRECT_LOGIN);
    }
}
