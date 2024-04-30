package com.JeicTechnology.TCB.exception;

public class PasswordIncorrectException extends RuntimeException {
    public PasswordIncorrectException(){
        super("Contraseña incorrecta");
    }
}
