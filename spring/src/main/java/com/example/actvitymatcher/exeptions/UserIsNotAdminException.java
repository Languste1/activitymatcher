package com.example.actvitymatcher.exeptions;

public class UserIsNotAdminException extends Throwable {
    public UserIsNotAdminException(String message) {
        super(message);
    }
}
