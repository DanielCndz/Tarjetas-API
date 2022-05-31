package com.ibm.academy.api.card.exceptions;

public class BadRequestException extends RuntimeException
{
    public BadRequestException(String message){super(message);}
    private static final long serialVersionUID = 654360970904096548L;
}
