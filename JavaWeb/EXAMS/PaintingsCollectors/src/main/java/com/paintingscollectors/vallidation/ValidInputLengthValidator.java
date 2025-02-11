package com.paintingscollectors.vallidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidInputLengthValidator implements ConstraintValidator<ValidInputLength, String> {

    @Override
    public void initialize(ValidInputLength constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().isEmpty()) {
            return false;
        }

        return value.length() >= 3 && value.length() <= 20;
    }
}