package com.bonappetit.dto;

import com.bonappetit.model.entity.Category;
import com.bonappetit.model.entity.CategoryName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeData {

    @NotBlank
    @Size(min = 2, max = 40, message = "Name length must be between 2 and 40 characters")
    private String name;

    @Size(min = 2, max = 150, message = "Ingredients length must be between 2 and 150 characters")
    private String ingredients;

    @NotNull(message = "You must select a category")
    private CategoryName category;
}
