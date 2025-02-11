package com.paintingscollectors.controller;

import com.paintingscollectors.model.dto.PaintingData;
import com.paintingscollectors.model.entity.Painting;
import com.paintingscollectors.model.entity.StyleName;
import com.paintingscollectors.model.entity.User;
import com.paintingscollectors.service.PaintingService;
import com.paintingscollectors.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/paintings")
public class PaintingController {

    private final PaintingService paintingService;
    private final UserService userService;

    public PaintingController(PaintingService paintingService, UserService userService) {
        this.paintingService = paintingService;
        this.userService = userService;
    }

    @ModelAttribute("paintingData")
    public PaintingData paintingData() {
        return new PaintingData();
    }

    @ModelAttribute("styles")
    public List<StyleName> styles() {
        return List.of(StyleName.values());
    }

    @GetMapping("/add")
    public ModelAndView showAddPaintingPage() {
        return new ModelAndView("add-painting");
    }

    @PostMapping("/add")
    public ModelAndView addPainting(@Valid PaintingData paintingData, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("add-painting");
        }
        paintingService.addPainting(paintingData, (UUID) session.getAttribute("user_id"));

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView removePainting(@PathVariable UUID id) {
        paintingService.removePainting(id);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/add-to-favourites/{id}")
    public ModelAndView addToFavourites(@PathVariable UUID id, HttpSession session) {
        Painting painting = paintingService.getById(id);

        userService.addToFavourite(painting, (UUID) session.getAttribute("user_id"));

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/remove-from-favourites/{id}")
    public ModelAndView removeFromFavourites(@PathVariable UUID id, HttpSession session) {
        Painting painting = paintingService.getById(id);
        userService.removeFromFavourites(painting, (UUID) session.getAttribute("user_id"));

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/vote/{id}")
    public ModelAndView vote(@PathVariable UUID id, HttpSession session) {
        paintingService.increaseVote(id, (UUID) session.getAttribute("user_id"));
        return new ModelAndView("redirect:/home");
    }
}
