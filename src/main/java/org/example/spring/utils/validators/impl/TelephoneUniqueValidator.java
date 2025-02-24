package org.example.spring.utils.validators.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.example.spring.data.entities.Client;
import org.example.spring.data.repositories.ClientRepository;
import org.example.spring.utils.validators.TelephoneUnique;

import java.util.Optional;

@RequiredArgsConstructor
public class TelephoneUniqueValidator implements ConstraintValidator<TelephoneUnique, String> {
    private final ClientRepository clientRepository;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
       var client = clientRepository.findByTelephone(s).orElse(null);
        return client == null;
    }
}
