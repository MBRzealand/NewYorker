package com.example.newyorker.exceptions;

public class MissingCustomerPhoneNumberException extends RuntimeException {
    public MissingCustomerPhoneNumberException(String message) {
        super(message);
    }
}
