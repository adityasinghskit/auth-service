package com.aditya.authservice.common.error;

import java.security.InvalidParameterException;

public class BadRequestException extends InvalidParameterException {

    public BadRequestException(String message) {
        super(message);
    }
}
