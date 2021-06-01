package com.example.newyorker.Exceptions;

public class CustomerEmailAddressWithoutAtSignException extends RuntimeException {
    public CustomerEmailAddressWithoutAtSignException(String message) {
        super(message);
    }
}
