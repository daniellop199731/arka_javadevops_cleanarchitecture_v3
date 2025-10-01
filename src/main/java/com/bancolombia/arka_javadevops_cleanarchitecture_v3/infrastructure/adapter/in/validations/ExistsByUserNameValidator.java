package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.validations;

import org.springframework.stereotype.Component;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in.UserUseCase;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ExistsByUserNameValidator implements ConstraintValidator<ExistsByUserName, String> {

    private final UserUseCase userUseCase;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !userUseCase.existsByUserName(value);
    }
    
}
