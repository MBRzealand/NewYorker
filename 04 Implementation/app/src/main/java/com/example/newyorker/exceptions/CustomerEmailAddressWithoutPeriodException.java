package com.example.newyorker.exceptions;

public class CustomerEmailAddressWithoutPeriodException extends RuntimeException {
    public CustomerEmailAddressWithoutPeriodException(String message) {
        super(message);
    }
}
