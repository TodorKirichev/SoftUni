package com.philately.controller;

import com.philately.model.entity.User;
import com.philately.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public RedirectView redirectToIndex() {
        return new RedirectView("/index");
    }

    @GetMapping("/index")
    public ModelAndView ShowIndexPage() {
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView ShowHomePage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("home");

        UUID currentUserId = (UUID) session.getAttribute("user_id");

        return modelAndView;
    }
}
