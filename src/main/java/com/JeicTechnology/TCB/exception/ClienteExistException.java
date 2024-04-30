package com.JeicTechnology.TCB.exception;

public class ClienteExistException extends  RuntimeException{
    public ClienteExistException() {
        super("El usuario ingresado ya se encuentra registrado.");
    }
}
