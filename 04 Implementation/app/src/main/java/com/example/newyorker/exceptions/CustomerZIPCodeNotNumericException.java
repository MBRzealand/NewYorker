package com.example.newyorker.exceptions;

public class CustomerZIPCodeNotNumericException extends RuntimeException {
    public CustomerZIPCodeNotNumericException(String message) {
        super(message);
    }
}
