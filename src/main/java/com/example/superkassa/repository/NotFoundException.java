package com.example.superkassa.repository;

import com.example.superkassa.controller.AppException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.http.HttpStatus;

import static org.springframework.boot.web.error.ErrorAttributeOptions.Include.MESSAGE;

public class NotFoundException extends AppException {
    public NotFoundException(Object message) {
        super(HttpStatus.I_AM_A_TEAPOT, message.toString(), ErrorAttributeOptions.of(MESSAGE));
    }
}
