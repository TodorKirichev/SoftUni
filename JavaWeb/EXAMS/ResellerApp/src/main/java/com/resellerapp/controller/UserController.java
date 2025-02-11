package com.resellerapp.controller;

import com.resellerapp.config.UserSession;
import com.resellerapp.model.dto.LoginRequest;
import com.resellerapp.model.dto.RegisterRequest;
import com.resellerapp.service.OfferService;
import com.resellerapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class UserController {

    private final UserSession userSession;
    private final UserService userService;

    public UserController(UserSession userSession, UserService userService) {
        this.userSession = userSession;
        this.userService = userService;
    }

    @ModelAttribute("registerRequest")
    public RegisterRequest registerRequest() {
        return new RegisterRequest();
    }

    @ModelAttribute("loginRequest")
    public LoginRequest loginRequest() {
        return new LoginRequest();
    }

    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        if (userSession.isLoggedIn()) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid LoginRequest loginRequest, BindingResult bindingResult) {
        if (userSession.isLoggedIn()) {
            return new ModelAndView("redirect:/home");
        }

        ModelAndView modelAndView = new ModelAndView("login");

        boolean isLoggedIn = userService.login(loginRequest);

        if (!isLoggedIn || bindingResult.hasErrors()) {
            modelAndView.addObject("errorMessage", "Invalid username or password");
            return modelAndView;
        }
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/register")
    public ModelAndView showRegisterPage() {
        if (userSession.isLoggedIn()) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@Valid RegisterRequest registerRequest, BindingResult bindingResult) {
        if (userSession.isLoggedIn()) {
            return new ModelAndView("redirect:/home");
        }

        ModelAndView modelAndView = new ModelAndView("register");

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("errors", bindingResult.getAllErrors());
            return modelAndView;
        }

        Optional<String> errorMessage = userService.register(registerRequest);
        if (errorMessage.isPresent()) {
            modelAndView.addObject("errorMessage", errorMessage.get());
            return modelAndView;
        }

        modelAndView.setViewName("redirect:/login");

        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        userSession.logout();
        return new ModelAndView("redirect:/index");
    }
}
