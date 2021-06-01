package com.example.newyorker.Exceptions;

public class CustomerZIPCodeNotNumericException extends RuntimeException {
    public CustomerZIPCodeNotNumericException(String message) {
        super(message);
    }
}
