package com.gestionReservas.GestionReservas.exceptions;

public class ResourceAlreadyBookedException extends RuntimeException{

    public ResourceAlreadyBookedException(String message){
        super(message);
    }

}
