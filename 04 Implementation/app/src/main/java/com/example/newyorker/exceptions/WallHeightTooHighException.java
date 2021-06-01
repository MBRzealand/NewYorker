package com.example.newyorker.exceptions;

public class WallHeightTooHighException extends RuntimeException {
    public WallHeightTooHighException(String message) {
        super(message);
    }
}
