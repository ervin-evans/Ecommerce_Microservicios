package com.evans.users.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    
    /******************************************************************************************************************
     *                                        PRODUCT NOT FOUND EXCEPTION
     ******************************************************************************************************************/
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(UserNotFoundException e) {
        LOG.warn(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

    }

    /******************************************************************************************************************
     *                                       VALIDATION MESSAGES EXCEPTION
     ******************************************************************************************************************/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationException(MethodArgumentNotValidException e) {
        LOG.warn("Hay errores en la validacion de la informacion");
        List<String> validationErrors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();
        return ResponseEntity.badRequest().body(validationErrors);
    }


}
