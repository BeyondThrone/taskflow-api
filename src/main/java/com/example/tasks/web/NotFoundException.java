package com.example.tasks.web;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}