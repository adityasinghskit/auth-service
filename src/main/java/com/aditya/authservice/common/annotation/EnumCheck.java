package com.aditya.authservice.common.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({ FIELD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumCheckValidator.class)
public @interface EnumCheck {

    String message() default "DocType must be PAN or GST";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

    Class<? extends Enum<?>> enumClass();
}

