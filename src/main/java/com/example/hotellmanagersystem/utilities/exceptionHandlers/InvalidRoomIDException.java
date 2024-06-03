package com.example.hotellmanagersystem.utilities.exceptionHandlers;

public class InvalidRoomIDException extends RuntimeException{
    public InvalidRoomIDException(String message){
        super(message);
    }
}
