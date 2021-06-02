package com.example.newyorker.exceptions;

public class CustomerEmailAddressWithoutAtSignException extends RuntimeException {
    public CustomerEmailAddressWithoutAtSignException(String message) {
        super(message);
    }
}
