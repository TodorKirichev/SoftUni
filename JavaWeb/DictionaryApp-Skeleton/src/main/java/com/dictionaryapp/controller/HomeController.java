package com.dictionaryapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView notLoggedIn() {
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView loggedIn() {
        return new ModelAndView("home");
    }
}
