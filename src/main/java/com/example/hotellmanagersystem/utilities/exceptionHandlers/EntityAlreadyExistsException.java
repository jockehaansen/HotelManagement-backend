package com.example.hotellmanagersystem.utilities.exceptionHandlers;

public class EntityAlreadyExistsException extends RuntimeException{
    public EntityAlreadyExistsException(String message){
        super(message);
    }
}
