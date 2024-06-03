package com.example.hotellmanagersystem.utilities.exceptionHandlers;

public class InvalidCustomerAttributesException extends RuntimeException{
    public InvalidCustomerAttributesException(String message){
        super(message);
    }
}
