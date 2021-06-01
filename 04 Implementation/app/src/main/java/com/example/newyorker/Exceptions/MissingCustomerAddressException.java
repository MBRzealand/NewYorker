package com.example.newyorker.Exceptions;

public class MissingCustomerAddressException extends RuntimeException {
    public MissingCustomerAddressException(String message) {
        super(message);
    }
}
