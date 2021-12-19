package com.teamyostrik.easystock.exceptions;

public class InvalidEntityExceptions extends RuntimeException{
    public InvalidEntityExceptions(String message) {
        super(message);
    }

    public InvalidEntityExceptions(String message, Throwable cause) {
        super(message, cause);
    }

}
