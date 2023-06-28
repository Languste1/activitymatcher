package com.example.actvitymatcher.exeptions;

public class UserDoesntExistException extends Exception{

    public UserDoesntExistException(String message) {
        super(message);
    }
}
