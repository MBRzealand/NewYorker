package com.example.newyorker.Exceptions;

public class MissingChosenStoreException extends RuntimeException {
    public MissingChosenStoreException(String message) {
        super(message);
    }
}
