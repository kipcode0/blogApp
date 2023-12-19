package com.kipcode.blogapp.exceptions;

public class WriterAlreadyExistsException extends RuntimeException {
    public WriterAlreadyExistsException(String message) {
        super(message);
    }
}
