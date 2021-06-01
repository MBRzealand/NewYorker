package com.example.newyorker.exceptions;

public class CustomerAddressContainsSpecialCharacterException extends RuntimeException {
    public CustomerAddressContainsSpecialCharacterException(String message) {
        super(message);
    }
}
