package com.example.newyorker.Exceptions;

public class CustomerAddressContainsSpecialCharacterException extends RuntimeException {
    public CustomerAddressContainsSpecialCharacterException(String message) {
        super(message);
    }
}
