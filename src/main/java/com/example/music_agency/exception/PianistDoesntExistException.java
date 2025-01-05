package com.example.music_agency.exception;

public class PianistDoesntExistException extends RuntimeException {
    public PianistDoesntExistException(String message) {
        super(message);
    }
}
