package com.bonappetit.service;

import com.bonappetit.config.UserSession;
import com.bonappetit.dto.RecipeData;
import com.bonappetit.model.entity.Category;
import com.bonappetit.model.entity.CategoryName;
import com.bonappetit.model.entity.Recipe;
import com.bonappetit.model.entity.User;
import com.bonappetit.repo.RecipeRepository;
import com.bonappetit.repo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserSession userSession;
    private final UserService userService;
    private final CategoryService categoryService;
    private final UserRepository userRepository;

    public RecipeService(RecipeRepository recipeRepository, UserSession userSession, UserService userService, CategoryService categoryService, UserRepository userRepository) {
        this.recipeRepository = recipeRepository;
        this.userSession = userSession;
        this.userService = userService;
        this.categoryService = categoryService;
        this.userRepository = userRepository;
    }

    public boolean create(RecipeData recipeData) {
        Recipe recipe = new Recipe();

        User user = userService.findById(userSession.getId());
        if (user == null) {
            return false;
        }

        Optional<Category> category = categoryService.findByName(recipeData.getCategory());
        if (category.isEmpty()) {
            return false;
        }

        recipe.setName(recipeData.getName());
        recipe.setIngredients(recipeData.getIngredients());
        recipe.setCategory(category.get());
        recipe.setAddedBy(user);

        recipeRepository.save(recipe);

        return true;
    }

    public Map<CategoryName, List<Recipe>> findAllByCategory() {
        Map<CategoryName, List<Recipe>> allRecipes = new HashMap<>();

        List<Category> categories = categoryService.findAll();

        for (Category category : categories) {
            List<Recipe> recipes = recipeRepository.findByCategory(category);
            allRecipes.put(category.getName(), recipes);
        }
        return allRecipes;
    }

    @Transactional
    public void addToFavourites(UUID id, UUID recipeId) {
        User user = userService.findById(id);
        Recipe recipe = recipeRepository.findById(recipeId).get();

        if (user.getFavouriteRecipes().contains(recipe)) {
            return;
        }
        user.addFavouriteRecipe(recipe);
        userRepository.save(user);
    }
}
