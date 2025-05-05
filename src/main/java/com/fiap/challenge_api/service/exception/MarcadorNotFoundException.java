package com.fiap.challenge_api.service.exception;

public class MarcadorNotFoundException extends RuntimeException {
    public MarcadorNotFoundException(String message) {
        super(message);
    }
}
