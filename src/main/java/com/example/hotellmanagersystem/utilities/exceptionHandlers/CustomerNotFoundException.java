package com.example.hotellmanagersystem.utilities.exceptionHandlers;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
