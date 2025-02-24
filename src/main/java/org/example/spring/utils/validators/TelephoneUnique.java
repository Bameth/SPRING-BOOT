package org.example.spring.utils.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.spring.utils.validators.impl.TelephoneUniqueValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TelephoneUniqueValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface TelephoneUnique {
    String message() default "Le telephone doit etre unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
