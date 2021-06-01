package com.example.newyorker.Exceptions;

public class MissingWallHeightException extends RuntimeException {
    public MissingWallHeightException(String message) {
        super(message);
    }
}
