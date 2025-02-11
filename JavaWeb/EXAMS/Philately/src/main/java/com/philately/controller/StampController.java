package com.philately.controller;

import com.philately.model.dto.StampData;
import com.philately.model.entity.PaperName;
import com.philately.model.entity.Stamp;
import com.philately.model.entity.User;
import com.philately.repository.StampRepository;
import com.philately.repository.UserRepository;
import com.philately.service.StampService;
import com.philately.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/stamps")
public class StampController {

    private final StampService stampService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final StampRepository stampRepository;

    public StampController(StampService stampService, UserService userService, UserRepository userRepository, StampRepository stampRepository) {
        this.stampService = stampService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.stampRepository = stampRepository;
    }

    @ModelAttribute("papers")
    public List<PaperName> getPapers() {
        return List.of(PaperName.values());
    }

    @ModelAttribute("stampData")
    public StampData getStampData() {
        return new StampData();
    }

    @GetMapping("/add-stamp")
    public ModelAndView showAddStampPage() {


        return new ModelAndView("add-stamp");
    }

    @PostMapping("/add-stamp")
    public ModelAndView addStamp(@Valid StampData stampData, BindingResult bindingResult, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("add-stamp");
        }
        stampService.addStamp(stampData, String.valueOf(session.getAttribute("user_id")));

        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/add-to-wishlist/{id}")
    public ModelAndView addStampToWishlist(@PathVariable UUID id, HttpSession session) {

        Stamp stamp = stampService.findById(id);
        User user = userService.findUserById((UUID) session.getAttribute("user_id"));
        user.getWishedStamps().add(stamp);
        stampRepository.save(stamp);
        userRepository.save(user);

        return new ModelAndView("redirect:/home");
    }
}
