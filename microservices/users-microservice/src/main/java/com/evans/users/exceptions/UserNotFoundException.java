package com.evans.users.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String userId) {
        super("El usuario con el id: " + userId + " no existe");
    }
}
