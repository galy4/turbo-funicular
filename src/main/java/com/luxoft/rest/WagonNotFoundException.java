package com.luxoft.rest;

public class WagonNotFoundException extends RuntimeException{

    public WagonNotFoundException(String message) {
        super(message);
    }
}
