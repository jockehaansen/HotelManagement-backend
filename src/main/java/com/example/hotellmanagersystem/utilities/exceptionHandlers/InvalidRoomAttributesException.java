package com.example.hotellmanagersystem.utilities.exceptionHandlers;

public class InvalidRoomAttributesException extends RuntimeException{
    public InvalidRoomAttributesException(String message){
        super(message);
    }
}
