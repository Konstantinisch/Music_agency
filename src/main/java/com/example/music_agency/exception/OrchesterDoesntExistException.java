package com.example.music_agency.exception;

public class OrchesterDoesntExistException extends RuntimeException {
    public OrchesterDoesntExistException(String message) {
        super(message);
    }
}
