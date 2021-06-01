package com.example.newyorker.Exceptions;

public class WallHeightTooHighException extends RuntimeException {
    public WallHeightTooHighException(String message) {
        super(message);
    }
}
