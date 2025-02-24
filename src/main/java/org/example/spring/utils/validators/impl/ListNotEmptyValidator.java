package org.example.spring.utils.validators.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.spring.utils.validators.ListNotEmpty;

import java.util.List;

public class ListNotEmptyValidator implements ConstraintValidator<ListNotEmpty, List<?>> {
    @Override
    public boolean isValid(List<?> objects, ConstraintValidatorContext constraintValidatorContext) {
        return objects != null && !objects.isEmpty();
    }
}
