package com.laurabarauna.controleVR.shared.exception;

import com.laurabarauna.controleVR.shared.exception.custom.IncorrectPasswordOrUsernameException;
import com.laurabarauna.controleVR.shared.exception.custom.UsernameUniqueException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        ErrorResponse response = new ErrorResponse("Validation failed", errors);

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(UsernameUniqueException.class)
    public ResponseEntity<ErrorResponse> handleUsernameUniqueException(UsernameUniqueException ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put("username", ex.getMessage());

        ErrorResponse response = new ErrorResponse("Username already exists", errors);

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put("entity", ex.getMessage());

        ErrorResponse response = new ErrorResponse("Entity not found", errors);

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(IncorrectPasswordOrUsernameException.class)
    public ResponseEntity<ErrorResponse> handleIncorrectPasswordOrUsernameException(IncorrectPasswordOrUsernameException ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put("auth", ex.getMessage());

        ErrorResponse response = new ErrorResponse("Bad Login", errors);
        return ResponseEntity.badRequest().body(response);
    }

}
