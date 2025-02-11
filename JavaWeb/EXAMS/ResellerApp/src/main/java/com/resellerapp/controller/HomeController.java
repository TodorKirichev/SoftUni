package com.resellerapp.controller;

import com.resellerapp.config.UserSession;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.service.OfferService;
import com.resellerapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class HomeController {

    private final UserSession userSession;
    private final UserService userService;
    private final OfferService offerService;

    public HomeController(UserSession userSession, UserService userService, OfferService offerService) {
        this.userSession = userSession;
        this.userService = userService;
        this.offerService = offerService;
    }

    @GetMapping("/")
    public RedirectView redirectToIndex() {
        return new RedirectView("/index");
    }

    @GetMapping("/index")
    public ModelAndView showIndexPage() {
        if (userSession.isLoggedIn()) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView showHomePage() {
        if (!userSession.isLoggedIn()) {
            return new ModelAndView("redirect:/index");
        }
        ModelAndView modelAndView = new ModelAndView("home");

        List<Offer> allOffers = offerService.getAllOffers();
        modelAndView.addObject("allOffers", allOffers);

        List<Offer> loggedInUserOffers = userService.getLoggedInUserOffers(userSession.getId());
        modelAndView.addObject("loggedInUserOffers", loggedInUserOffers);

        List<Offer> boughtOffers = offerService.getLoggedInUserBoughtOffers(userSession.getId());
        modelAndView.addObject("boughtOffers", boughtOffers);

        return modelAndView;
    }
}
