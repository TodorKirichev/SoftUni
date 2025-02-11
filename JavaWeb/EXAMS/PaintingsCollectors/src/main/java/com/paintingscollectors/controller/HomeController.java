package com.paintingscollectors.controller;

import com.paintingscollectors.model.entity.Painting;
import com.paintingscollectors.model.entity.User;
import com.paintingscollectors.service.PaintingService;
import com.paintingscollectors.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Controller
public class HomeController {

    private final UserService userService;
    private final PaintingService paintingService;

    public HomeController(UserService userService, PaintingService paintingService) {
        this.userService = userService;
        this.paintingService = paintingService;
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

        User userById = userService.findUserById(currentUserId);
        Set<Painting> addedPaintings = userById.getAddedPaintings();
        modelAndView.addObject("addedPaintings", addedPaintings);

        Set<Painting> allPaintingByOtherUsers = paintingService.findAllPaintingByOtherUsers(currentUserId);
        modelAndView.addObject("allPaintingByOtherUsers", allPaintingByOtherUsers);

        Set<Painting> favouritePaintings = userById.getFavouritePaintings();
        modelAndView.addObject("favouritePaintings", favouritePaintings);

        List<Painting> mostRatedPaintings = paintingService.getMostRatedPaintings();
        modelAndView.addObject("mostRatedPaintings", mostRatedPaintings);

        return modelAndView;
    }
}
