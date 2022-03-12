package com.is1423.musicplayerbackend.exception;

public class BadCredentialsException extends BaseException{

    public BadCredentialsException(String entityName, String title, String errorKey) {
        super(entityName, title, errorKey);
    }
}
