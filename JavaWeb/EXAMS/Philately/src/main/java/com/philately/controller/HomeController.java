package com.philately.controller;

import com.philately.model.entity.Stamp;
import com.philately.model.entity.User;
import com.philately.service.StampService;
import com.philately.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Controller
public class HomeController {

    private final StampService stampService;
    private final UserService userService;

    public HomeController(StampService stampService, UserService userService) {
        this.stampService = stampService;
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

        User currentUser = userService.findUserById(currentUserId);
        modelAndView.addObject("currentUser", currentUser.getUsername());

        List<Stamp> stampsAddedByCurrentUser = stampService.getStampsAddedByCurrentUser(currentUser);
        modelAndView.addObject("stampsAddedByCurrentUser", stampsAddedByCurrentUser);

        List<Stamp> allOtherStamps = stampService.getAllStampsByOtherUsers(currentUserId);
        modelAndView.addObject("allOtherStamps", allOtherStamps);

        Collection<Stamp> wishedStamps = currentUser.getWishedStamps();
        modelAndView.addObject("wishedStamps", wishedStamps);

        return modelAndView;
    }
}
