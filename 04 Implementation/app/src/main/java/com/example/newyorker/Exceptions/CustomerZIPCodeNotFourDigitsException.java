package com.example.newyorker.Exceptions;

public class CustomerZIPCodeNotFourDigitsException extends RuntimeException {
    public CustomerZIPCodeNotFourDigitsException(String message) {
        super(message);
    }
}
