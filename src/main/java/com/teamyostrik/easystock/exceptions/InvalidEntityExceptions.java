package com.teamyostrik.easystock.exceptions;

import lombok.Getter;

import java.util.List;

public class InvalidEntityExceptions extends RuntimeException{
    @Getter
    private ErrorCode errorCode;
    @Getter
    private List<String> errors;
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
    public InvalidEntityExceptions(String message , Throwable cause , ErrorCode errorCode, List<String> errors){
        super(message,cause);
        this.errorCode  = errorCode;
        this.errors = errors;
    }

    public InvalidEntityExceptions(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode  = errorCode;
    }
}
