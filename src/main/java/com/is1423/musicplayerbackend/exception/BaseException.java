package com.is1423.musicplayerbackend.exception;

import lombok.Data;

@Data
public abstract class BaseException extends RuntimeException {

    private final String entityName;

    private final String title;

    private final String errorKey;

    protected BaseException(String entityName, String title, String errorKey) {
        super();
        this.entityName = entityName;
        this.title = title;
        this.errorKey = errorKey;
    }
}
