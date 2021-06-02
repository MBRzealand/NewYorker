package com.example.newyorker.exceptions;

public class MissingChosenStoreException extends RuntimeException {
    public MissingChosenStoreException(String message) {
        super(message);
    }
}
