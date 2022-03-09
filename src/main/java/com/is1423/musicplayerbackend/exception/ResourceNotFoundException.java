package com.is1423.musicplayerbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import lombok.Data;

public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(String entityName, String title, String errorKey){
        super(entityName, title, errorKey);
    };


}
