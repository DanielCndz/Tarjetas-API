package com.ibm.academy.tarjetasapi.tarjetasapi.exceptions;

public class BadRequestException extends RuntimeException
{
    public BadRequestException(String message){super(message);}
    private static final long serialVersionUID = 654360970904096548L;
}
