package com.bonappetit.controller;

import com.bonappetit.config.UserSession;
import com.bonappetit.dto.RecipeData;
import com.bonappetit.service.RecipeService;
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
public class RecipeController {
    private final RecipeService recipeService;
    private final UserSession userSession;

    public RecipeController(RecipeService recipeService, UserSession userSession) {
        this.recipeService = recipeService;
        this.userSession = userSession;
    }

    @ModelAttribute("recipeData")
    public RecipeData getRecipeData() {
        return new RecipeData();
    }

    @GetMapping("/recipe-add")
    public ModelAndView showAddRecipePage() {
        ModelAndView modelAndView = new ModelAndView("recipe-add");
        if (!userSession.isLoggedIn()) {
            return new ModelAndView("redirect:/login");
        }
        return modelAndView;
    }

    @PostMapping("/recipe-add")
    public ModelAndView addRecipe(@Valid RecipeData recipeData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("recipe-add");
            modelAndView.addObject("errors", bindingResult.getAllErrors());
            return modelAndView;
        }
        boolean success = recipeService.create(recipeData);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/add-to-favourites/{recipeId}")
    public ModelAndView addToFavourites(@PathVariable UUID recipeId) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        if (!userSession.isLoggedIn()) {
            return new ModelAndView("redirect:/login");
        }

        recipeService.addToFavourites(userSession.getId(), recipeId);

        return modelAndView;
    }
}
