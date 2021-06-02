package com.example.newyorker.exceptions;

public class CustomerZIPCodeNotFourDigitsException extends RuntimeException {
    public CustomerZIPCodeNotFourDigitsException(String message) {
        super(message);
    }
}
