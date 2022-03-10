package com.is1423.musicplayerbackend.exception;

public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(String entityName, String title, String errorKey){
        super(entityName, title, errorKey);
    };


}
