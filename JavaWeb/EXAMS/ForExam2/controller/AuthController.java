package com.likebookapp.controller;

import com.likebookapp.model.dto.LoginRequest;
import com.likebookapp.model.dto.RegisterRequest;
import com.likebookapp.model.entity.User;
import com.likebookapp.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static com.likebookapp.util.ErrorMessages.INVALID_USERNAME_PASSWORD;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
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
    public ModelAndView showRegisterPage() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@Valid RegisterRequest registerRequest, BindingResult bindingResult) {

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
    public ModelAndView showLoginPage() {

        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid LoginRequest loginRequest, BindingResult bindingResult, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView("login");

        User loggedInUser = userService.loginUser(loginRequest);

        if (loggedInUser == null) {
            modelAndView.addObject("errorMessage", INVALID_USERNAME_PASSWORD);
            return modelAndView;
        }
        session.setAttribute("user_id", loggedInUser.getId());

        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {

        session.invalidate();
        return new ModelAndView("redirect:/");
    }
}
