package com.example.newyorker.exceptions;

public class WallHeightTooSmallException extends RuntimeException {
    public WallHeightTooSmallException(String message) {
        super(message);
    }
}
