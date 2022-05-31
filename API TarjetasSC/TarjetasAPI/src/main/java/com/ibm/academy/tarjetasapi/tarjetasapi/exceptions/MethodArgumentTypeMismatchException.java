package com.ibm.academy.tarjetasapi.tarjetasapi.exceptions;

import com.ibm.academy.tarjetasapi.tarjetasapi.entities.Persona;

public class MethodArgumentTypeMismatchException extends RuntimeException
{
    public MethodArgumentTypeMismatchException(String message) {
        super(message);
    }

    private static final long serialVersionUID = -1344887964015052150L;
}
