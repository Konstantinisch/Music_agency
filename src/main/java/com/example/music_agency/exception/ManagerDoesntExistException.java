package com.example.music_agency.exception;



public class ManagerDoesntExistException extends RuntimeException {
    public ManagerDoesntExistException(String message) {
        super(message);
    }
}