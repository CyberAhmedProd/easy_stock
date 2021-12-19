package com.teamyostrik.easystock.exceptions;

public class InvalidEntityExceptions extends RuntimeException{
    private ErrorCode errorCode;
    public InvalidEntityExceptions(String message) {
        super(message);
    }
    public InvalidEntityExceptions(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidEntityExceptions(String message , Throwable cause , ErrorCode errorCode)
    {
        super(message,cause);
        this.errorCode = errorCode;
    }

}
