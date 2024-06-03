package com.example.hotellmanagersystem.utilities.exceptionHandlers;

public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException(String message){
        super(message);
    }
}
