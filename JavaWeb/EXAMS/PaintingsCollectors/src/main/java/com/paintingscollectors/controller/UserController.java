package com.paintingscollectors.controller;

import com.paintingscollectors.model.dto.LoginRequest;
import com.paintingscollectors.model.dto.RegisterRequest;
import com.paintingscollectors.model.entity.User;
import com.paintingscollectors.service.UserService;
import jakarta.servlet.http.HttpSession;
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

    private final UserService userService;

    public UserController(UserService userService) {
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

    @GetMapping("/register")
    public ModelAndView showRegisterPage(HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView processRegisterRequest(@Valid RegisterRequest registerRequest, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView("register");

        if (bindingResult.hasErrors()) {
            return modelAndView;
        }

        Optional<String> errorMessage = userService.registerUser(registerRequest);
        if (errorMessage.isPresent()) {
            modelAndView.addObject("errorMessage", errorMessage.get());
            return modelAndView;
        }

        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView showLoginPage(HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid LoginRequest loginRequest, BindingResult bindingResult, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView("login");

        User loggedInUser = userService.loginUser(loginRequest);

        if (loggedInUser == null) {
            modelAndView.addObject("errorMessage", "Invalid username or password.");
            return modelAndView;
        }
        session.setAttribute("user_id", loggedInUser.getId());
        session.setAttribute("user_name", loggedInUser.getUsername());

        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {

        session.invalidate();
        return new ModelAndView("redirect:/index");
    }
}
