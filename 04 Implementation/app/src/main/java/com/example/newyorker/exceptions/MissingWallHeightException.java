package com.example.newyorker.exceptions;

public class MissingWallHeightException extends RuntimeException {
    public MissingWallHeightException(String message) {
        super(message);
    }
}
