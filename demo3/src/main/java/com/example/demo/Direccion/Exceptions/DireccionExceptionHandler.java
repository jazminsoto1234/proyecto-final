package com.example.demo.Direccion.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DireccionExceptionHandler {

    @ExceptionHandler(DireccionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleDireccionNotFoundException(DireccionNotFoundException e) {
        return new ResponseEntity<>("La dirección no fue encontrada: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }


}
