package com.resellerapp.model.dto;

import com.resellerapp.model.entity.ConditionName;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OfferData {

    @NotBlank(message = "Description length must be between 2 and 50 symbols")
    @Size(min = 2, max = 50, message = "Description length must be between 2 and 50 symbols")
    private String description;

    @Positive(message = "Price must be a positive number")
    private Double price;

    @NotNull(message = "You must select a condition")
    private ConditionName condition;
}
