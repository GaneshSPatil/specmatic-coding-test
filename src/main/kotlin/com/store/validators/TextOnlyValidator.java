package com.store.validators;

import com.store.annotations.TextOnly;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TextOnlyValidator implements ConstraintValidator<TextOnly, String> {
    private static final String INVALID_PATTERN = ".*\\d.*|(?i)\\b(true|false)\\b";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || !value.matches(INVALID_PATTERN);
    }
}
