package com.example.actvitymatcher.exeptions;

public class PasswordDoesntExistException extends Exception {
    public PasswordDoesntExistException(String message) {
        super(message);
    }
}
