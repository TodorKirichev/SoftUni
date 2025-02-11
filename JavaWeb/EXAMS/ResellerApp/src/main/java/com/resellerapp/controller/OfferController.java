package com.resellerapp.controller;

import com.resellerapp.config.UserSession;
import com.resellerapp.model.dto.OfferData;
import com.resellerapp.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class OfferController {

    private final UserSession userSession;
    private final OfferService offerService;

    public OfferController(UserSession userSession, OfferService offerService) {
        this.userSession = userSession;
        this.offerService = offerService;
    }

    @ModelAttribute("offerData")
    public OfferData offerData() {
        return new OfferData();
    }

    @GetMapping("/offer-add")
    public ModelAndView showOfferAddPage() {
        if (!userSession.isLoggedIn()) {
            return new ModelAndView("redirect:/login");
        }
        return new ModelAndView("offer-add");
    }

    @PostMapping("/offer-add")
    public ModelAndView addOffer(@Valid OfferData offerData, BindingResult bindingResult) {
        if (!userSession.isLoggedIn()) {
            return new ModelAndView("redirect:/login");
        }
        ModelAndView modelAndView = new ModelAndView("offer-add");

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("errors", bindingResult.getAllErrors());
            return modelAndView;
        }
        offerService.addOffer(offerData);
        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }

    @PostMapping("/offers/buy/{id}")
    public ModelAndView buyOffer(@PathVariable UUID id) {
        if (!userSession.isLoggedIn()) {
            return new ModelAndView("redirect:/login");
        }
        offerService.buyOffer(id);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/offers/remove/{id}")
    public ModelAndView removeOffer(@PathVariable UUID id) {
        if (!userSession.isLoggedIn()) {
            return new ModelAndView("redirect:/login");
        }
        offerService.removeOffer(id);
        return new ModelAndView("redirect:/home");
    }
}
