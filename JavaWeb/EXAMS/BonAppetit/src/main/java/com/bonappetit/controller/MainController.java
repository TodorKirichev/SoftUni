package com.bonappetit.controller;

import com.bonappetit.config.UserSession;
import com.bonappetit.model.entity.CategoryName;
import com.bonappetit.model.entity.Recipe;
import com.bonappetit.service.RecipeService;
import com.bonappetit.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private final UserSession userSession;
    private final RecipeService recipeService;
    private final UserService userService;

    public MainController(UserSession userSession, RecipeService recipeService, UserService userService) {
        this.userSession = userSession;
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @GetMapping("/")
    public RedirectView redirectToIndex() {
        return new RedirectView("/index");
    }

    @GetMapping("/index")
    public String showIndexPage() {
        if (userSession.isLoggedIn()) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    public ModelAndView showHomePage() {
        ModelAndView modelAndView = new ModelAndView("home");
        if (!userSession.isLoggedIn()) {

            return new ModelAndView("redirect:/index");
        }
        Map<CategoryName, List<Recipe>> allRecipeByCategory = recipeService.findAllByCategory();
        List<Recipe> favouriteRecipes = userService.findFavouriteRecipes();

        modelAndView.addObject("cocktails", allRecipeByCategory.get(CategoryName.COCKTAIL));
        modelAndView.addObject("desserts", allRecipeByCategory.get(CategoryName.DESSERT));
        modelAndView.addObject("mainDishes", allRecipeByCategory.get(CategoryName.MAIN_DISH));
        modelAndView.addObject("favouriteRecipes", favouriteRecipes);


        return modelAndView;
    }
}
