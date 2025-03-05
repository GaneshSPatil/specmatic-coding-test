package com.store.annotations;

import com.store.validators.TextOnlyValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TextOnlyValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface TextOnly {
    String message() default "Must be a valid text";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
