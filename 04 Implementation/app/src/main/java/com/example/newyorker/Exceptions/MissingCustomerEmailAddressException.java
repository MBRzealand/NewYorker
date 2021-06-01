package com.example.newyorker.Exceptions;

public class MissingCustomerEmailAddressException extends RuntimeException {
    public MissingCustomerEmailAddressException(String message) {
        super(message);
    }
}
