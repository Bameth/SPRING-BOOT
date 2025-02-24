package org.example.spring.utils.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.spring.utils.validators.impl.ListNotEmptyValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ListNotEmptyValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ListNotEmpty {
    String message() default "La liste est obligatoire";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
