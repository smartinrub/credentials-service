package org.smartinrub.credentialsservice.handlers;

import org.smartinrub.credentialsservice.exceptions.CredentialsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CredentialsNotFoundException.class)
    public void handleCredentialsNotFound() {
    }
}
