package com.example.newyorker.Exceptions;

public class MissingCustomerPhoneNumberException extends RuntimeException {
    public MissingCustomerPhoneNumberException(String message) {
        super(message);
    }
}
