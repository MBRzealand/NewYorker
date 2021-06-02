package com.example.newyorker.exceptions;

public class MissingCustomerZIPCodeException extends RuntimeException {
    public MissingCustomerZIPCodeException(String message) {
        super(message);
    }
}
