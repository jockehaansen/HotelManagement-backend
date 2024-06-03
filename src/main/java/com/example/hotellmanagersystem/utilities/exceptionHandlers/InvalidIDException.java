package com.example.hotellmanagersystem.utilities.exceptionHandlers;

public class InvalidIDException extends RuntimeException{
    public InvalidIDException(String message){
        super(message);
    }
}
