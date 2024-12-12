package nlt.nltworkshop.web.controllers;

import nlt.nltworkshop.service.UserService;
import nlt.nltworkshop.web.models.UserLoginModel;
import nlt.nltworkshop.web.models.UserRegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("/user/register");
        modelAndView.addObject("time", LocalDate.now().toString());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerPost(UserRegisterModel userRegisterModel) {
        ModelAndView modelAndView = new ModelAndView("redirect:/users/login");

        if (!userService.validateRegisterModel(userRegisterModel)) {
            modelAndView.setViewName("user/register");
            modelAndView.addObject("error", "Invalid input");
            return modelAndView;
        }

        userService.register(userRegisterModel);
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("user/login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginPost(@ModelAttribute UserLoginModel userLoginModel) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");

        if (!userService.loggedIn(userLoginModel)) {
            modelAndView.setViewName("user/login");
            modelAndView.addObject("error", "User nor found");
            return modelAndView;
        }

        return modelAndView;
    }
}
