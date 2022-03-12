package com.is1423.musicplayerbackend.exception;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionTranslator extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(
        ResourceNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(commonReturnException(ex), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleBadCredentialsException(
        BadCredentialsException ex, WebRequest request) {
        return new ResponseEntity<>(commonReturnException(ex), HttpStatus.UNAUTHORIZED);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers,
        HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Param", "Not pass or Not valid");
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status,
        WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("RequestBody", "Not Exist or Not Valid");
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestAlertException.class)
    public ResponseEntity<Object> handleBadRequestAlertException(
        BadRequestAlertException ex, WebRequest request) {
        return new ResponseEntity<>(commonReturnException(ex), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentTypeMismatchException ex,
        WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("title", "API not Valid");
        body.put("field", "Not Correct");
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


    private Map<String, Object> commonReturnException(BaseException base) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("entityName", base.getEntityName());
        body.put("title", base.getTitle());
        body.put("errorKey", base.getErrorKey());
        return body;
    }
}
