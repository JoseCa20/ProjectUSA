package com.JeicTechnology.TCB.exception;

public class ClienteNotExistException extends RuntimeException {
    public ClienteNotExistException(){
        super("Cliente no existe");
    }
}
