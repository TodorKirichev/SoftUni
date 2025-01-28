package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.UserLoginRequest;
import com.dictionaryapp.model.dto.UserRegisterRequest;
import com.dictionaryapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegisterRequest userRegisterRequest() {
        return new UserRegisterRequest();
    }

    @ModelAttribute("loginData")
    public UserLoginRequest userLoginRequest() {
        return new UserLoginRequest();
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView createNewUser(@Valid UserRegisterRequest userRegisterRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userService.registerUser(userRegisterRequest)) {
            redirectAttributes.addFlashAttribute("user", userRegisterRequest);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);

            return new ModelAndView("redirect:/register");
        }

        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid UserLoginRequest userLoginRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginData", userLoginRequest);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginData", bindingResult);
            return new ModelAndView("redirect:/login");
        }
        boolean success = userService.login(userLoginRequest);

        if (!success) {
            redirectAttributes.addFlashAttribute("loginData", userLoginRequest);
            redirectAttributes.addFlashAttribute("userPassMismatch", true);
            return new ModelAndView("redirect:/login");
        }
        return new ModelAndView("redirect:/home");
    }
}
