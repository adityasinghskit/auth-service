package com.aditya.authservice.common.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanWrapperImpl;

public class CountryAccountIbanValidator implements ConstraintValidator<CountryAccountIbanCheck,Object> {
     private String[] fields;

    public void initialize(CountryAccountIbanCheck constraintAnnotation) {
        this.fields = constraintAnnotation.fields();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {
        boolean iban=false;
        boolean countryCode=false;
        boolean accountNumber=false;
        try{
            for (String field : fields) {
                Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
                if (field.equals("iban") && fieldValue != null && !StringUtils.isBlank(fieldValue.toString())) {
                    iban = true;
                } else if (field.equals("countryCode") && fieldValue != null && !fieldValue.toString().isEmpty()) {
                    countryCode = true;
                } else if (field.equals("accountNumber") && fieldValue != null && !fieldValue.toString().isEmpty()) {
                    accountNumber = true;
                }
            }
            if(!iban && (!countryCode || !accountNumber)){
                return false;
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
        
    }


}