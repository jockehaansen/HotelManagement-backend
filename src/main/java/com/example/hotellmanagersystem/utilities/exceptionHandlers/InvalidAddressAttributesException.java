package com.example.hotellmanagersystem.utilities.exceptionHandlers;

public class InvalidAddressAttributesException extends RuntimeException{
    public InvalidAddressAttributesException(String message){
        super(message);
    }
}
