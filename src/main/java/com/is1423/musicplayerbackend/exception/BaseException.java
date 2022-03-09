package com.is1423.musicplayerbackend.exception;

import lombok.Data;

@Data
public abstract class BaseException extends RuntimeException {

    private String entityName;

    private String title;

    private String errorKey;

    public BaseException(String entityName, String title, String errorKey) {
        super();
        this.entityName = entityName;
        this.title = title;
        this.errorKey = errorKey;
    }
}
