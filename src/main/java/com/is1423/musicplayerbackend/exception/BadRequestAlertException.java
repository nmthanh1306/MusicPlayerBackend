package com.is1423.musicplayerbackend.exception;

public class BadRequestAlertException extends BaseException {

    public BadRequestAlertException(String entityName, String title, String errorKey) {
        super(entityName, title, errorKey);
    }
}
