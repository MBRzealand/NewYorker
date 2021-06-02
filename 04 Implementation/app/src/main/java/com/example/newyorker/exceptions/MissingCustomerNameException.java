package com.example.newyorker.exceptions;

public class MissingCustomerNameException extends RuntimeException {
    public MissingCustomerNameException(String message) {
        super(message);
    }
}
