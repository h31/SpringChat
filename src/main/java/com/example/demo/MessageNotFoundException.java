package com.example.demo;

public class MessageNotFoundException extends RuntimeException {
    MessageNotFoundException(Long id) {
        super("Could not find message " + id);
    }
}
