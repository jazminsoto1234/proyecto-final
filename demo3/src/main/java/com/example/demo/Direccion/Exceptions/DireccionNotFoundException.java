package com.example.demo.Direccion.Exceptions;

public class DireccionNotFoundException extends RuntimeException {

    public DireccionNotFoundException(){
        super();
    }

    public DireccionNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public DireccionNotFoundException(String message){
        super(message);
    }

    public DireccionNotFoundException(Throwable cause){
        super(cause);
    }
}
