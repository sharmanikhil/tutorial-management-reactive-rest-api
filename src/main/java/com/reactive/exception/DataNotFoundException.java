package com.reactive.exception;

public class DataNotFoundException extends RuntimeException{
    private String message;

    public DataNotFoundException(String message){
        super(message);
    }
}
