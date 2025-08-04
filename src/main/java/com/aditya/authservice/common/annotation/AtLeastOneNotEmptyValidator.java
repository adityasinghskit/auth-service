package com.aditya.authservice.common.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanWrapperImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AtLeastOneNotEmptyValidator implements ConstraintValidator<AtLeastOneNotEmpty, Object> {

    private String[] fields;

    public void initialize(AtLeastOneNotEmpty constraintAnnotation) {
        this.fields = constraintAnnotation.fields();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {

        List<String> fieldValues = new ArrayList<>();

        for (String field : fields) {
            Object propertyValue = new BeanWrapperImpl(value).getPropertyValue(field);
            if (ObjectUtils.isEmpty(propertyValue)) {
                fieldValues.add(null);
            } else {
                fieldValues.add(propertyValue.toString());
            }
        }
        return  fieldValues.stream().anyMatch(Objects::nonNull);
    }
}
