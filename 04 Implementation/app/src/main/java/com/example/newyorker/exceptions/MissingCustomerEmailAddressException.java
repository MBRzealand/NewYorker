package com.example.newyorker.exceptions;

public class MissingCustomerEmailAddressException extends RuntimeException {
    public MissingCustomerEmailAddressException(String message) {
        super(message);
    }
}
