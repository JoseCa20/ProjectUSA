package com.JeicTechnology.TCB.exception;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(){
        super("No autorizado");
    }
}
