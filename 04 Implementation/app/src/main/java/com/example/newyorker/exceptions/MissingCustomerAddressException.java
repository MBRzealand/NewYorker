package com.example.newyorker.exceptions;

public class MissingCustomerAddressException extends RuntimeException {
    public MissingCustomerAddressException(String message) {
        super(message);
    }
}
