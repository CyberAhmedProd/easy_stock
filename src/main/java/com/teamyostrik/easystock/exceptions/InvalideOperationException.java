package com.teamyostrik.easystock.exceptions;


import lombok.Getter;

public class InvalideOperationException extends RuntimeException {
    @Getter
    private ErrorCode errorCode;
    public InvalideOperationException(String message)
    {
        super(message);
    }
    public InvalideOperationException(String message, Throwable cause)
    {
        super(message,cause);
    }
    public InvalideOperationException(String message, Throwable cause,ErrorCode errorCode)
    {
        super(message,cause);
        this.errorCode = errorCode;
    }
    public InvalideOperationException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
