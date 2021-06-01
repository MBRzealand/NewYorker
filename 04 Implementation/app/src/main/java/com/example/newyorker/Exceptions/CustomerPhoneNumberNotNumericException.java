package com.example.newyorker.Exceptions;

public class CustomerPhoneNumberNotNumericException extends RuntimeException {
    public CustomerPhoneNumberNotNumericException(String message) {
        super(message);
    }
}
