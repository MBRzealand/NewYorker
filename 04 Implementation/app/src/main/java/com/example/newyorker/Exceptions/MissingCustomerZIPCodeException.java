package com.example.newyorker.Exceptions;

public class MissingCustomerZIPCodeException extends RuntimeException {
    public MissingCustomerZIPCodeException(String message) {
        super(message);
    }
}
