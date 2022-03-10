package com.luxoft.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No wagon found")
public class NotFoundException extends RuntimeException{


    public NotFoundException(Class<?> clazz, int id) {
        super("Entity " + clazz.getName() + " with id='" + id + "' not found");
    }
}
