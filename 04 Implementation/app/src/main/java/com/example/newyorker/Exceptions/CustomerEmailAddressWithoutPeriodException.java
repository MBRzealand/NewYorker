package com.example.newyorker.Exceptions;

public class CustomerEmailAddressWithoutPeriodException extends RuntimeException {
    public CustomerEmailAddressWithoutPeriodException(String message) {
        super(message);
    }
}
