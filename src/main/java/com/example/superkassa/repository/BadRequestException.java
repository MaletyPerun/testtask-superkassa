package com.example.superkassa.repository;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.http.HttpStatus;

import static org.springframework.boot.web.error.ErrorAttributeOptions.Include.MESSAGE;

public class BadRequestException extends AppException {
    public BadRequestException(Object message) {
        super(HttpStatus.I_AM_A_TEAPOT, message.toString(), ErrorAttributeOptions.of(MESSAGE));
    }
}
