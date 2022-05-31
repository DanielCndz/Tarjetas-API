package com.ibm.academy.api.card.exceptions;

public class NotFoundException extends RuntimeException
{
    public NotFoundException(String message){super(message);}
    private static final long serialVersionUID = 7672238157166921380L;
}
