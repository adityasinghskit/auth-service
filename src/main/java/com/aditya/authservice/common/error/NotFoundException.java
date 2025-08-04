package com.aditya.authservice.common.error;

import java.security.InvalidParameterException;

public class NotFoundException extends InvalidParameterException {

    public NotFoundException(String message) {
        super(message);
    }
}
