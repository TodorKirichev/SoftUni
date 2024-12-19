package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.dto.UserRegisterDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @GetMapping("/users/register")
    public String viewRegister() {
        return "register";
    }

    @PostMapping("/users/register")
    public String registerUser(@Valid UserRegisterDto userRegisterDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "register";
        }
        redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto);

        return "redirect:/users/login";
    }

    @GetMapping("/users/login")
    public String login() {
        return "login";
    }
}
