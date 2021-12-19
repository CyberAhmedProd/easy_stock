package com.teamyostrik.easystock.exceptions;

public class EntityNotFoundExceptions extends RuntimeException{
    private ErrorCode errorCode;
    public EntityNotFoundExceptions(String messsage)
    {
        super(messsage);
    }
    public EntityNotFoundExceptions(String messsage, Throwable cause)
    {
        super(messsage,cause);
    }
    public EntityNotFoundExceptions(String messsage, Throwable cause, ErrorCode errorCode)
    {
        super(messsage,cause);
        this.errorCode = errorCode;
    }
}
