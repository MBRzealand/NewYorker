package com.example.newyorker.Exceptions;

public class MissingCustomerNameException extends RuntimeException {
    public MissingCustomerNameException(String message) {
        super(message);
    }
}
