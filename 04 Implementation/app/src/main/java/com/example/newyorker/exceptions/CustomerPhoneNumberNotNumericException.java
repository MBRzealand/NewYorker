package com.example.newyorker.exceptions;

public class CustomerPhoneNumberNotNumericException extends RuntimeException {
    public CustomerPhoneNumberNotNumericException(String message) {
        super(message);
    }
}
