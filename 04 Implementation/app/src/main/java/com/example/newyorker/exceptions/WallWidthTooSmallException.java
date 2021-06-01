package com.example.newyorker.exceptions;

public class WallWidthTooSmallException extends RuntimeException {
    public WallWidthTooSmallException(String message) {
        super(message);
    }
}
