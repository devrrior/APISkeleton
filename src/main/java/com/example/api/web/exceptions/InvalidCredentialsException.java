package com.example.api.web.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidCredentialsException extends RuntimeException {
    private final HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;

    public InvalidCredentialsException() {
        super("Invalid credentials");
    }
}
