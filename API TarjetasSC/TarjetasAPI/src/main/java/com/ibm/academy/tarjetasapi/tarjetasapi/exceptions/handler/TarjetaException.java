package com.ibm.academy.tarjetasapi.tarjetasapi.exceptions.handler;

import com.ibm.academy.tarjetasapi.tarjetasapi.exceptions.BadRequestException;
import com.ibm.academy.tarjetasapi.tarjetasapi.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class TarjetaException
{
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> formatoInvalidoException(BadRequestException badRequestException)
    {
        Map<String,Object> respuesta =new HashMap<String,Object>();
        respuesta.put("error",badRequestException.getMessage());
        return  new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> formatoInvalidoException(NotFoundException notFoundException)
    {
        Map<String,Object> respuesta =new HashMap<String,Object>();
        respuesta.put("error",notFoundException.getMessage());
        return  new ResponseEntity<>(respuesta,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> paramTypeMismatch(MethodArgumentTypeMismatchException ex) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("message", "El tipo de dato que enviaste no coincide con el esperado");
        respuesta.put("param", ex.getName());
        respuesta.put("paramTypeExpected", ex.getParameter().getParameterType());
        respuesta.put("paramTypeGot", ex.getValue().getClass().getName());
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }
}
