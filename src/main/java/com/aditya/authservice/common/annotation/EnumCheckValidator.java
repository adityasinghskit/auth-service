package com.aditya.authservice.common.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class EnumCheckValidator implements ConstraintValidator<EnumCheck,String> {
    private Class<? extends Enum<?>> enumClass;
    @Override
    public void initialize(EnumCheck constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; 
        }

        if (!isValidEnum(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Invalid enum value. Allowed values are: " + Arrays.toString(enumClass.getEnumConstants()))
                   .addConstraintViolation();
            return false;
        }

        return true;
    }

    private boolean isValidEnum(String value) {
        return Arrays.stream(enumClass.getEnumConstants())
                     .map(Enum::name)
                     .anyMatch(enumValue -> enumValue.equals(value));
    }

}